package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dwu.alonealong.domain.Order;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class TogetherDeleteController {
	private AloneAlongFacade aloneAlong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@GetMapping("/togetherRegister/delete/{togetherId}")
	public String deleteTogether(
			HttpServletRequest request,
			@PathVariable("togetherId") String togId,
			ModelMap model) {
		aloneAlong.deleteTogetherFood(togId); //음식 리스트 삭제
		
		aloneAlong.deleteTogetherMember(togId); //멤버 삭제
		
		//OrderInfo 삭제
		String orderId = aloneAlong.getTogetherOrderByTogId(togId).get(0).getOrderId();
		aloneAlong.deleteTogetherOrderInfo(orderId);
		
		//TogetherOrder 삭제
		aloneAlong.deleteTogetherOrder(togId);
		
		aloneAlong.deleteTogether(togId); //together 삭제
		
		List<Together> togetherList = aloneAlong.getTogetherList();
		model.addAttribute("togetherList", togetherList);
		
		return "redirect:/together";
	}
	
}
