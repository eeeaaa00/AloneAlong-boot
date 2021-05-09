package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.RestaurantService;

@Controller
@RequestMapping("/eating/adminRes")
public class RestaurantController {
	
	private static final String RES_INSERT_FORM = "eating/RestaurantForm";
	
	@Autowired
	private RestaurantService resService;
	
	public void setRestaurantService(RestaurantService resService) {
		this.resService = resService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("restaurant") RestaurantForm resForm) {
		return RES_INSERT_FORM;
//		return "thyme/restaurant/restaurantForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("restaurant") RestaurantForm resForm,
//			BindingResult bindingResult,
			Model model) {
			
		String resId = resService.insertNewRestaurant(resForm);
		model.addAttribute("resId", resId);
		
		List<Restaurant> restaurantList = resService.getRestaurantList();
		model.addAttribute("restaurantList", restaurantList);
//		return "eating/Food";
//		return "test";
		return "restaurantList";
//		String form = "/eating/" + resId;
//		if(resId == null)
//			System.out.println("null 떴다");
//		return form;
	}
	
	
}
