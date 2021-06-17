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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Cart;
import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodCartItem;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductLineItem;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"productOrderSession"})
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
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		String userId = userSession.getUser().getId();
		User user = aloneAlong.getUserByUserId(userId);
		Payment paymentMethod = aloneAlong.getCard(userId);

		//LineItem 설정 
		List<ProductLineItem> orderList = new ArrayList<ProductLineItem>();
		int totalPrice = 0;
		
		//1. Cart
		if(type.equals("cart")){
			List<CartItem> cart = this.aloneAlong.getAllCartItem(userId);
			for(CartItem cartItem : cart){ 
				if(!aloneAlong.checkStock(cartItem.getProductId(), cartItem.getQuantity())){
					Product product = this.aloneAlong.getProduct(cartItem.getProductId());
					return "redirect:/cart?stockError=true&product=" + product.getProductName() + "&stock=" + product.getProductStock();
				}
				ProductLineItem orderItem = new ProductLineItem(cartItem);
				totalPrice += orderItem.getUnitPrice();
				orderList.add(orderItem);
			}
			if(totalPrice < 30000) {
				totalPrice += 3000;
			}
		}
		//2. Product
		else if (type.equals("product")){
			if(productId == null || quantity < 0) {
				return "error";
			}
			Product product = this.aloneAlong.getProduct(productId);
			product.setQuantity(quantity);
			if(!aloneAlong.checkStock(product.getProductId(), quantity)){
				return "redirect:/shop/" + product.getProductId() + "?stockError=true";
			}
			totalPrice = product.getUnitPrice();
			ProductLineItem orderItem = new ProductLineItem(product);
			orderList.add(orderItem);
		}
		else {
			return "error";
		}

//		//받아온 유저정보 & 결제정보 & LineItem으로 orderForm 세팅 
		productOrderForm = new ProductOrderForm();
		productOrderForm.initProductOrder(user, paymentMethod);
		model.put("orderForm", productOrderForm);
		model.put("productOrderSession", orderList);
		model.put("totalPrice", totalPrice);
		model.put("type", type);
		return "productOrder";
	}
	
	@RequestMapping("/shop/order/confirm")
	protected String confirmOrder(HttpServletRequest request,
			@ModelAttribute("productOrderForm") ProductOrderForm form, 
			@SessionAttribute("productOrderSession") List<ProductLineItem> lineItems,
			SessionStatus status) {

		ProductOrder order = form.getOrder();
		
		//lineItem
		order.setLineItems(lineItems);
		
		//totalPrice
		int totalPrice = 0;
		for(ProductLineItem item : lineItems) {
			totalPrice += item.getUnitPrice();
		}
		order.setTotalPrice(totalPrice);
		
		//user
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String userId = userSession.getUser().getId();
		order.setUserId(userId);
		
		System.out.println("form 잘 들어 왔는지: " + order.toString());
		aloneAlong.insertProductOrder(order);

		if(form.getType().equals("cart")) {
			aloneAlong.deleteAllCartItem(userId);
		}
		status.setComplete();  // remove sessionCart and orderForm from session
		return "productOrderResult";
	}

}