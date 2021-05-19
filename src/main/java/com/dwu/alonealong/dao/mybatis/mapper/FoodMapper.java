package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dwu.alonealong.domain.Food;

@Mapper
public interface FoodMapper {
	
	List<Food> getFoodListByResId(String resId);
	
	Food getFood(String foodId);
	
	void insertFood(Food food);	
	void updateFood(Food food);	
	void deleteFood(Food food);
	
}
