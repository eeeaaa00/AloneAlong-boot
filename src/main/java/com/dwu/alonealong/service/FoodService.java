package com.dwu.alonealong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dwu.alonealong.controller.FoodForm;
import com.dwu.alonealong.controller.RestaurantForm;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.Restaurant;

@Service
public class FoodService { //db랑 impl 쓰기 전에 내부 데이터 저장 확인용
	
	private int nextFoodId = 0;
	private Map<String, Food> foodMap = new HashMap<>();
	
	public FoodService() {
		foodMap.put("f1", new Food("f1", "단무지", 500));
		foodMap.put("f2", new Food("f2", "김치", 1500));
		foodMap.put("f3", new Food("f3", "일회용 젓가락", 500));
		nextFoodId = 4;
	}
	
	public Food getFood(String foodId) {
		return foodMap.get(foodId);
	}
	
	//수정함수 일단 패스
	
	public List<Food> getFoodList(){
		return new ArrayList<Food>(foodMap.values());
	}
	
	public String insertNewFood(FoodForm form) {
		Food food = new Food("f" + nextFoodId, form.getName(),
				form.getPrice());
		nextFoodId++;
		foodMap.put(food.getFoodId(), food);
		return food.getFoodId();
	}
	
	//음식정보 userId로 불러오는 함수 -> 카트사용
	public Food getFoodByFoodId(String id) {
		for(Food food : foodMap.values()) {
			if(food.getFoodId().equals(id))
				return food;
		}
		return null;
	}
}
