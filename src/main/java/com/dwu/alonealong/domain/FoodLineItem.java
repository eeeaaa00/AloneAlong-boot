package com.dwu.alonealong.domain;

public class FoodLineItem {
	private LineItem lineItem;
	private String foodItemId;
	
	public FoodLineItem() {
	}
	
	public FoodLineItem(LineItem lineItem, String foodItemId) {
		super();
		this.lineItem = lineItem;
		this.foodItemId = foodItemId;
	}
	public LineItem getLineItem() {
		return lineItem;
	}
	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}
	public String getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(String foodItemId) {
		this.foodItemId = foodItemId;
	}
	@Override
	public String toString() {
		return "FoodLineItem [lineItem=" + lineItem + ", foodItemId=" + foodItemId + "]";
	}
	
}
