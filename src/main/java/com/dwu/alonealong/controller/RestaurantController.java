package com.dwu.alonealong.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@RequestMapping("/eating/adminRes")
public class RestaurantController {
	
	private static final String RES_INSERT_FORM = "restaurantForm";

	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
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
			Model model) throws MalformedURLException {
		
		Restaurant res;
		if(resForm.getImgFile() == null) {
			res = new Restaurant("RES_ID.NEXTVAL", resForm.getResName(), resForm.getResAddress(), resForm.getResPhone(), "user1",
					resForm.getResDescription(), 0.0, resForm.getCategoryId(), null, resForm.getIsTogetherOk());
		}else {
			MultipartFile mf = resForm.getImgFile();
			byte[] img = null;
			try {
				img = mf.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			res = new Restaurant("RES_ID.NEXTVAL", resForm.getResName(), resForm.getResAddress(), resForm.getResPhone(), "user1",
					resForm.getResDescription(), 0.0, resForm.getCategoryId(), img, resForm.getIsTogetherOk());
		}
		alonealong.insertRestaurant(res);
		
		List<Restaurant> restaurantList = alonealong.getRestaurantList();
		model.addAttribute("restaurantList", restaurantList);

		return "redirect:/eating";

	}
	
	
}
