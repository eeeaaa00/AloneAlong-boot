package com.dwu.alonealong.domain;

import java.io.Serializable;
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
	private Restaurant restaurant;
	private List<TogetherFood> togetherFoodList;
	private List<TogetherMember> togetherMemberList;
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

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//참여중인 멤버수 구하기
	public int getNumOfMem() {
		return togetherMemberList.size();
	}

	@Override
	public String toString() {
		return "Together [togetherId=" + togetherId + ", togetherName=" + togetherName + ", headCount=" + headCount
				+ ", togetherDate=" + togetherDate + ", togetherTime=" + togetherTime + ", sex=" + sex + ", age=" + age
				+ ", togetherDes=" + togetherDes + ", restaurant=" + restaurant + ", togetherFoodList="
				+ togetherFoodList + ", togetherMemberList=" + togetherMemberList + ", status=" + status + "]";
	}
	
	
}
