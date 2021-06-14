package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodReview;

@Mapper
public interface FoodReviewMapper {
	
	List<FoodReview> getFoodReviewListByUserId(String userId);
	List<FoodReview> getFoodReviewListByResId(String resId);
	
	void insertFoodReview(FoodReview foodReview);
	void deleteFoodReview(FoodReview foodReview);
	
	
}
