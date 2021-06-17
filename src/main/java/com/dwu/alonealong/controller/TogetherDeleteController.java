package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class TogetherDeleteController {
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	@GetMapping("/togetherRegister/delete/{togetherId}")
	public String deleteTogether(
			HttpServletRequest request,
			@PathVariable("togetherId") String togId,
			ModelMap model) {
		//음식 리스트 삭제
		alonealong.deleteTogetherFood(togId);
		
		//멤버 삭제
		alonealong.deleteTogetherMember(togId);
		
		//together 삭제
		alonealong.deleteTogether(togId);
		
		List<Together> togetherList = alonealong.getTogetherList();
		model.addAttribute("togetherList", togetherList);
		
		return "redirect:/together";
	}
	
}
