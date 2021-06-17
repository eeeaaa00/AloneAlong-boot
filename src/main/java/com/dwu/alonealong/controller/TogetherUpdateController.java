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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.service.AloneAlongFacade;

@SessionAttributes({"sessionFoodCart"})
@Controller
public class TogetherUpdateController {
	private AloneAlongFacade aloneAlong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	//FoodCart 세션
	@ModelAttribute("sessionFoodCart")
	public FoodCart createCart(HttpSession session) {
		FoodCart cart = (FoodCart)session.getAttribute("sessionFoodCart");
		if (cart == null) cart = new FoodCart();
		return cart;
	}
	
	//수정 페이지로 가기/////////////////////////////////////////////(구현중)
	@RequestMapping("/togetherRegister/update/{togetherId}")
	public String viewUpdate(
			HttpSession session,
			@PathVariable("togetherId") String togId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
			ModelMap model) throws Exception {
		
		Together together = this.aloneAlong.getTogetherByTogId(togId);
		
		model.put("keywords", together.getRestaurant().getResName()); //검색어 세팅
		
		//푸드 리스트 세팅
		List<Food> foodList = aloneAlong.getFoodListByRestaurant(together.getResId());
		model.addAttribute("foodList", foodList);
		
		//카트 세팅(구현중) --> 세션 생성해야함(여기서 가끔 오류남)
		for(int i = 0; i < together.getTogetherFoodList().size(); i++) {
			System.out.println("현재 음식 사이즈" + foodCart.getFoodItemList().size());
			if (foodCart.containsFoodId(together.getTogetherFoodList().get(i).getFoodId())) {
				System.out.println("이미 있는 음식");
				foodCart.incrementQuantityByFoodId(together.getTogetherFoodList().get(i).getFoodId());
			}
			else {
				Food item = this.aloneAlong.getFood(together.getTogetherFoodList().get(i).getFoodId());
				if(item == null)
					System.out.println("null들어왔다");
				foodCart.addFood(item);
				System.out.println("카트에 추가됨");
			}	
		}
		model.put("foodCart", foodCart.getAllFoodCartItems());
		
		model.put("together", together);
		
		return "together/togetherForm";
	}
	
	//together 수정///////////////////////////////////////(구현중)
	@GetMapping("/togetherRegister/update/{togetherId}/complete")
	public String updateTogether(
			HttpServletRequest request,
			@PathVariable("togetherId") String togId,
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
		//together 수정
		Together newTogether = new Together(togId, name, headCount, date, time, sex, age, description, resId, 0, cart.getSubTotal() / headCount);
		aloneAlong.updateTogether(newTogether);
		
		//음식 수정(기존 음식 다 버리고 새로 추가)
		aloneAlong.deleteTogetherFood(togId);
		
		for(int i = 0; i < cart.getFoodItemList().size(); i++) { //새로 음식 추가
			TogetherFood togetherFood = new TogetherFood("TOGFOOD_ID.NEXTVAL", newTogether.getTogetherId(), cart.getFoodItemList().get(i).getFood().getFoodId() , cart.getFoodItemList().get(i).getQuantity());
			aloneAlong.insertTogetherFood(togetherFood);
		}
		
		List<Together> togetherList = aloneAlong.getTogetherList();
		model.addAttribute("togetherList", togetherList);
		
		return "redirect:/together";
	}
}
