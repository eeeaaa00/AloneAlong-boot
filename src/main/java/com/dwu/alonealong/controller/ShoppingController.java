package com.dwu.alonealong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
	@RequestMapping(value = "/shopping")
	public ModelAndView productList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/shopping/productList");
		return mav;
	}
	
	@RequestMapping(value = "/shopping/{id}")
	public ModelAndView productInfo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/shopping/product");
		return mav;
	}
	
	@RequestMapping(value = "/shopping/{id}/review")
	public ModelAndView productReview() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/shopping/productReview");
		return mav;
	}
	
	@RequestMapping(value = "/shopping/cart")
	public ModelAndView productCart() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/shopping/productCart");
		return mav;
	}
	
	@RequestMapping(value = "/order")
	public ModelAndView order() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/order");
		return mav;
	}
}
