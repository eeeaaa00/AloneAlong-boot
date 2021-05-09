package com.dwu.alonealong.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class InsertCartItemController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/cart/insert/{productId}/{quantity}")
	public String handleRequest(@PathVariable(value="productId") String productId,
			@PathVariable(value="quantity") int quantity, 
			ModelMap model) throws Exception {
		//로그인 구현 전까지 임시
		String userId = "1";
		model.put("insertCart", true);
		
		aloneAlong.insertCartItem(productId, quantity, userId);
		return "forward:/shop/" + productId;
	}

}