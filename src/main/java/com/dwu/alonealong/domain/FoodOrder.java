package com.dwu.alonealong.domain;

import java.util.Date;

public class FoodOrder {
	Food food;
	String reserveType;
	Date visitDate;
	String ownerId;
	String resId;
	
	@Override
	public String toString() {
		return "FoodOrder [food=" + food + ", reserveType=" + reserveType + ", visitDate=" + visitDate + ", ownerId="
				+ ownerId + ", resId=" + resId + "]";
	}
	public FoodOrder(Food food, String reserveType, Date visitDate, String ownerId, String resId) {
		super();
		this.food = food;
		this.reserveType = reserveType;
		this.visitDate = visitDate;
		this.ownerId = ownerId;
		this.resId = resId;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public String getReserveType() {
		return reserveType;
	}
	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
}
