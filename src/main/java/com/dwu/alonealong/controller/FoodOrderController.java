package com.dwu.alonealong.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodCartItem;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;
import com.dwu.alonealong.domain.FoodOrder;
@Controller
@SessionAttributes({"sessionFoodCart"})
public class FoodOrderController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/eating/order")
	public String initNewOrder(HttpServletRequest request,
		@RequestParam(value="resId", required=false) String resId, 
		@ModelAttribute("sessionFoodCart") FoodCart cart,
//		@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm,
		ModelMap model) throws Exception {
		
		model.addAttribute("foodOrderForm", new FoodOrder());

		//유저 정보 및 결제 정보 받아오기
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
		Payment paymentMethod = aloneAlong.getCard(userSession.getUser().getId());

		System.out.print(user);
		//LineItem 설정 
//		List<ProductLineItem> orderList = new ArrayList<ProductLineItem>();
		
		//만약 sessionFoodCart.size가 0이면 order창으로 넘어가지 못하도록.
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		model.put("resId", resId);
//		//받아온 유저정보 & 결제정보 & LineItem으로 orderForm 세팅 
//		productOrderForm.getProductOrder().initProductOrder(user, paymentMethod, orderList);
		return "foodOrderForm";
	}
	
	@RequestMapping("/eating/order/confirm")
	protected String confirmOrder(
			@RequestParam(value="resId", required=false) String resId, 
			@SessionAttribute("sessionFoodCart") FoodCart cart,
			@ModelAttribute("foodOrderForm") FoodOrderForm form, //jsp에서 modelattribute 등록해라
			HttpServletRequest request,
			SessionStatus status
			) {
		
		List<FoodCartItem> foodList = cart.getFoodItemList();
		String reserveType = form.getReserveType();
		String visitDate = form.getVisitDate();
		Payment payment = new Payment(form.getCcName(), form.getCcNum(), form.getCcDate(),form.getCcCVC());
		
		//user id
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
		String userId = user.getId();
		
		FoodOrder order = new FoodOrder(resId, userId, foodList, reserveType, visitDate, payment);
		System.out.println("form 잘 들어 왔는지: " + order.toString());
		aloneAlong.insertFoodOrder(order);


		status.setComplete();  // remove sessionCart and orderForm from session
		return "restaurant";
	}

}