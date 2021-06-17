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
public class InsertProductReviewController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/review/insert")
	public String handleRequest(HttpServletRequest request,
//			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam(value="productId") String productId,
			@RequestParam(value="rating") int rating,
			@RequestParam(value="contents") String contents, 
			ModelMap model) throws Exception {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		String userId = userSession.getUser().getId();
		if(!aloneAlong.checkUsersOrder(userId, productId)) {
			return "redirect:/error";
		}
		
		ProductReview productReview = new ProductReview();
		productReview.setUserId(userId);
		productReview.setProductId(productId);
		productReview.setRating(rating);
		productReview.setReviewContents(contents);
		
		this.aloneAlong.insertProductReview(productReview);
		return "redirect:/shop/" + productId + "/review";
	}

}