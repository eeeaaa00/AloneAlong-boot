package com.dwu.alonealong.dao;

import java.util.List;

import com.dwu.alonealong.domain.Food;

public interface FoodDAO {
	
	List<Food> getFoodListByResId(String resId);
	
	Food getFood(String foodId);
	
	void insertFood(Food food);
	
	void updateFood(Food food);
	
	void deleteFood(Food food);
	
}
