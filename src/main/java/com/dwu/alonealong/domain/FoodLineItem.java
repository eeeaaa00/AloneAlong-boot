package com.dwu.alonealong.domain;

public class FoodLineItem {
	private String orderId;
	private String foodId;
	private int quantity;
	private int unitPrice;
	
	
	public FoodLineItem(String orderId, String foodId, int quantity, int unitPrice) {
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		return "FoodLineItem [orderId=" + orderId + ", foodId=" + foodId + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + "]";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
}
