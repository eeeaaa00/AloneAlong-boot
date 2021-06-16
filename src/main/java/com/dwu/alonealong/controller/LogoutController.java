package com.dwu.alonealong.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LogoutController { 
	@RequestMapping("/logout")
	public RedirectView handleRequest(HttpSession session) throws Exception {
		session.removeAttribute("userSession");
		session.invalidate();
		
		return new RedirectView("/");
	}
}