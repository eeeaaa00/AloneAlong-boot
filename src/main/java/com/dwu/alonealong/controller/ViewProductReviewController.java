package com.dwu.alonealong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"product"})
public class ViewProductReviewController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/{productId}/review")
	public String handleRequest(@PathVariable("productId") String productId,
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="sortType", defaultValue="latest") String sortType,
			@RequestParam(value="quantity", defaultValue="1") int quantity,  
			ModelMap model) throws Exception {
		Product product = this.aloneAlong.getProduct(productId);
		product.setQuantity(quantity);
		model.put("product", product);
//		PagedListHolder<ProductReview> reviewList = new PagedListHolder<ProductReview>(this.aloneAlong.getReviewsByProductId(productId, sortType));
//		reviewList.setPageSize(3);
//		reviewList.setPage(page);
//		model.put("product", aloneAlong.getProduct(productId));
//		model.put("reviewList", reviewList);
		return "productReview";
	}

}