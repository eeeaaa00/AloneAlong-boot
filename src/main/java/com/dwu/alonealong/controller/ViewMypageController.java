package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.support.PagedListHolder;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;


import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodLineItem;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.ProductLineItem;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes("sessionFoodCart") 
public class ViewMypageController {

  private AloneAlongFacade aloneAlong;
  @Autowired
  public void setAloneAlong(AloneAlongFacade aloneAlong) {
    this.aloneAlong = aloneAlong;
  }

  	@RequestMapping("/myOrder")
	public String order(
			HttpServletRequest request,
			Model model) throws Exception {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "forward:/login";
		}
		String userId = userSession.getUser().getId();
		User user = aloneAlong.getUserByUserId(userId);
		List<ProductOrder> productOrderList = aloneAlong.getOrdersByUserId(userId);
		
		model.addAttribute("productOrderList", productOrderList);
		return "myOrder";
	}

	@RequestMapping("/myResOrder")
	public String Resorder(
			HttpServletRequest request,
			Model model) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
		String userId = user.getId();
		
		List<FoodOrder> foodOrderList = aloneAlong.getFoodOrdersByUserId(userId);
		
		Encoder encoder = Base64.getEncoder();
		for(FoodOrder order : foodOrderList) {
			Restaurant res = aloneAlong.getRestaurantByResId(order.getResId());
			order.setResName(res.getResName());
			byte[] imagefile = res.getImgFile();
			String encodedString = encoder.encodeToString(imagefile);
			order.setImg64(encodedString);
			
			for(FoodLineItem item : order.getOrderedList()) {
				Food food = aloneAlong.getFood(item.getFoodId());
				item.setFoodName(food.getName());
			}
		}
		model.addAttribute("sessionFoodCart", new FoodCart());
		model.addAttribute("foodOrderList", foodOrderList);

		return "myResOrder"; 

	}

	@RequestMapping("/myTogetherOrder")
	public String Togorder(HttpServletRequest request,
			ModelMap model) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
		
		List<TogetherOrder> orderList = aloneAlong.getTogetherOrderByUserId(user.getId());
		
		Encoder encoder = Base64.getEncoder();
		for(TogetherOrder order : orderList) {
			byte[] imagefile = order.getTogether().getRestaurant().getImgFile();
	        String encodedString = encoder.encodeToString(imagefile);
	        order.getTogether().getRestaurant().setImg64(encodedString);
		}
		
		model.addAttribute("orderList", orderList);
		
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
