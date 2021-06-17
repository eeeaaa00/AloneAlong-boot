package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FoodOrder implements Serializable{
	
	String resId;
	String userId;
	List<FoodCartItem> foodList;
	List<FoodLineItem> orderedList;
	String reserveType;
	String visitDate;
	Payment payment;
	
	String firstFoodId;
	String firstFoodName;
	byte[] resImg;
	String resName;
	String img64;
	int totalPrice;
	String orderId;
	String orderDate;
	
  //togetherOrder 넣기 위해 추가
	String foodId;
	public FoodOrder() {
		
	}
	
	//주문용 생성자
	public FoodOrder(String resId, String userId, List<FoodCartItem> foodList, String reserveType, String visitDate, Payment payment) {
		super();
		this.resId = resId;
		this.userId = userId;
		this.foodList = foodList;
		this.reserveType = reserveType;
		this.visitDate = visitDate;
		this.payment = payment;
	}
	//주문확인용 생성자
	public FoodOrder(String orderId, String orderDate, int totalPrice, String resId, List<FoodLineItem> orderedList, String reserveType, String visitDate, String cardName) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.resId = resId;
		this.orderedList = orderedList;
		this.reserveType = reserveType;
		this.visitDate = visitDate;
		this.payment.setCard_name(cardName);
	}
	//Together order시에 foodOrder를 위한 생성자
	public FoodOrder(String orderId, String reserveType, String visitDate, String foodId, String resId) {
		super();
		this.resId = resId;
		this.reserveType = reserveType;
		this.visitDate = visitDate;
		this.orderId = orderId;
		this.foodId = foodId;	
	}
	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getImg64() {
		return img64;
	}

	public void setImg64(String img64) {
		this.img64 = img64;
	}

	public String getFirstFoodName() {
		return firstFoodName;
	}

	public void setFirstFoodName(String firstFoodName) {
		this.firstFoodName = firstFoodName;
	}

	public byte[] getResImg() {
		return resImg;
	}

	public void setResImg(byte[] resImg) {
		this.resImg = resImg;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int calcTotalPrice() {
		int total = 0;
		for(FoodCartItem item : foodList) {
			total += item.getUnitPrice();
		}
		return total;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public List<FoodLineItem> getOrderedList() {
		return orderedList;
	}

	public void setOrderedList(List<FoodLineItem> orderedList) {
		this.orderedList = orderedList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getFirstFoodId() {
		return foodList.get(0).getFood().getFoodId();
	}

	public void setFirstFoodId(String firstFoodId) {
		this.firstFoodId = firstFoodId;
	}
	
	@Override
	public String toString() {
		return "FoodOrder [resId=" + resId + ", userId=" + userId + ", foodList=" + foodList + ", reserveType="
				+ reserveType + ", visitDate=" + visitDate + ", payment=" + payment + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<FoodCartItem> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<FoodCartItem> foodList) {
		this.foodList = foodList;
	}
	
	public String getReserveType() {
		return reserveType;
	}
	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

}
