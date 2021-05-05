package com.dwu.alonealong.controller;

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
	
	@RequestMapping("/shop/{productId}/review/write")
	public RedirectView handleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@PathVariable("productId") String productId,
			@RequestParam(value="product") Product product,
			@RequestParam(value="rating") int rating,
			@RequestParam(value="contents") String contents, 
			ModelMap model) throws Exception {
		//product를 구매한 user인지 검사하는 과정 추가 필요
		ProductReview productReview = new ProductReview(productId, userSession.getAccount().getUserId(), contents, rating);
		this.aloneAlong.insertProductReview(productReview);
		return new RedirectView("/shop/{productId}/review");
	}

}