package com.dwu.alonealong.controller;

import java.util.List;

import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.ProductLineItem;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.domain.User;

public class ProductOrderForm {
	private User orderUser;
	private User shipUser;
	private Payment payment;
	private List<ProductLineItem> orderList;
	
	private final ProductOrder productOrder = new ProductOrder();
	
	public ProductOrder getProductOrder(){
		return productOrder;
	}
	
	public void initProductOrder(User user, List<ProductLineItem> orderList, Payment payment) {
		this.orderUser = user;
		this.orderList = orderList;
		this.payment = payment;
	}

	public User getOrderUser() { return orderUser; }
	public void setOrderUser(User orderUser) { this.orderUser = orderUser; }

	public User getShipUser() { return shipUser; }
	public void setShipUser(User shipUser) { this.shipUser = shipUser; }

	public Payment getPayment() { return payment; }
	public void setPayment(Payment payment) { this.payment = payment; }

	public List<ProductLineItem> getOrderList() { return orderList; }
	public void setOrderList(List<ProductLineItem> orderList) { this.orderList = orderList; }
}
