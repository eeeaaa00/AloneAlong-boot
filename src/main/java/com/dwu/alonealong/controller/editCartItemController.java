package com.dwu.alonealong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"userSession"})
public class editCartItemController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}

	@RequestMapping("/cart/delete")
	public String deleteCartItem(HttpServletRequest request,
			@RequestParam(value="cartItemId") String cartItemId,
			ModelMap model) throws Exception {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		
		CartItem cartItem = aloneAlong.getCartItem(cartItemId);
		if(!userSession.getUser().getId().equals(cartItem.getUserId())) {
			return  "redirect:/error";
		}
		this.aloneAlong.deleteCartItem(cartItemId);
		
		return "redirect:/cart";
	}

	@RequestMapping("/cart/update/{cartItemId}")
	public String updateCartItem(HttpServletRequest request,
			@PathVariable("cartItemId") String cartItemId,
			@RequestParam(value="quantity") int quantity,
			ModelMap model) throws Exception {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		CartItem cartItem = aloneAlong.getCartItem(cartItemId);
		if(!userSession.getUser().getId().equals(cartItem.getUserId())) {
			return  "redirect:/error";
		}
		Product product = aloneAlong.getProduct(cartItem.getProductId());
		cartItem.setQuantity(quantity);
		
		if(!aloneAlong.checkStock(cartItem.getProductId(), quantity)) {
			return "redirect:/cart?stockError=true&cartItemId=" + cartItemId + "&stock=" + product.getProductStock();
		}
		aloneAlong.updateCartItem(cartItem);
		return "redirect:/cart";
	}
	


	@RequestMapping("/cart/insert/{productId}/{type}")
	public String insertCartItem(HttpServletRequest request,
			@PathVariable("productId") String productId,
			@PathVariable("type") String type, 
			@RequestParam(value="quantity", defaultValue="1") int quantity, 
			@RequestParam(value="page", defaultValue="1") String page, 
			ModelMap model) throws Exception {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession == null) {
			return "redirect:/login";
		}
		String userId = userSession.getUser().getId();
		Product product = aloneAlong.getProduct(productId);
		System.out.println(product);
		
		product.setQuantity(quantity);
		model.put("product", product);
		model.put("pcId", product.getPcId());
		
		if(type.equals("list")) {
			if(!aloneAlong.checkStock(productId, quantity)) {
				return "redirect:/shop?stockError=true&insertProductId=" + productId + "&stock=" + product.getProductStock() + "&pcId=" + product.getPcId() + "&page=" + page;
			}
			aloneAlong.insertCartItem(productId, quantity, userId);
			return "redirect:/shop?insertCart=true&pcId=" + product.getPcId() + "&page=" + page;
		}
		else if(type.equals("product")) {
			if(!aloneAlong.checkStock(productId, quantity)) {
				return "redirect:/shop/" + productId + "?stockError=true&insertProductId=" + productId + "&stock=" + product.getProductStock();
			}
			aloneAlong.insertCartItem(productId, quantity, userId);
			return "redirect:/shop/" + productId + "?insertCart=true";
		}
		return "error";
	}
}
