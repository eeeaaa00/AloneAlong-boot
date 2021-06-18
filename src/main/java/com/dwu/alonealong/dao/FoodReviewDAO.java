package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.FoodReview;


public interface FoodReviewDAO { //수정이 불가능하니 신중한 리뷰 작성 부탁드립니다. 라고 미리공
	List<FoodReview> getFoodReviewListByUserId(String userId) throws DataAccessException;
	
	List<FoodReview> getFoodReviewListByResId(String resId, String sortType) throws DataAccessException;
	
	void insertFoodReview(FoodReview foodReview) throws DataAccessException;
	
	void deleteFoodReview(FoodReview foodReview) throws DataAccessException;
	
	//void recommendFoodReview(FoodReview foodReview);
}
