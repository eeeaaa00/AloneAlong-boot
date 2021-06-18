package com.dwu.alonealong.domain;

import java.io.File;
import java.io.Serializable;
import java.net.URL;

public class Food implements Serializable{
	private String foodId;
	private String resId;
	private String ownerId; //일단 필요없음.
	private int price;
	private String name;
	private String description;
	private byte[] imgFile;
	private String img64;
	private int maxPeopleNum;
	
	public Food() {
	}

	public Food(String resId, String id, String name, int price, String des, byte[] img, int maxPeopleNum){
		this.resId = resId;
		this.foodId = id;
		this.name = name;
		this.price = price;
		this.description = des;
		this.imgFile = img;
		this.maxPeopleNum = maxPeopleNum;
	}
	

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", resId=" + resId + ", ownerId=" + ownerId + ", price=" + price + ", name="
				+ name + ", description=" + description + ", maxPeopleNum=" + maxPeopleNum + "]";
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
	public int getMaxPeopleNum() {
		return maxPeopleNum;
	}
	public void setMaxPeopleNum(int maxPeopleNum) {
		this.maxPeopleNum = maxPeopleNum;
	}

	public Food(String foodId, String resId, String ownerId, int price, String name, String description, byte[] img,
			int maxPeopleNum) {
		super();
		this.foodId = foodId;
		this.resId = resId;
		this.ownerId = ownerId;
		this.price = price;
		this.name = name;
		this.description = description;
		this.imgFile = img;
		this.maxPeopleNum = maxPeopleNum;
	}

	public byte[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(byte[] imgFile) {
		this.imgFile = imgFile;
	}

	public String getImg64() {
		return img64;
	}

	public void setImg64(String img64) {
		this.img64 = img64;
	}
	
	
	
}
