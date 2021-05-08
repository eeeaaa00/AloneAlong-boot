package com.dwu.alonealong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//formController 완성전까지 임시용
@Controller
public class RegisterTogetherController {
	@RequestMapping(value = "/together/togetherRegister")
	public ModelAndView registerTogether() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/together/togetherRegister");
		return mav;
	}
}
