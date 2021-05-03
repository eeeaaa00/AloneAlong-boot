package com.dwu.alonealong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewIndexController {
	
	@RequestMapping("/")
	public String now() {
		return "index"; 
	}

}
