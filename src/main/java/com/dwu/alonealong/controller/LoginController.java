package com.dwu.alonealong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes("userSession")
public class LoginController {

	private AloneAlongFacade alonealong;

	@Autowired
	public void setPetStore(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}

	@RequestMapping(value = "/login")
	public String handleRequest(ModelMap model) throws Exception {

		return "login";
	}

	@RequestMapping(value = "/loginTest")
	public ModelAndView handleRequest(HttpServletRequest request, @RequestParam("id") String userId,
			@RequestParam("pw") String password,
			@RequestParam(value = "forwardAction", required = false) String forwardAction, Model model)
			throws Exception {
		User user = alonealong.getUserByUserIdAndPassword(userId, password);

		if (user == null) {
			return new ModelAndView("login", "message", "아이디와 비밀번호를 다시 확인해주세요.");
		} else {
			UserSession userSession = new UserSession(user);
			model.addAttribute("userSession", userSession);

			if (forwardAction != null)
				return new ModelAndView("redirect:" + forwardAction);
			else
				return new ModelAndView("loginTest");

		}
	}
}