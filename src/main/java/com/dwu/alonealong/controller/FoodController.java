package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.FoodService;
import com.dwu.alonealong.service.RestaurantService;

@Controller
@RequestMapping("/eating/{resId}/adminFood")
//@RequestMapping("/eating/adminFood")
public class FoodController {
	
	private static final String FOOD_INSERT_FORM = "eating/FoodForm";
	
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
	
	@RequestMapping(method = RequestMethod.GET) // 아 왜 foodform으로 안넘어가는거야 r2?가 post라서 그런건가 했는데 아
	public String form(@ModelAttribute("food") FoodForm foodForm, @PathVariable("resId") String resId) {
		return FOOD_INSERT_FORM;
	}
	
//	@RequestMapping(method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("food") FoodForm foodForm,
//			BindingResult bindingResult,
			Model model) {
		
		String foodId = foodService.insertNewFood(foodForm);
		model.addAttribute("foodId", foodId);
		
		List<Food> foodList = foodService.getFoodList();
		model.addAttribute("foodList", foodList);
//		return "eating/Food";
//		return "test";
		return "/eating/Restaurant";
//		String form = "/eating/" + resId;
//		if(resId == null)
//			System.out.println("null 떴다");
//		return form;
	}
	
	
}
