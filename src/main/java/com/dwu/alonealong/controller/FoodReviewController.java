package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Review;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class FoodReviewController {
		
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
		
	@RequestMapping("/eating/{resId}/writeReview")
	@Transactional
	public String insert(
//			@ModelAttribute("food") FoodForm foodForm,
			@PathVariable("resId") String resId,
			HttpServletRequest request,
//			BindingResult bindingResult,
			Model model) {
	
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = alonealong.getUserByUserId(userSession.getUser().getId());
		
		String foodOrderId = "f10"; //foodId로 넣는 것보단 orderId가 나아보임. 그러려면 foodreview의 무결성키 제약조건도 food말고 foodOrder로 바꿔야함. 아닌가 order에서 foodid 가져오는게 나을지도. 그럼 이름도 갖고오고..
		String userId = user.getId(); 
		int rating = Integer.parseInt(request.getParameter("rating"));
		String contents = request.getParameter("review");
		FoodReview foodReview = new FoodReview(foodOrderId, resId, userId, rating, contents, 0);

		alonealong.insertFoodReview(foodReview);
		alonealong.updateAvgRating(rating, resId);
		//식당 평균별점 update 시키는 코드.
		System.out.println("insertReview 진행");
		return "redirect:/eating/{resId}/RestaurantReview";

	}
	
//	@RequestMapping(value = "/delete")
//	public String delete(
//			@RequestParam("foodId") String foodId,
//			@PathVariable("resId") String resId,
////			BindingResult bindingResult,
//			Model model) {
//		
//		alonealong.deleteFood(foodId);
//		
//		List<Food> foodList = alonealong.getFoodListByRestaurant(resId);
//		model.addAttribute("foodList", foodList);
//		return "redirect:/eating/{resId}";
//	}
	
	
}
