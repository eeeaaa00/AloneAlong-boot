package com.dwu.alonealong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewTestController {

	@RequestMapping("/")
	public String now() {
		return "index"; 
	}

	@RequestMapping("/product")
	public String product() {
		return "product"; 
	}
	
//	@RequestMapping(value = "/shopping")
//	public ModelAndView productList() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/productList");
//		return mav;
//	}
	
//	@RequestMapping(value = "/shopping/{id}")
//	public ModelAndView productInfo() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/product");
//		mav.setViewName("/product");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/shopping/{id}/review")
//	public ModelAndView productReview() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/productReview");
//		mav.setViewName("/productReview");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/shopping/cart")
//	public ModelAndView productCart() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/productCart");
//		return mav;
//	}

	@RequestMapping(value = "/shopping")
	public String productList() {
		return "productList";
	}
	
	@RequestMapping(value = "/shopping/{id}")
	public String productInfo() {
		return "product";
	}
	
	@RequestMapping(value = "/shopping/{id}/review")
	public String productReview() {
		return "productReview";
	}
	
	@RequestMapping(value = "/shopping/cart")
	public String productCart() {
		return "productCart";
	}
	
	@RequestMapping(value = "/order")
	public ModelAndView order() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/order");
		return mav;
	}
	
	@RequestMapping(value = "/orderTest")
	public String orderTest() {
		return "order_layout";
	}
	
	@RequestMapping(value = "/productOrderTest")
	public String productOrderTest() {
		return "productOrder";
	}
	
	@RequestMapping(value = "/togetherOrderTest")
	public String togetherOrderTest() {
		return "togetherOrder";
	}
}
