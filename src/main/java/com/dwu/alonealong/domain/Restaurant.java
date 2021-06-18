package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;

public class Restaurant implements Serializable{
	private String resId;
	private String resName;
	private String resAddress;
	private String resPhone;
	private String ownerId;
	private String resDescription;
	private Double avgRating;
	private String categoryId; //음식분류
	private byte[] imgFile;
	private String img64;
	private boolean isTogetherOk;
	private String area;
	
	private User owner;
	private FoodReview[] reviewList;
	private Food[] menuList;
	private Together[] togetherList;
	
	//조회용
	public Restaurant(String resId, String resName, String resAddress, String resPhone, String ownerId,
			String resDescription, Double avgRating, String categoryId, byte[] imgFile, boolean isTogetherOk, String area) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.resPhone = resPhone;
		this.ownerId = ownerId;
		this.resDescription = resDescription;
		this.avgRating = avgRating;
		this.categoryId = categoryId;
		this.imgFile = imgFile;
		this.isTogetherOk = isTogetherOk;
		this.area = area;
	}
	
	//생성용
	public Restaurant(String resId, String resName, String resAddress, String resPhone,
			String resDescription, String categoryId, byte[] imgFile, boolean isTogetherOk, String area) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.resPhone = resPhone;
		this.resDescription = resDescription;
		this.categoryId = categoryId;
		this.imgFile = imgFile;
		this.isTogetherOk = isTogetherOk;
		this.area = area;
	}
	
	
	public Restaurant(){
		
	}
	
	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
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
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
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
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
	public boolean getIsTogetherOk() {
		return isTogetherOk;
	}
	public boolean isTogetherOk() {
		return isTogetherOk;
	}
	public void setTogetherOk(boolean isTogetherOk) {
		this.isTogetherOk = isTogetherOk;
	}
	public FoodReview[] getReviewList() {
		return reviewList;
	}
	public void setReviewList(FoodReview[] reviewList) {
		this.reviewList = reviewList;
	}
	public Food[] getMenuList() {
		return menuList;
	}
	public void setMenuList(Food[] menuList) {
		this.menuList = menuList;
	}
	public Together[] getTogetherList() {
		return togetherList;
	}
	public void setTogetherList(Together[] togetherList) {
		this.togetherList = togetherList;
	}
	
	@Override
	public String toString() {
		return "Restaurant [resId=" + resId + ", resName=" + resName + ", categoryId=" + categoryId + ", resAddress="
				+ resAddress + ", owner=" + owner + ", resPhone=" + resPhone + ", resDescription=" + resDescription
				+ ", avgRating=" + avgRating + ", imgFile=" + imgFile + ", isTogetherOk=" + isTogetherOk
				+ ", reviewList=" + Arrays.toString(reviewList) + ", menuList=" + Arrays.toString(menuList)
				+ ", togetherList=" + Arrays.toString(togetherList) + "]";
	}
}