package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;


@Controller
@SessionAttributes({"restaurantList", "sessionFoodCart"})
public class ViewRestaurantController {
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	
	@ModelAttribute("sessionFoodCart")
	public FoodCart createCart() {
		return new FoodCart();
	}

	@RequestMapping("/eating")
	public String handleRequest(
//			@RequestParam("categoryId") String categoryId,
			ModelMap model
			) throws Exception {
		
		model.addAttribute("sessionFoodCart", new FoodCart()); //식당에서 나올 때마다 카트 초기화.
//		createCart();
		//Category category = this.petStore.getCategory(categoryId);
//		PagedListHolder<Restaurant> restaurantList = new PagedListHolder<Restaurant>(this.alonealong.getRestaurantList());
//		PagedListHolder<Restaurant> restaurantList = new PagedListHolder<Restaurant>(this.resService.getRestaurantList());
		
		List<Restaurant> restaurantList = alonealong.getRestaurantList();
//		restaurantList.setPageSize(4);
		//model.put("category", category);
		model.put("restaurantList", restaurantList);
//		return "/eating/Restaurant";
		return "restaurantList";
	}
	
	//음식 검색분류별로 선별해서 나열
//	@RequestMapping("/eating")
//	public String handleRequest(
////			@RequestParam("categoryId") String categoryId,
////			ModelMap model
//			) throws Exception {
//		//Category category = this.petStore.getCategory(categoryId);
////		PagedListHolder<Restaurant> restaurantList = new PagedListHolder<Restaurant>(this.alonealong.getRestaurantList());
////		restaurantList.setPageSize(4);
//		//model.put("category", category);
////		model.put("restaurantList", restaurantList);
//		return "/eating/Restaurant";
	
	
//	@RequestMapping("/eating/adminRes")
//	public String handleRequest2(
////			@RequestParam("categoryId") String categoryId,
////			ModelMap model
//			) throws Exception {
//		//Category category = this.petStore.getCategory(categoryId);
////		PagedListHolder<Restaurant> restaurantList = new PagedListHolder<Restaurant>(this.alonealong.getRestaurantList());
////		restaurantList.setPageSize(4);
//		//model.put("category", category);
////		model.put("restaurantList", restaurantList);
//		return "/eating/RestaurantForm";
//	}
	
//	@RequestMapping("/shop/viewRestaurant2.do")
//	public String handleRequest2(
//			@RequestParam("page") String page,
//			//@ModelAttribute("category") Category category,
//			@ModelAttribute("restaurantList") PagedListHolder<Restaurant> restaurantList,
//			BindingResult result) throws Exception {
//		if (/*category == null || */restaurantList == null) {
//			throw new IllegalStateException("Cannot find pre-loaded category and product list");
//		}
//		if ("next".equals(page)) { restaurantList.nextPage(); }
//		else if ("previous".equals(page)) { restaurantList.previousPage(); }
//		return "RestaurantList";
//	}

}
