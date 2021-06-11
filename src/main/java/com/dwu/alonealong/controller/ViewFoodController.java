package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.Base64.*;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	
	//가게 선택 resId로
	@RequestMapping("/eating/{resId}")
	public String resFood(
			@PathVariable("resId") String resId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
			HttpServletResponse response,
//			@RequestParam(value = "foodId", defaultValue="") String foodId,
			ModelMap model) throws Exception {

		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId); 
		model.put("foodList", foodList);
		model.put("foodCart", foodCart.getFoodItemList());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		
		model.put("totalPrice", foodCart.getSubTotal());
		System.out.println(foodCart.getFoodItemList().size());
		
		Encoder encoder = Base64.getEncoder();
		byte[] imagefile;
		String encodedString;
        for(Food food : foodList) {
        	imagefile = food.getImgFile();
            encodedString = encoder.encodeToString(imagefile);
            food.setImg64(encodedString);
      
        }
        imagefile = res.getImgFile();
        encodedString = encoder.encodeToString(imagefile);
        res.setImg64(encodedString);
        model.put("restaurant", res);
        
		return "restaurant";

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
	

		
}
