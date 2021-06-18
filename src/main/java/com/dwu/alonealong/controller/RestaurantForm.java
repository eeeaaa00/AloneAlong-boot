package com.dwu.alonealong.controller;

import java.net.URL;

import org.springframework.web.multipart.MultipartFile;


public class RestaurantForm {
	
	private String resName;
	private String categoryId; //음식분류
	private String resAddress;
	private String resPhone;
	private String resDescription;
	private String resArea;
	private MultipartFile imgFile;
	private boolean isTogetherOk;
	
	private String img64;
	
	
	public String getImg64() {
		return img64;
	}
	public void setImg64(String img64) {
		this.img64 = img64;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public String getResDescription() {
		return resDescription;
	}
	public void setResDescription(String resDescription) {
		this.resDescription = resDescription;
	}
	public boolean getIsTogetherOk() { //Does the return type of the getter match the parameter type of the setter? 오류날 수 있으니 get 붙이자.
		return isTogetherOk;
	}
	public void setIsTogetherOk(boolean isTogetherOk) {
		this.isTogetherOk = isTogetherOk;
	}
	public String getResArea() {
		return resArea;
	}
	public void setResArea(String resArea) {
		this.resArea = resArea;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	
	
	
	
}
