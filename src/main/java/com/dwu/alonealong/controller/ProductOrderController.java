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
public class ProductOrderController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop/order")
	public String initNewOrder(HttpServletRequest request,
		@RequestParam(value="type") String type,
		@RequestParam(value="productId", required=false) String productId,
		@RequestParam(value="quantity", defaultValue="-1") int quantity,
		@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm,
		ModelMap model) throws Exception {
		
		//유저 정보 및 결제 정보 받아오기
		String userId = "1";
		User user = this.aloneAlong.getUserByUserId(userId);
		Payment paymentMethod = this.aloneAlong.getCard(userId);
//		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
////		User user = aloneAlong.getUserByUserId(userSession.getUser().getUserId());
//		Payment paymentMethod = aloneAlong.getCard(userSession.getUser().getUserId());

		//LineItem 설정 
		List<ProductLineItem> orderList = new ArrayList<ProductLineItem>();
		int totalPrice = 0;
		
		//1. Cart
		if(type.equals("cart")){
			List<CartItem> cart = this.aloneAlong.getAllCartItem(userId);
			for(CartItem cartItem : cart){
				ProductLineItem orderItem = new ProductLineItem(cartItem);
				totalPrice += orderItem.getUnitPrice();
				orderList.add(orderItem);
			}
		}
		//2. Product
		else if(type.equals("product")) {
			if(productId == null || quantity == -1) {
				return "error";
			}
			Product product = this.aloneAlong.getProduct(productId);
			product.setQuantity(quantity);
			totalPrice = product.getUnitPrice();
			ProductLineItem orderItem = new ProductLineItem(product);
			orderList.add(orderItem);
		}
		else {
			return "error";
		}

//		//받아온 유저정보 & 결제정보 & LineItem으로 orderForm 세팅 
		productOrderForm = new ProductOrderForm();
		productOrderForm.initProductOrder(user, orderList, paymentMethod);
		model.put("totalPrice", totalPrice);
		model.put("orderForm", productOrderForm);
		return "productOrder";
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