package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.service.AloneAlongFacade;

@SessionAttributes({"retaurantList", "sessionFoodCart"})
@Controller
public class TogetherRegisterController {
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	//FoodCart 세션
	@ModelAttribute("sessionFoodCart")
	public FoodCart createCart(HttpSession session) {
		FoodCart cart = (FoodCart)session.getAttribute("sessionFoodCart");
		if (cart == null) cart = new FoodCart();
		return cart;
	}
	
	@RequestMapping("/togetherRegister")
	public String handleRequest(
		) throws Exception {
		System.out.println("등록하기 페이지로 들어가기");
		return "together/togetherRegister";
	}
	
	//키워드로 레스토랑 리스트 가져오기
	@RequestMapping("/togetherRegister/searchRestaurant")
	public String searchRestaurant(
			@RequestParam("keywords") String keywords,
			ModelMap model) throws Exception {
		List<Restaurant> restaurantList = this.alonealong.searchRestaurantList(keywords);
		model.put("keywords", keywords);
		model.put("restaurantList", restaurantList);
		System.out.println("키워드 검색 완료");
		return "together/togetherRegister";
	}
	
	//해당 식당의 메뉴 가져오기
	@RequestMapping("/togetherRegister/searchMenu")
	public String selectRestaurant(
			@RequestParam("resId") String resId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
			ModelMap model) throws Exception {
		Restaurant restaurant = alonealong.getRestaurantByResId(resId);
		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
		
		model.put("keywords", restaurant.getResName()); //검색창에 레스토랑 이름 세팅하기
		model.put("selectedRes", restaurant);
		//model.put("selectedOk", true);
		
		model.addAttribute("foodList", foodList);
		System.out.println("메뉴 검색 완료");
		
		foodCart = new FoodCart(); //카트 초기화(안먹힘)
		model.put("foodCart", foodCart.getAllFoodCartItems());
		
		return "together/togetherRegister";
	}
	
	//together 등록(구현중 - 유저세션 구현해야함)
	@GetMapping("/togetherRegister/complete")
	public String insertTogether(
			@RequestParam("name") String name,
			@RequestParam("headCount") int headCount,
			@RequestParam("sex") String sex,
			@RequestParam("age") String age,
			@RequestParam("date") String date,
			@RequestParam("time") String time,
			@RequestParam("description") String description,
			@RequestParam("resId") String resId,
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			ModelMap model) {
		//together 넣기
		Together together = new Together("TOG_ID.NEXTVAL", name, headCount, date, time, sex, age, description, resId, 0, cart.getSubTotal() / headCount);
		alonealong.insertTogether(together);
		
		System.out.println("Tog_id : " + together.getTogetherId());
		
		//음식 넣기
		for(int i = 0; i < cart.getFoodItemList().size(); i++) {
			TogetherFood togetherFood = new TogetherFood("TOGFOOD_ID.NEXTVAL", together.getTogetherId(), cart.getFoodItemList().get(i).getFood().getFoodId() , cart.getFoodItemList().get(i).getQuantity());
			alonealong.insertTogetherFood(togetherFood);
		}
		
		//멤버 넣기/////////////////////////////////수정해야함 : 유저세션의 유저//////////////////
		String userId = "2";
		TogetherMember togetherMember = new TogetherMember("TOGMEM_ID.NEXTVAL", userId, together.getTogetherId(), 1);
		alonealong.insertTogetherMember(togetherMember);
		
		List<Together> togetherList = alonealong.getTogetherList();
		model.addAttribute("togetherList", togetherList);
		
		return "redirect:/together";
	}
	
}
