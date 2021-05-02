package com.dwu.alonealong.domain;

import java.util.Date;

public class Review {
	private String reviewId;
	private String userId;
	private Date date;
	private double rating;
	private String content;
	private int recommend;
	
	
	public Review(String reviewId, String userId, Date date, double rating, String content, int recommend) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.date = date;
		this.rating = rating;
		this.content = content;
		this.recommend = recommend;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", userId=" + userId + ", date=" + date + ", rating=" + rating
				+ ", content=" + content + ", recommend=" + recommend + "]";
	}
	
	
}
