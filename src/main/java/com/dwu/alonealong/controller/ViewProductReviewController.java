package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

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
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class ViewProductReviewController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/{productId}/review")
	public String handleRequest(HttpServletRequest request,
			@PathVariable("productId") String productId,
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="sortType", defaultValue="new") String sortType,
			@RequestParam(value="quantity", defaultValue="1") int quantity,  
			ModelMap model) throws Exception {
		String userId = " ";
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession != null) {
			userId = userSession.getUser().getId();
			model.put("isPurchaser", aloneAlong.checkUsersOrder(userId, productId));
		}
		
		String sortTypeName = "최신순";
		switch(sortType) {
			case "recommend" : sortTypeName = "추천순"; break;
			case "lowRating" : sortTypeName = "낮은 평점순"; break;
			case "highRating" : sortTypeName = "높은 평점순"; break;
		}

		Product product = this.aloneAlong.getProduct(productId);
		List<ProductReview> reviewList = this.aloneAlong.getProductReviewList(productId, sortType, userId);
		
		if(reviewList.size() > 0) {
			model.put("numOfReviews", this.aloneAlong.numOfReviews(productId));
			model.put("averageOfReviews", this.aloneAlong.averageOfReviews(productId));
			model.put("mostRatingOfReviews", this.aloneAlong.mostRatingOfReviews(productId));
		}
		else {
			model.put("numOfReviews", "0");
			model.put("averageOfReviews", "0");
			model.put("mostRatingOfReviews", "0");
		}
//		PagedListHolder<ProductReview> reviewList = new PagedListHolder<ProductReview>(this.aloneAlong.getReviewsByProductId(productId, sortType));
//		reviewList.setPageSize(3);
//		reviewList.setPage(page);

		Encoder encoder = Base64.getEncoder();
        byte[] imagefile = product.getProductImg();
        if(imagefile != null){
        	String encodedString = encoder.encodeToString(imagefile);
            product.setImg64(encodedString);
        }
		product.setQuantity(quantity);
		model.put("product", product);
		model.put("pcId", product.getPcId());
		model.put("reviewList", reviewList);
		model.put("sortTypeName", sortTypeName);
		
		//로그인 완성 후 수정 필요
		model.put("userId", userId);
		return "productReview";
	}

}