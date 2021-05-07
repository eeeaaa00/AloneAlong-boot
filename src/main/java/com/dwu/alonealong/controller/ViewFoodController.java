package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;
import com.dwu.alonealong.service.FoodService;
import com.dwu.alonealong.service.RestaurantService;

@Controller
@SessionAttributes({"sessionFoodCart","foodList"})
public class ViewFoodController {
	private AloneAlongFacade alonealong;
		
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	//db전까지 사용
	@Autowired
	private RestaurantService resService;
	public void setRestaurantService(RestaurantService resService) {
		this.resService = resService;
	}	
	@Autowired
	private FoodService foodService;	
	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
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
	//가게 선택 resId로
	@RequestMapping("/eating/{resId}")
	public String resFood(
			@PathVariable("resId") String resId,
			ModelMap model) throws Exception {
//		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId);
		List<Food> foodList = this.foodService.getFoodList(); //지금만 다 불러오지 나중엔 resId 걸리는 것만 불러와야해
//		FoodCart foodCart = this.alonealong.getFoodCart(resId);
		model.put("foodList", foodList);
//		model.put("foodCart", foodCart);
		Restaurant res = resService.getRestaurantByResId(resId);
		model.put("restaurant", res);
//		return "foodTest";
		return "/eating/Food";
	}
	
	//리뷰탭
	@RequestMapping("/eating/{redId}/RestaurantReview")
	public String handleRequest2(
//			@RequestParam("resId") String resId,
			ModelMap model) throws Exception {
//		List<FoodReview> reviewList = this.alonealong.getFoodReviewList(resId);
//		FoodCart foodCart = this.alonealong.getFoodCart(resId);
//		model.put("foodList", reviewList);
//		model.put("foodCart", foodCart);
		return "/eating/RestaurantReview";
	}
	//메뉴수정버튼
		@RequestMapping("/eating/viewFood/{foodId}/adminFood")
		public String handleRequest3(
//				@RequestParam("resId") String resId,
				ModelMap model) throws Exception {
//			List<FoodReview> reviewList = this.alonealong.getFoodReviewList(resId);
//			FoodCart foodCart = this.alonealong.getFoodCart(resId);
//			model.put("foodList", reviewList);
//			model.put("foodCart", foodCart);
			return "/eating/FoodForm";
		}
		
}
