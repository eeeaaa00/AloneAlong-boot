package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import com.dwu.alonealong.service.AloneAlongFacade;


@Controller
@SessionAttributes("sessionFoodCart")
//@RequestMapping("/eating/adminFood")
public class FoodCartController {
	
	private static final String FOOD_INSERT_FORM = "eating/FoodForm";
	private AloneAlongFacade alonealong;
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	
	@RequestMapping("/eating/{resId}/addFoodToCart")
	public String handleRequest(
			@RequestParam("foodId") String foodId,
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			@PathVariable("resId") String resId,
			ModelMap model
			) throws Exception {
		
		System.out.println(cart.getFoodItemList().size());
		if (cart.containsFoodId(foodId)) {
			cart.incrementQuantityByFoodId(foodId);
		}
		else {
			Food item = this.alonealong.getFood(foodId);
			if(item == null)
				System.out.println("null들어왔다");
			cart.addFood(item);
		}		
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId); 
		model.put("foodList", foodList);
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("restaurant", res);
		return "redirect:/eating/{resId}";
	}
	@RequestMapping("/eating/{resId}/updateFoodCartItem")
	public String handleRequest2(
			HttpServletRequest request,	
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			@PathVariable("resId") String resId,
			ModelMap model
			) throws Exception {
		
		cart.setQuantityByFoodId(request.getParameter("foodId"), Integer.parseInt(request.getParameter("quantity")));
				
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId); 
		model.put("foodList", foodList);
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("restaurant", res);
		return "redirect:/eating/{resId}";
	}
	@RequestMapping("/eating/{resId}/deleteFoodCartItem")
	public String handleRequest3(
			HttpServletRequest request,	
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			@PathVariable("resId") String resId,
			ModelMap model
			) throws Exception {
		
		cart.removeFoodById((request.getParameter("foodId")));
				
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId); 
		model.put("foodList", foodList);
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("restaurant", res);
		return "redirect:/eating/{resId}";
	}
	
//	@RequestMapping("/eating/{resId}/updateFoodCartQuantities")
//	public ModelAndView handleRequest(
//			HttpServletRequest request,	
//			@ModelAttribute("sessionCart") FoodCart cart) throws Exception {
//		Iterator<FoodCartItem> cartItems = cart.getAllFoodCartItems();
//		while (cartItems.hasNext()) {
//			FoodCartItem cartItem = (FoodCartItem) cartItems.next();
//			String itemId = cartItem.getFood().getFoodId();
//			try {
//				int quantity = Integer.parseInt(request.getParameter(itemId));
//				cart.setQuantityByFoodId(itemId, quantity);
//				if (quantity < 1) {
//					cartItems.remove();
//				}
//			}
//			catch (NumberFormatException ex) {
//				// ignore on purpose
//			}
//		}
//		return new ModelAndView("restaurant", "foodCart", cart);
//	}

}
