package com.dwu.alonealong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Cart;
import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductLineItem;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"sessionCart", "productOrderForm"})
public class ProductOrderController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/order")
	public String initNewOrder(HttpServletRequest request,
		@RequestParam(value="product", required=false) Product product, 
		@RequestParam(value="cart", required=false) Cart cart, 
		@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm,
		ModelMap model) throws Exception {
		
		//유저 정보 및 결제 정보 받아오기
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUser(userSession.getUser().getUserId());
		Payment paymentMethod = aloneAlong.getCard(userSession.getUser().getUserId());

		//LineItem 설정 
		List<ProductLineItem> orderList = new ArrayList<ProductLineItem>();
		
		//1. Cart가 null이 아니면 LineItem에 Cart에 담긴 cart Item 전부 저장
		if(cart != null){
			for(CartItem item : cart.getCartItemList()){
				ProductLineItem orderItem = new ProductLineItem(item.getProductId(), item.getQuantity(), item.getUnitPrice());
				orderList.add(orderItem);
			}
		}
		//2. product가 null이 아니면 LineItem에 product 저장
		else if (product != null){
			ProductLineItem orderItem = new ProductLineItem(product.getProductId(), product.getQuantity(), product.getUnitPrice());
			orderList.add(orderItem);
		}
		else {
			return "error";
		}
		
		//받아온 유저정보 & 결제정보 & LineItem으로 orderForm 세팅 
		productOrderForm.getProductOrder().initProductOrder(user, paymentMethod, orderList);
		return "order";
	}
	
	@RequestMapping("/shop/order/confirm")
	protected ModelAndView confirmOrder(@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm, 
								SessionStatus status) {
		aloneAlong.insertProductOrder(productOrderForm.getProductOrder());
		ModelAndView mav = new ModelAndView("ViewOrder");
		mav.addObject("order", productOrderForm.getProductOrder());
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return mav;
	}

}