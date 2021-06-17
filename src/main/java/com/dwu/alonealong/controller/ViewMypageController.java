package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;


@Controller
public class ViewMypageController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setPetStore(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/myOrder")
	public String order() {
		return "myOrder";
	}

	@RequestMapping("/myResOrder")
	public String handleRequest(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		
		model.addAttribute("userSession", userSession);
		
		
		return "myResOrder";
	}

	@RequestMapping("/myTogetherOrder")
	public String Togorder(HttpServletRequest request,
			ModelMap model) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		
		if(userSession != null) {
			User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
			
			List<TogetherOrder> orderList = aloneAlong.getTogetherOrderByUserId(user.getId()); //List import 안됨
			
			model.put("orderList", orderList);
		}
		
		return "myTogetherOrder";
	}

	@RequestMapping(value = "/myFood")
	public ModelAndView myFood() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myFood");
		return mav;
	}

	@RequestMapping(value = "/myTogether")
	public ModelAndView myTogether() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myTogether");
		return mav;
	}

	@RequestMapping(value = "/myRestaurant")
	public ModelAndView myRestaurant() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mypage/myRestaurant");
		return mav;
	}
}
