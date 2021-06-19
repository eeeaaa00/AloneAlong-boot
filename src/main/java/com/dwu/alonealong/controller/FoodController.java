package com.dwu.alonealong.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;
import com.dwu.alonealong.service.FoodFormValidator;
import com.dwu.alonealong.service.RestaurantFormValidator;

@Controller
@RequestMapping("/eating/{resId}/adminFood")
//@RequestMapping("/eating/adminFood")
public class FoodController {
	
	//사용x
	private static final String FOOD_INSERT_FORM = "eating/FoodForm";
	
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(
			@ModelAttribute("food") FoodForm foodForm, 
			@PathVariable("resId") String resId) {
		return "foodForm";
//		return "thyme/restaurant/foodForm";
//		return FOOD_INSERT_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("food") FoodForm foodForm,
			BindingResult result,
			@PathVariable("resId") String resId,
			Model model) {
		
		new FoodFormValidator().validate(foodForm, result); // 검증 실행
		if (result.hasErrors()) { 
			// 검증 오류 발생 시
			return "foodForm"; 
		}
		
		
		MultipartFile mf = foodForm.getImgFile();
		byte[] img = null;
		try {
			img = mf.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Food food = new Food(resId, "FOOD_ID.NEXTVAL", foodForm.getName(), foodForm.getPrice(), foodForm.getDescription(), img, foodForm.getMaxPeopleNum());
		alonealong.insertFood(food);
		
		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
		model.addAttribute("foodList", foodList);
//		return "eating/Food";
		return "redirect:/eating/{resId}";
//		return form;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET) 
	public String form2(
			@RequestParam("foodId") String foodId,
			@ModelAttribute("food") FoodForm foodForm, 
			@PathVariable("resId") String resId,
			Model model) {
		System.out.println("update");
		Food foodData = alonealong.getFood(foodId);
		
		
		Encoder encoder = Base64.getEncoder();
		byte[] imagefile;
		String encodedString;
        imagefile = foodData.getImgFile();
        encodedString = encoder.encodeToString(imagefile);
        foodData.setImg64(encodedString);
		
		
		model.addAttribute("food", foodData);
		return "foodForm";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			@RequestParam("foodId") String foodId,
			@ModelAttribute("food") FoodForm foodForm,
			@PathVariable("resId") String resId,
			BindingResult result,
			Model model) {
		
		new FoodFormValidator().validate(foodForm, result); // 검증 실행
		if (result.hasErrors()) { 
			// 검증 오류 발생 시
			return "foodForm"; 
		}
		
		Food food;
		if(foodForm.getImgFile() == null)
			food = new Food(resId, foodId, foodForm.getName(), foodForm.getPrice(), foodForm.getDescription(), null, foodForm.getMaxPeopleNum());
		else {
			MultipartFile mf = foodForm.getImgFile();
			byte[] img = null;
			try {
				img = mf.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			food = new Food(resId, foodId, foodForm.getName(), foodForm.getPrice(), foodForm.getDescription(), img, foodForm.getMaxPeopleNum());
		}
			
		alonealong.updateFood(food);
		
		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
		model.addAttribute("foodList", foodList);
		return "redirect:/eating/{resId}";
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
