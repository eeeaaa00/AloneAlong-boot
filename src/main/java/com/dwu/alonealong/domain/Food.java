package com.dwu.alonealong.domain;

import java.net.URL;

public class Food {
	private String foodId;
	private String resId;
	private String ownerId;
	private int price;
	private String name;
	private String description;
	private URL img;
	private int maxPeopleNum;
	
	public Food(String id, String name, int price){//임시
		this.foodId = id;
//		this.resId = resId;
		this.price = price;
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", resId=" + resId + ", ownerId=" + ownerId + ", price=" + price + ", name="
				+ name + ", description=" + description + ", img=" + img + ", maxPeopleNum=" + maxPeopleNum + "]";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public URL getImg() {
		return img;
	}
	public void setImg(URL img) {
		this.img = img;
	}
	public int getMaxPeopleNum() {
		return maxPeopleNum;
	}
	public void setMaxPeopleNum(int maxPeopleNum) {
		this.maxPeopleNum = maxPeopleNum;
	}
	public Food(String foodId, String resId, String ownerId, int price, String name, String description, URL img,
			int maxPeopleNum) {
		super();
		this.foodId = foodId;
		this.resId = resId;
		this.ownerId = ownerId;
		this.price = price;
		this.name = name;
		this.description = description;
		this.img = img;
		this.maxPeopleNum = maxPeopleNum;
	}
	
	
	
}
