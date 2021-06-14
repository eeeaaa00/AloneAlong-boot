package com.dwu.alonealong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class JoinTogetherController {

	private AloneAlongFacade aloneAlong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	//신청하기	
	@RequestMapping(value = "/togetherOrder")
	public String joinTogether(
			) {
		
		return "together/togetherOrder";
//		return "togetherOrder";
	}
	
	//결제하기
	@PostMapping(value = "/togetherOrder/complete")
	public String payTogether(
//			HttpServletRequest request,
			@SessionAttribute("together") Together together,
			ModelMap model) {
		
		//카드 결제(구현해야함)/////////////////////////
		String userId = "1"; //임시
		
		System.out.println("주문 목록 넣기 전--------------- ");
		//주문목록에 넣기
		TogetherOrder togetherOrder = new TogetherOrder("ORDER_ID.NEXTVAL", together.getTogetherId());
		aloneAlong.insertTogetherOrder(togetherOrder);
		
		System.out.println("멤버 추가 전--------------- ");
		//TogetherMember에 추가
		TogetherMember togetherMember = new TogetherMember("TOGMEM_ID.NEXTVAL", userId, together.getTogetherId(), 0);
		aloneAlong.insertTogetherMember(togetherMember);
		
		//만약에 멤버 다찼으면 state -> 1, foodOrder에 들어가기
		if(together.getTogetherMemberList().size() == together.getHeadCount()) {
			Together newTogether = new Together(together.getTogetherId(), together.getTogetherName(), together.getHeadCount(), together.getTogetherDate(), together.getTogetherTime(), 
					together.getSex(), together.getAge(), together.getTogetherDes(), together.getResId(), 1, together.getPrice());
			aloneAlong.updateTogether(newTogether);
			
			//foodOrder에 넣기(구현해야함)
		}
		
		return "redirect:/together";
	}

}
