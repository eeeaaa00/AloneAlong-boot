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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;
import com.dwu.alonealong.service.FoodService;
import com.dwu.alonealong.service.RestaurantService;

@Controller
@RequestMapping("/eating/{resId}/adminFood")
//@RequestMapping("/eating/adminFood")
public class FoodController {
	
	private static final String FOOD_INSERT_FORM = "eating/FoodForm";
	
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	@RequestMapping(method = RequestMethod.GET) // 아 왜 foodform으로 안넘어가는거야 r2?가 post라서 그런건가 했는데 아
	public String form(@ModelAttribute("food") FoodForm foodForm, @PathVariable("resId") String resId) {
		return "foodForm";
//		return "thyme/restaurant/foodForm";
//		return FOOD_INSERT_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("food") FoodForm foodForm,
			@PathVariable("resId") String resId,
//			BindingResult bindingResult,
			Model model) {
		
		Food food = new Food(resId, "FOOD_ID.NEXTVAL", foodForm.getName(), foodForm.getPrice(), foodForm.getDescription(), null, foodForm.getMaxPeopleNum());
		alonealong.insertFood(food);
		
		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
		model.addAttribute("foodList", foodList);
//		return "eating/Food";
		return "redirect:/eating/{resId}";
//		return form;
	}
	
	
}
