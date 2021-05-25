package com.dwu.alonealong.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;
import com.dwu.alonealong.service.RestaurantService;

@Controller
@RequestMapping("/eating/adminRes")
public class RestaurantController {
	
	private static final String RES_INSERT_FORM = "restaurantForm";

	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
//	@Autowired
//	private RestaurantService resService;
//	
//	public void setRestaurantService(RestaurantService resService) {
//		this.resService = resService;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("restaurant") RestaurantForm resForm) {
		return RES_INSERT_FORM;
//		return "thyme/restaurant/restaurantForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("restaurant") RestaurantForm resForm,
//			BindingResult bindingResult,
			Model model) throws MalformedURLException {
//		Restaurant res = new Restaurant("r" + nextResId, resForm.getResName(),
//				resForm.getCategoryId(), resForm.getResAddress());
		
		Restaurant res = new Restaurant("RES_ID.NEXTVAL", resForm.getResName(), resForm.getResAddress(), resForm.getResPhone(), "user1",
				resForm.getResDescription(), 0.0, resForm.getCategoryId(), new URL("http://naver.com"), resForm.getIsTogetherOk());

		alonealong.insertRestaurant(res);
		
		List<Restaurant> restaurantList = alonealong.getRestaurantList();
		model.addAttribute("restaurantList", restaurantList);
//		return "eating/Food";
//		return "test";
		return "redirect:/eating";
//		String form = "/eating/" + resId;
//		if(resId == null)
//			System.out.println("null 떴다");
//		return form;
	}
	
	
}
