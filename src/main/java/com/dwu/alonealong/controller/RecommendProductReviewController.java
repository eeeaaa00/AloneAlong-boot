package com.dwu.alonealong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"product", "userSession"})
public class RecommendProductReviewController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/{productId}/review/recommend/{reviewId}")
	public String handleRequest(HttpServletRequest request,
//			@ModelAttribute("userSession") UserSession userSession,
			@PathVariable("productId") String productId,
			@PathVariable("reviewId") String reviewId,
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="sortType", defaultValue="new") String sortType,
			@RequestParam(value="quantity", defaultValue="1") int quantity,
			ModelMap model) throws Exception {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		String userId = userSession.getUser().getId();
		
		//자신의 리뷰 추천 여부 검사
		ProductReview productReview = aloneAlong.getProductReview(reviewId, userId);
		if (productReview.getUserId().equals(userId)) {
			return "redirect:/shop/{productId}/review?quantity=" + quantity + "&page=" + page + "&sortType=" + sortType + "&recommendError=true";
		}
		else {
			if(productReview.getCheckRecommend() == false) {
				productReview.increaseRecommend();
				aloneAlong.updateProductReview(productReview);
				aloneAlong.insertProductReviewRecommend(productReview.getReviewId(), userId);
			}
			else {
				productReview.decreaseRecommend();
				aloneAlong.updateProductReview(productReview);
				aloneAlong.deleteProductReviewRecommend(productReview.getReviewId(), userId);
			}
		}
		return "redirect:/shop/{productId}/review";
	}

}