package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"sessionFoodCart"})
public class TogetherFoodCartForRegisterController {

	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	@RequestMapping("/togetherRegister/{resId}/addFoodToCart")
	public String handleRequest(
			@RequestParam("foodId") String foodId,
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			@PathVariable("resId") String resId,
			ModelMap model
			) throws Exception {
		
		System.out.println("현재 음식 사이즈" + cart.getFoodItemList().size());
		if (cart.containsFoodId(foodId)) {
			System.out.println("이미 있는 음식");
			cart.incrementQuantityByFoodId(foodId);
		}
		else {
			Food item = this.alonealong.getFood(foodId);
			if(item == null)
				System.out.println("null들어왔다");
			cart.addFood(item);
			System.out.println("카트에 추가됨");
		}		
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId);
		
		//음식 이미지
		Encoder encoder = Base64.getEncoder();
		byte[] imagefile;
		String encodedString;
        for(Food food : foodList) {
        	imagefile = food.getImgFile();
            encodedString = encoder.encodeToString(imagefile);
            food.setImg64(encodedString);
        }
		
		model.put("foodList", foodList);
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("keywords", res.getResName()); //검색창에 레스토랑 이름 세팅하기
		model.put("selectedRes", res); //선택된 레스토랑
		return "together/togetherRegisterForm";
	}
	
	@RequestMapping("/togetherRegister/{resId}/updateFoodCartItem")
	public String handleRequest2(
			HttpServletRequest request,	
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			@PathVariable("resId") String resId,
			ModelMap model
			) throws Exception {
		
		cart.setQuantityByFoodId(request.getParameter("foodId"), Integer.parseInt(request.getParameter("quantity")));
				
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId); 
		model.put("foodList", foodList);
		
		//음식이미지
		Encoder encoder = Base64.getEncoder();
		byte[] imagefile;
		String encodedString;
        for(Food food : foodList) {
        	imagefile = food.getImgFile();
            encodedString = encoder.encodeToString(imagefile);
            food.setImg64(encodedString);
        }
		
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("keywords", res.getResName()); //검색창에 레스토랑 이름 세팅하기
		model.put("selectedRes", res); //선택된 레스토랑
		return "together/togetherRegisterForm";
	}
	
	@RequestMapping("/togetherRegister/{resId}/deleteFoodCartItem")
	public String handleRequest3(
			HttpServletRequest request,	
			@ModelAttribute("sessionFoodCart") FoodCart cart,
			@PathVariable("resId") String resId,
			ModelMap model
			) throws Exception {
		
		cart.removeFoodById((request.getParameter("foodId")));
		
		List<Food> foodList = this.alonealong.getFoodListByRestaurant(resId);
		
		//음식 이미지
		Encoder encoder = Base64.getEncoder();
		byte[] imagefile;
		String encodedString;
        for(Food food : foodList) {
        	imagefile = food.getImgFile();
            encodedString = encoder.encodeToString(imagefile);
            food.setImg64(encodedString);
        }
		
		model.put("foodList", foodList);
		model.put("foodCart", cart.getAllFoodCartItems());
		model.put("totalPrice", cart.getSubTotal());
		Restaurant res = alonealong.getRestaurantByResId(resId);
		model.put("keywords", res.getResName()); //검색창에 레스토랑 이름 세팅하기
		model.put("selectedRes", res); //선택된 레스토랑
		return "together/togetherRegisterForm";
	}
	
}
