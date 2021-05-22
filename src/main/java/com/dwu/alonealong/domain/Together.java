package com.dwu.alonealong.domain;

import java.util.Date;

public class Together {
	
	private String togetherId;
	private String togetherName;
	private int headCount;
	private Date togetherDate;
	private Date togetherTime;
	private String togetherDes;
	private String sex; //카테고리 없애고 추가
	private String age; //카테고리 없애고 추가
	private String resId; //
	private Food[] foodList; ///////////
	private String togetherMemberId; //변경
	private boolean status;
	
	public Together() {

	}
	
	public String getTogetherId() {
		return togetherId;
	}
	public void setTogetherId(String togetherId) {
		this.togetherId = togetherId;
	}
	public String getTogetherName() {
		return togetherName;
	}
	public void setTogetherName(String togetherName) {
		this.togetherName = togetherName;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public Date getTogetherDate() {
		return togetherDate;
	}
	public void setTogetherDate(Date togetherDate) {
		this.togetherDate = togetherDate;
	}
	public Date getTogetherTime() {
		return togetherTime;
	}
	public void setTogetherTime(Date togetherTime) {
		this.togetherTime = togetherTime;
	}
	public String getTogetherDes() {
		return togetherDes;
	}
	public void setTogetherDes(String togetherDes) {
		this.togetherDes = togetherDes;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public Food[] getFoodList() {
		return foodList;
	}
	public void setFoodList(Food[] foodList) {
		this.foodList = foodList;
	}
	
	public String getTogetherMemberId() {
		return togetherMemberId;
	}

	public void setTogetherMemberId(String togetherMemberId) {
		this.togetherMemberId = togetherMemberId;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
