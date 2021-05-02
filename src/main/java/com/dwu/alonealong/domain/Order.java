package com.dwu.alonealong.domain;

public class Order {
	private int orderId;
	private String orderDate;
	private String totalPrice;
	private String status;
	private User user;
	private String cardName;
	private String cardNum;
	private String cardDate;
	
	public Order(int orderId, String orderDate, String totalPrice, String status, User user, String cardName,
			String cardNum, String cardDate) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.user = user;
		this.cardName = cardName;
		this.cardNum = cardNum;
		this.cardDate = cardDate;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCardDate() {
		return cardDate;
	}
	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", status="
				+ status + ", user=" + user + ", cardName=" + cardName + ", cardNum=" + cardNum + ", cardDate="
				+ cardDate + "]";
	}
	
	
	
}
