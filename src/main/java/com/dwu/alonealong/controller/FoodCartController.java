package com.dwu.alonealong.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodCartItem;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.FoodService;
import com.dwu.alonealong.service.RestaurantService;

@Controller
@SessionAttributes("sessionFoodCart")
//@RequestMapping("/eating/adminFood")
public class FoodCartController {
	
	private static final String FOOD_INSERT_FORM = "eating/FoodForm";
	
	@Autowired
	private RestaurantService resService;	
	public void setRestaurantService(RestaurantService resService) {
		this.resService = resService;
	}
	
	@Autowired
	private FoodService foodService;	
	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
	@ModelAttribute("sessionFoodCart")
	public FoodCart createCart() {
		return new FoodCart();
	}
	
	@RequestMapping("/eating/{resId}/addFoodToCart")
	public ModelAndView handleRequest(
			@RequestParam("foodId") String foodId,
			@ModelAttribute("sessionFoodCart") FoodCart cart 
			) throws Exception {
		if (cart.containsFoodId(foodId)) {
			cart.incrementQuantityByFoodId(foodId);
		}
		else {
			Food item = this.foodService.getFood(foodId);
			cart.addFood(item);
		}
		return new ModelAndView("restaurant", "foodCart", cart);
	}
	
	@RequestMapping("/eating/{resId}/updateFoodCartQuantities")
	public ModelAndView handleRequest(
			HttpServletRequest request,	
			@ModelAttribute("sessionCart") FoodCart cart) throws Exception {
		Iterator<FoodCartItem> cartItems = cart.getAllFoodCartItems();
		while (cartItems.hasNext()) {
			FoodCartItem cartItem = (FoodCartItem) cartItems.next();
			String itemId = cartItem.getFood().getFoodId();
			try {
				int quantity = Integer.parseInt(request.getParameter(itemId));
				cart.setQuantityByFoodId(itemId, quantity);
				if (quantity < 1) {
					cartItems.remove();
				}
			}
			catch (NumberFormatException ex) {
				// ignore on purpose
			}
		}
		return new ModelAndView("restaurant", "foodCart", cart);
	}

}
