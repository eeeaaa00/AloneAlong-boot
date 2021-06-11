package com.dwu.alonealong.controller;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Review;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@RequestMapping("/eating/{resId}/adminReview")
public class FoodReviewController {
		
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public String insert(
//			@ModelAttribute("food") FoodForm foodForm,
			@PathVariable("resId") String resId,
//			BindingResult bindingResult,
			Model model) {
		
		Review review = new Review(); //여기에 정보 채워넣기
//		Food food = new Food(resId, "FOOD_ID.NEXTVAL", foodForm.getName(), foodForm.getPrice(), foodForm.getDescription(), null, foodForm.getMaxPeopleNum());
//		alonealong.insertFood(food);
		
		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
		model.addAttribute("foodList", foodList);
//		return "eating/Food";
		return "redirect:/eating/{resId}";
//		return form;
	}
	
	@RequestMapping(value = "/delete")
	public String delete(
			@RequestParam("foodId") String foodId,
			@PathVariable("resId") String resId,
//			BindingResult bindingResult,
			Model model) {
		
		alonealong.deleteFood(foodId);
		
		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
		model.addAttribute("foodList", foodList);
		return "redirect:/eating/{resId}";
	}
	
	
}
