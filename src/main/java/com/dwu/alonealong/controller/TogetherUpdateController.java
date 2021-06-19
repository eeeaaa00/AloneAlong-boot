package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

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
import org.springframework.web.bind.support.SessionStatus;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Restaurant;
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
	
	//수정 페이지로 가기
	@RequestMapping("/togetherUpdate/{togetherId}")
	public String viewUpdate(
			HttpSession session,
			@PathVariable("togetherId") String togId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
			ModelMap model) throws Exception {
		
		Together together = this.aloneAlong.getTogetherByTogId(togId);
		
		model.put("keywords", together.getRestaurant().getResName()); //검색어 세팅
		model.put("selectedRes", together.getRestaurant()); //레스토랑 세팅
		
		System.out.println("selectedRes" + together.getRestaurant());
		
		//푸드 리스트 세팅
		List<Food> foodList = aloneAlong.getFoodListByRestaurant(together.getResId());
		
		Encoder encoder = Base64.getEncoder(); //음식 이미지
		byte[] imagefile;
		String encodedString;
        for(Food food : foodList) {
        	imagefile = food.getImgFile();
            encodedString = encoder.encodeToString(imagefile);
            food.setImg64(encodedString);
        }
		
		model.addAttribute("foodList", foodList);
		
		//카트 세팅
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
		
		return "together/togetherUpdateForm";
	}
	
	//키워드로 레스토랑 리스트 가져오기
	@RequestMapping("/togetherUpdate/searchRestaurant")
	public String searchRestaurant(
			@RequestParam("keywords") String keywords,
			ModelMap model) throws Exception {
		model.addAttribute("sessionFoodCart", new FoodCart()); //카트 초기화
		
		List<Restaurant> restaurantList = this.aloneAlong.searchRestaurantList(keywords);
		model.put("keywords", keywords);
		
		Encoder encoder = Base64.getEncoder(); //이미지
        for(Restaurant res : restaurantList) {     	
        	byte[] imagefile = res.getImgFile();
            String encodedString = encoder.encodeToString(imagefile);
            res.setImg64(encodedString);
        }
		
		model.put("restaurantList", restaurantList);
		System.out.println("키워드 검색 완료");
		return "together/togetherUpdateForm";
	}
	
	//해당 식당의 메뉴 가져오기
	@RequestMapping("/togetherUpdate/searchMenu")
	public String selectRestaurant(
			@RequestParam("resId") String resId,
			@SessionAttribute("sessionFoodCart") FoodCart foodCart,
			ModelMap model) throws Exception {
		Restaurant restaurant = aloneAlong.getRestaurantByResId(resId);
		List<Food> foodList = aloneAlong.getFoodListByRestaurant(resId);
		
		model.put("keywords", restaurant.getResName()); //검색창에 레스토랑 이름 세팅하기
		model.put("selectedRes", restaurant);
		
		Encoder encoder = Base64.getEncoder(); //음식 이미지
		byte[] imagefile;
		String encodedString;
        for(Food food : foodList) {
        	imagefile = food.getImgFile();
            encodedString = encoder.encodeToString(imagefile);
            food.setImg64(encodedString);
        }
		
		model.addAttribute("foodList", foodList);
		System.out.println("메뉴 검색 완료");
		
		model.put("foodCart", foodCart.getAllFoodCartItems());
		
		return "together/togetherUpdateForm";
	}
	
	//together 수정
	@GetMapping("/togetherUpdate/{togetherId}/complete")
	public String updateTogether(
			HttpServletRequest request,
			SessionStatus status,
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
		
		status.setComplete(); //카트 제거
		
		List<Together> togetherList = aloneAlong.getTogetherList();
		model.addAttribute("togetherList", togetherList);
		
		return "redirect:/together";
	}
}
