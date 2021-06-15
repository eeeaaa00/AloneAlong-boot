package com.dwu.alonealong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewMypageController {
	
	@RequestMapping("/myOrder")
	public String order() {
		return "myOrder"; 
	}
	
	@RequestMapping("/myResOrder")
	public String Resorder() {
		return "myResOrder"; 
	}
	
	@RequestMapping("/myTogetherOrder")
	public String Togorder() {
		return "myTogetherOrder"; 
	}


	@RequestMapping(value = "/myFood")
	public ModelAndView myFood() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myFood");
		return mav;
	}

	@RequestMapping(value = "/myTogether")
	public ModelAndView myTogether() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myTogether");
		return mav;
	}

	@RequestMapping(value = "/myRestaurant")
	public ModelAndView myRestaurant() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myRestaurant");
		return mav;
	}
}
