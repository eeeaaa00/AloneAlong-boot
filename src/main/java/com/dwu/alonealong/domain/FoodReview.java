package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodReview implements Serializable{
	
	String reviewId;
	String foodId;
	String resId;
	String userId;
	String reviewDate;
	int rating;
	String contents;
	int recommend;
	
	String userNickName;
	
	
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public FoodReview(String foodId, String resId, String userId, int rating,
			String contents, int recommend) {
		super();
		this.foodId = foodId;
		this.resId = resId;
		this.userId = userId;
		this.rating = rating;
		this.contents = contents;
		this.recommend = recommend;
	}
	public FoodReview(String reviewId, String foodId, String resId, String userId, String reviewDate, int rating,
			String contents, int recommend) {
		super();
		this.reviewId = reviewId;
		this.foodId = foodId;
		this.resId = resId;
		this.userId = userId;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.contents = contents;
		this.recommend = recommend;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	@Override
	public String toString() {
		return "FoodReview [reviewId=" + reviewId + ", foodId=" + foodId + ", resId=" + resId + ", userId=" + userId
				+ ", reviewDate=" + reviewDate + ", rating=" + rating + ", contents=" + contents + ", recommend="
				+ recommend + "]";
	}
	
	
}
