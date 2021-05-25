package com.dwu.alonealong.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.service.AloneAlongFacade;

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
//		@RequestParam(value="product", required=false) Product product, 
		@ModelAttribute("sessionFoodCart") FoodCart cart,
//		@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm,
		ModelMap model) throws Exception {
		
		//유저 정보 및 결제 정보 받아오기
//		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
//		User user = aloneAlong.getUser(userSession.getUser().getUserId());
//		Payment paymentMethod = aloneAlong.getCard(userSession.getUser().getUserId());

		//LineItem 설정 
//		List<ProductLineItem> orderList = new ArrayList<ProductLineItem>();
		
		//만약 sessionFoodCart.size가 0이면 order창으로 넘어가지 못하도록.
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
//		
//		//받아온 유저정보 & 결제정보 & LineItem으로 orderForm 세팅 
//		productOrderForm.getProductOrder().initProductOrder(user, paymentMethod, orderList);
		return "foodOrderForm";
	}
	
//	@RequestMapping("/shop/order/confirm")
//	protected ModelAndView confirmOrder(@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm, 
//								SessionStatus status) {
//		aloneAlong.insertProductOrder(productOrderForm.getProductOrder());
//		ModelAndView mav = new ModelAndView("ViewOrder");
//		mav.addObject("order", productOrderForm.getProductOrder());
//		mav.addObject("message", "Thank you, your order has been submitted.");
//		status.setComplete();  // remove sessionCart and orderForm from session
//		return mav;
//	}

}