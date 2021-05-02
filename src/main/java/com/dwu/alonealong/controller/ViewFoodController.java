package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"sessionFoodCart","foodList"})
public class ViewFoodController {
	private AloneAlongFacade alonealong;
		
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	//메뉴탭
	@RequestMapping("/eating/viewFood")
	public String handleRequest(
//			@RequestParam("resId") String resId,
			ModelMap model) throws Exception {
//		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId);
//		FoodCart foodCart = this.alonealong.getFoodCart(resId);
//		model.put("foodList", foodList);
//		model.put("foodCart", foodCart);
		return "/eating/Food";
	}
	
	//리뷰탭
	@RequestMapping("/eating/viewFood2.do")
	public String handleRequest2(
			@RequestParam("resId") String resId,
			ModelMap model) throws Exception {
		List<FoodReview> reviewList = this.alonealong.getFoodReviewList(resId);
		FoodCart foodCart = this.alonealong.getFoodCart(resId);
		model.put("foodList", reviewList);
		model.put("foodCart", foodCart);
		return "Restaurant";
	}
		
}
