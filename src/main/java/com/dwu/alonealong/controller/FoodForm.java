package com.dwu.alonealong.controller;

public class FoodForm {
	private String foodId;
	private String resId;
	private String ownerId;
	private int price;
	private String name;
	
	FoodForm(){
		
	}
	//임시생성자
	FoodForm(String id, String name, int price){
		this.foodId = id;
//		this.resId = resId;
		this.price = price;
		this.name = name;
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
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
