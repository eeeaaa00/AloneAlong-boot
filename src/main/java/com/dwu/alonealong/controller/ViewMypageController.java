package com.dwu.alonealong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewMypageController {

	@RequestMapping(value = "/mypage")
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myInfo");
		return mav;
	}
	
	@RequestMapping(value = "/myPayment")
	public ModelAndView myPayment() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myPayment");
		return mav;
	}
	
	@RequestMapping(value = "/myOrder")
	public ModelAndView myOrder() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myOrder");
		return mav;
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
