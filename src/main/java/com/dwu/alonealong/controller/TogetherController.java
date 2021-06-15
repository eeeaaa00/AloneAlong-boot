package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@RequestMapping("/togetherRegister")
public class TogetherController {
	private static final String TOGETHER_INSERT_FORM = "together/togetherRegister";
	
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String form(@ModelAttribute("Together") TogetherForm togetherForm) {
//		return TOGETHER_INSERT_FORM;
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("together") TogetherForm togetherForm,
			Model model) {
		
		//together 넣기
		Together together = new Together("TOGETHER_ID.NEXTVAL", togetherForm.getTogetherName(), togetherForm.getHeadCount(), togetherForm.getTogetherDate(), togetherForm.getTogetherTime(),
				togetherForm.getSex(), togetherForm.getAge(), togetherForm.getTogetherDes(), togetherForm.getResId(), togetherForm.getStatus(), togetherForm.getPrice());
		alonealong.insertTogether(together);
		
		//음식 넣기(구현중)
		for(int i = 0; i < togetherForm.getFoodCart().getFoodItemList().size(); i++) {
			TogetherFood togetherFood = new TogetherFood("TOGFOOD_ID.NEXTVAL", together.getTogetherId(), togetherForm.getFoodCart().getFoodItemList().get(i).getFood().getFoodId(), togetherForm.getFoodCart().getFoodItemList().get(i).getQuantity());
			alonealong.insertTogetherFood(togetherFood);
		}
		
		//멤버 넣기(유저세션의 유저)
		TogetherMember togetherMember = new TogetherMember("TOGMEM_ID.NEXTVAL", togetherForm.getUserId(), together.getTogetherId(), 1);
		alonealong.insertTogetherMember(togetherMember);
		
		List<Together> togetherList = alonealong.getTogetherList();
		model.addAttribute("togetherList", togetherList);

		return "redirect:/together";
	}
}
