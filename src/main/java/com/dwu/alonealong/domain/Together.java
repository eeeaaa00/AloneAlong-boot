package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Together implements Serializable {
	
	private String togetherId;
	private String togetherName;
	private int headCount;
	private Date togetherDate;
	private Date togetherTime;
	private String sex;
	private String age;
	private String togetherDes;
	private String resId;
	private boolean status;
	private Restaurant restaurant;
	private List<TogetherFood> togetherFoodList = new ArrayList<TogetherFood>();
	private List<TogetherMember> togetherMemberList = new ArrayList<TogetherMember>();
	
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


	public String getTogetherDes() {
		return togetherDes;
	}


	public void setTogetherDes(String togetherDes) {
		this.togetherDes = togetherDes;
	}


	public String getResId() {
		return resId;
	}


	public void setResId(String resId) {
		this.resId = resId;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public List<TogetherFood> getTogetherFoodList() {
		return togetherFoodList;
	}


	public void setTogetherFoodList(List<TogetherFood> togetherFoodList) {
		this.togetherFoodList = togetherFoodList;
	}


	public List<TogetherMember> getTogetherMemberList() {
		return togetherMemberList;
	}


	public void setTogetherMemberList(List<TogetherMember> togetherMemberList) {
		this.togetherMemberList = togetherMemberList;
	}

	@Override
	public String toString() {
		return "Together [togetherId=" + togetherId + ", togetherName=" + togetherName + ", headCount=" + headCount
				+ ", togetherDate=" + togetherDate + ", togetherTime=" + togetherTime + ", sex=" + sex + ", age=" + age
				+ ", togetherDes=" + togetherDes + ", resId=" + resId + ", status=" + status + ", restaurant="
				+ restaurant + ", togetherFoodList=" + togetherFoodList + ", togetherMemberList=" + togetherMemberList
				+ "]";
	}
	
	//현재 맴버 수 구하기
	public int getNumOfMem() {
		return togetherMemberList.size();
	}
	
	//음식 총합 구하기
	public int getTotalPrice() {
		int sum = 0;
		for(int i = 0; i < togetherFoodList.size(); i++) {
			sum += togetherFoodList.get(i).getFood().getPrice() * togetherFoodList.get(i).getQuantity();
		}
		return sum;
	}
	
	//1인당 음식 가격 구하기
	public int getPricePerPerson() {
		return getTotalPrice() / headCount;
	}
	
}
