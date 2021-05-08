package com.dwu.alonealong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		User user = alonealong.getUser(username, password);
		if (user == null) {
			return new ModelAndView("Error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			UserSession userSession = new UserSession(user);
			//PagedListHolder<Product> myList = new PagedListHolder<Product>(this.petStore.getProductListByCategory(account.getFavouriteCategoryId()));
			//myList.setPageSize(4);
			//userSession.setMyList(myList);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return new ModelAndView("index");
		}
	}
}