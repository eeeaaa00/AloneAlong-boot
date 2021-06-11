package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"sessionFoodCart"})
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
	//가게 선택 resId로
	@RequestMapping("/eating/{resId}")
	public String resFood(
			@PathVariable("resId") String resId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
//			@RequestParam(value = "foodId", defaultValue="") String foodId,
			ModelMap model) throws Exception {
		
//		if(foodId != "") {
//			if (cart.containsFoodId(foodId)) {
//				cart.incrementQuantityByFoodId(foodId);
//			}
//			else {
//				Food item = this.alonealong.getFood(foodId);
//				if(item == null)
//					System.out.println("null들어왔다");
//				cart.addFood(item);
//			}	
//		}
//		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId);
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId); //지금만 다 불러오지 나중엔 resId 걸리는 것만 불러와야해
//		FoodCart foodCart = this.alonealong.getFoodCart(resId);
		model.put("foodList", foodList);
		model.put("foodCart", foodCart.getFoodItemList());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("restaurant", res);
		model.put("totalPrice", foodCart.getSubTotal());
		System.out.println(foodCart.getFoodItemList().size());
		return "restaurant";
		
//		return "/eating/Food";
	}
	
	//리뷰탭
	@RequestMapping("/eating/{resId}/RestaurantReview")
	public String handleRequest2(
			@PathVariable("resId") String resId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
			ModelMap model) throws Exception {
//		List<FoodReview> reviewList = this.alonealong.getFoodReviewList(resId);
//		FoodCart foodCart = this.alonealong.getFoodCart(resId);
//		model.put("foodList", reviewList);
		model.put("foodCart", foodCart.getFoodItemList());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("restaurant", res);
		model.put("totalPrice", foodCart.getSubTotal());
//		return "/eating/RestaurantReview";
		model.put("resId", resId);
		return "restaurantReview";
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
