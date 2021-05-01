package com.dwu.alonealong.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ViewIndexController {
	public String now() {
		return "index"; 
	}

}
