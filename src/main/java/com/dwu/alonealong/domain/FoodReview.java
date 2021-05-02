package com.dwu.alonealong.domain;

public class FoodReview {
	private Review review;
	private String foodId;
	
	public FoodReview() {
	}
	public FoodReview(Review review, String foodId) {
		super();
		this.review = review;
		this.foodId = foodId;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	@Override
	public String toString() {
		return "FoodReview [review=" + review + ", foodId=" + foodId + "]";
	}
	
	
}
