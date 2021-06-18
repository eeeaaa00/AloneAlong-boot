package com.dwu.alonealong.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class SignOutController { 
	
	@Autowired
	private AloneAlongFacade alonealong;

	@Autowired
	public void setAlongAlone(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	@RequestMapping("/signOut")
	public String handleRequest(HttpServletRequest request, HttpSession session) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		alonealong.removeUser(userSession.getUser().getId());
		System.out.print("탈퇴 완료");
		session.removeAttribute("userSession");
		session.invalidate();

		return "redirect:/";
	}
}