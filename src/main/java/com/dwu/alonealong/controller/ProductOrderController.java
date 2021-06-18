package com.dwu.alonealong.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import com.dwu.alonealong.service.ProductOrderFormValidator;

@Controller
@SessionAttributes({"productOrderSession"})
public class ProductOrderController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@Autowired
	private ProductOrderFormValidator validator;

	public void setValidator(ProductOrderFormValidator validator) {
		this.validator = validator;
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

		Encoder encoder = Base64.getEncoder();
		
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
		        byte[] imagefile = cartItem.getImg();
		        if(imagefile != null) {
		            String encodedString = encoder.encodeToString(imagefile);
		            orderItem.setImg64(encodedString);
		        }
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
	        byte[] imagefile = product.getProductImg();
	        if(imagefile != null) {
	            String encodedString = encoder.encodeToString(imagefile);
	            orderItem.setImg64(encodedString);
	        }
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
			@ModelAttribute("productOrderForm") ProductOrderForm productOrderForm, 
			@SessionAttribute("productOrderSession") List<ProductLineItem> lineItems,
			BindingResult result, ModelMap model, 
			SessionStatus status) {
		validator.validate(productOrderForm, result);
		ProductOrder order = productOrderForm.getOrder();

		//유저 정보 및 결제 정보 받아오기
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		String userId = userSession.getUser().getId();
		User user = aloneAlong.getUserByUserId(userId);
		
		//totalPrice
		int totalPrice = 0;
		for (ProductLineItem item : lineItems) {
			totalPrice += item.getUnitPrice();
		}
		if (totalPrice < 30000) {
			totalPrice += 3000;
		}
				
		if (result.hasErrors()) {
			Payment paymentMethod = aloneAlong.getCard(userId);
			productOrderForm.setOrderUser(user);
			productOrderForm.setPayment(paymentMethod);
			model.put("orderForm", productOrderForm);
			model.put("totalPrice", totalPrice);
			model.put("type", productOrderForm.getType());
			return "productOrder";
		}
		
		//lineItem
		order.setLineItems(lineItems);
		
		
		order.setTotalPrice(totalPrice);
		
		//user
		order.setUserId(userId);		
		aloneAlong.insertProductOrder(order);

		if(productOrderForm.getType().equals("cart")) {
			aloneAlong.deleteAllCartItem(userId);
		}
		status.setComplete();  // remove sessionCart and orderForm from session
		return "productOrderResult";
	}

}