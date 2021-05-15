package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
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
public class DeleteCartController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/cart/update/{cartItemId}")
	public String handleRequest(@PathVariable("cartItemId") String cartItemId,
			@RequestParam(value="quantity") int quantity,
			ModelMap model) throws Exception {
		CartItem cartItem = this.aloneAlong.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		this.aloneAlong.updateCartItem(cartItem);
		
		return "redirect:/cart";
	}
}