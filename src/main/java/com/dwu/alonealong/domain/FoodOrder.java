package com.dwu.alonealong.domain;

import java.util.Date;
import java.util.List;

public class FoodOrder {
	
	String resId;
	String userId;
	List<FoodCartItem> foodList;
	String reserveType;
	String visitDate;
	Payment payment;
	
	String firstFoodId;
	int totalPrice;
	
	public FoodOrder() {
		
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for(FoodCartItem val : foodList) {
			sum += val.getTotalPrice();
		}
		return sum;
	}
	
	public String getFirstFoodId() {
		return foodList.get(0).getFood().getFoodId();
	}

	public void setFirstFoodId(String firstFoodId) {
		this.firstFoodId = firstFoodId;
	}

	public FoodOrder(String resId, String userId, List<FoodCartItem> foodList, String reserveType, String visitDate, Payment payment) {
		super();
		this.resId = resId;
		this.userId = userId;
		this.foodList = foodList;
		this.reserveType = reserveType;
		this.visitDate = visitDate;
		this.payment = payment;
	}
	
	
	
	@Override
	public String toString() {
		return "FoodOrder [resId=" + resId + ", userId=" + userId + ", foodList=" + foodList + ", reserveType="
				+ reserveType + ", visitDate=" + visitDate + ", payment=" + payment + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<FoodCartItem> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<FoodCartItem> foodList) {
		this.foodList = foodList;
	}
	
	public String getReserveType() {
		return reserveType;
	}
	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
}
