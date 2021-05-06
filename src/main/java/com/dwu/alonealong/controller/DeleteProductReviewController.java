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
public class DeleteProductReviewController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/{productId}/review/delete")
	public RedirectView handleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@PathVariable("productId") String productId,
			@RequestParam(value="product") Product product,
			@PathVariable("reviewId") String reviewId,
			ModelMap model) throws Exception {
		//동일한 user인지 검사하는 과정 필요
		//결과값 검사 추가 필요
		this.aloneAlong.deleteProductReview(reviewId);
		return new RedirectView("/shop/{productId}/review");
	}

}