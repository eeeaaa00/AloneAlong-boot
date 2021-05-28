package com.dwu.alonealong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class JoinTogetherController {

	private AloneAlongFacade aloneAlong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	//신청하기
	@RequestMapping("/togetherOrder")
	public String joinTogether(
//			ModelMap model
		) throws Exception {
		
		return "together/togetherOrder";
	}
	
//	@RequestMapping(value = "/togetherOrder")
//	public String togetherOrderTest() {
//		return "togetherOrder";
//	}

}
