package com.dwu.alonealong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class JoinTogetherController {

	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	//신청하기
	@RequestMapping("/together/togetherPay")
	public String joinTogether(
//			ModelMap model
			) throws Exception {

//		model.put("together", together);
		return "/together/togetherPay";
	}

}
