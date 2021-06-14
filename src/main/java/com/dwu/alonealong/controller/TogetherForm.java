package com.dwu.alonealong.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;

@SuppressWarnings("serial")
public class TogetherForm implements Serializable {
	private String togetherName;
	private int headCount;
	private String togetherDate;
	private String togetherTime;
	private String sex;
	private String age;
	private String togetherDes;
	private String resId;
	private int status;
	private int price;
	
	//음식 정보, 유저 정보(구현중)//////////////
	private FoodCart foodCart;
	private String userId;
	
	public String getTogetherName() {return togetherName;}
	public void setTogetherName(String togetherName) {this.togetherName = togetherName;}
	
	public int getHeadCount() {return headCount;}
	public void setHeadCount(int headCount) {this.headCount = headCount;}
	
	public String getTogetherDate() {return togetherDate;}
	public void setTogetherDate(String togetherDate) {this.togetherDate = togetherDate;}
	
	public String getTogetherTime() {return togetherTime;}
	public void setTogetherTime(String togetherTime) {this.togetherTime = togetherTime;}
	
	public String getSex() {return sex;}
	public void setSex(String sex) {this.sex = sex;}
	
	public String getAge() {return age;}
	public void setAge(String age) {this.age = age;}
	
	public String getTogetherDes() {return togetherDes;}
	public void setTogetherDes(String togetherDes) {this.togetherDes = togetherDes;}
	
	public String getResId() {return resId;}
	public void setResId(String resId) {this.resId = resId;}
	
	public int getStatus() {return status;}
	public void setStatus(int status) {this.status = status;}
	
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	
	public FoodCart getFoodCart() {return foodCart;}
	public void setFoodCart(FoodCart foodCart) {this.foodCart = foodCart;}
	
	public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}
	
}
