package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;

public class Restaurant implements Serializable{
	private String resId;
	private String resName;
	private String categoryId; //음식분류
	private String resAddress;
	private User owner;
	private String ownerId;
	private String resPhone;
	private String resDescription;
	private Double avgRating;
	private URL resImage;
	private boolean isTogetherOk;
	private FoodReview[] reviewList;
	private Food[] menuList;
	private Together[] togetherList;
	
	public Restaurant(){
		
	}
	public Restaurant(String resId, String resName, String category, String resAddress){ //임시
		this.resId = resId;
		this.resName = resName;
		this.categoryId = category;
		this.resAddress = resAddress;
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
	public URL getResImage() {
		return resImage;
	}
	public void setResImage(URL resImage) {
		this.resImage = resImage;
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
				+ ", avgRating=" + avgRating + ", resImage=" + resImage + ", isTogetherOk=" + isTogetherOk
				+ ", reviewList=" + Arrays.toString(reviewList) + ", menuList=" + Arrays.toString(menuList)
				+ ", togetherList=" + Arrays.toString(togetherList) + "]";
	}
}
