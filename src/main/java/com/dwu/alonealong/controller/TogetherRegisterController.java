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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Order;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"retaurantList", "sessionFoodCart"})
public class TogetherRegisterController {
	private AloneAlongFacade aloneAlong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/togetherRegister")
	public String handleRequest(
			HttpServletRequest request,
			ModelMap model) throws Exception {
		System.out.println("등록하기 페이지로 들어가기");
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		
		if(userSession == null) {
			return "redirect:/login";
		}
		return "together/togetherRegisterForm";
	}
	
	//키워드로 레스토랑 리스트 가져오기
	@RequestMapping("/togetherRegister/searchRestaurant")
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
		return "together/togetherRegisterForm";
	}
	
	//해당 식당의 메뉴 가져오기
	@RequestMapping("/togetherRegister/searchMenu")
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
		
		return "together/togetherRegisterForm";
	}
	
	//together 등록
	@RequestMapping("/togetherRegister/complete")
	public String insertTogether(
			HttpServletRequest request,
			SessionStatus status,
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
		aloneAlong.insertTogether(together);
		
		System.out.println("Tog_id : " + together.getTogetherId());
		
		//음식 넣기
		for(int i = 0; i < cart.getFoodItemList().size(); i++) {
			TogetherFood togetherFood = new TogetherFood("TOGFOOD_ID.NEXTVAL", together.getTogetherId(), cart.getFoodItemList().get(i).getFood().getFoodId() , cart.getFoodItemList().get(i).getQuantity());
			aloneAlong.insertTogetherFood(togetherFood);
		}
		
		//멤버 넣기
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
		
		System.out.println("유저아이디" + user.getId());
		
		TogetherMember togetherMember = new TogetherMember("TOGMEM_ID.NEXTVAL", user.getId(), together.getTogetherId(), 1);
		aloneAlong.insertTogetherMember(togetherMember);
		
		//결제 정보에는 들어가기(결제상태는x)
		Order order = new Order("ORDER_ID.NEXTVAL", together.getPrice(), "결제 대기중", user.getId(), "결제 대기중", "결제 대기중", "결제 대기중");
		aloneAlong.insertTogetherOrderInfo(order);
		
		TogetherOrder togetherOrder = new TogetherOrder(order.getOrderId(), together.getTogetherId());
		aloneAlong.insertTogetherOrder(togetherOrder);
		
		status.setComplete(); //카트 제거
		
		List<Together> togetherList = aloneAlong.getTogetherList();
		model.addAttribute("togetherList", togetherList);
		
//		Together together2 = this.aloneAlong.getTogetherByTogId(together.getTogetherId());
//		
//		System.out.println("Tog_id : " + together2.getTogetherId());
//		
//		model.put("together", together2);
		
		return "redirect:/together";
	}
	
}
