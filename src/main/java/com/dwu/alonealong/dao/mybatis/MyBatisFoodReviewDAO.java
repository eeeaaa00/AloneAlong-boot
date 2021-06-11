package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.FoodReviewDAO;
import com.dwu.alonealong.dao.mybatis.mapper.FoodMapper;
import com.dwu.alonealong.dao.mybatis.mapper.FoodReviewMapper;
import com.dwu.alonealong.domain.FoodReview;

@Repository
public class MyBatisFoodReviewDAO implements FoodReviewDAO{
	
	@Autowired
	private FoodReviewMapper foodReviewMapper;

	@Override
	public List<FoodReview> getFoodReviewListByResId(String resId) {
		// TODO Auto-generated method stub
		return foodReviewMapper.getFoodReviewListByResId(resId);
	}
	@Override
	public void insertFoodReview(FoodReview foodReview) {
		foodReviewMapper.insertFoodReview(foodReview);
		
	}

	//사용예정 없음.
	@Override
	public void deleteFoodReview(FoodReview foodReview) {
		foodReviewMapper.deleteFoodReview(foodReview);
		
	}
	//사용예정 없음
	@Override
	public List<FoodReview> getFoodReviewListByUserId(String userId) {
		return foodReviewMapper.getFoodReviewListByUserId(userId);
	}

	
}
