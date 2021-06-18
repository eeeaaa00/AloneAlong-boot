package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodReview;

@Mapper
public interface FoodReviewMapper {
	
	List<FoodReview> getFoodReviewListByUserId(String userId) throws DataAccessException;
	List<FoodReview> getFoodReviewListByResId(String resId, String sortType) throws DataAccessException;
	
	void insertFoodReview(FoodReview foodReview) throws DataAccessException;
	void deleteFoodReview(FoodReview foodReview) throws DataAccessException;
	
	
}
