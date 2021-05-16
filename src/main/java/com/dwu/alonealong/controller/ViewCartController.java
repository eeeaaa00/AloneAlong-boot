package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"userSession"})
public class ViewCartController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/cart")
	public String handleRequest(
			ModelMap model) throws Exception {
		//로그인 구현 전까지 임시
		String userId = "1";
		
		int totalPrice = 0;
		int shippingFee = 0;
		List<CartItem> cart = this.aloneAlong.getAllCartItem(userId);
		for(CartItem cartItem : cart) {
			Product product = this.aloneAlong.getProduct(cartItem.getProductId());
			cartItem.setProductName(product.getProductName());
			cartItem.setPrice(product.getProductPrice());
			cartItem.setShippingFee(product.getShippingFee());
			totalPrice += cartItem.getUnitPrice();
//			cartItem.setImg(product.getProductImg());
		}

		model.put("productsPrice", totalPrice);
		if (totalPrice < 30000) {
			shippingFee = 3000;
			totalPrice += shippingFee;
		}
		model.put("shippingFee", shippingFee);
		model.put("totalPrice", totalPrice);
		model.put("cart", cart);
		return "thyme/Cart";
//		return "productCart";
	}

}