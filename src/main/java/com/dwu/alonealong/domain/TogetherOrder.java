package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TogetherOrder implements Serializable {
	
	private String orderId;
	private String togetherId;
	private Order order;
	private Together together;
	
	public TogetherOrder() {}

	public TogetherOrder(String orderId, String togetherId) {
		this.orderId = orderId;
		this.togetherId = togetherId;
	}
	
	public String getOrderId() {return orderId;}
	public void setOrderId(String orderId) {this.orderId = orderId;}

	public String getTogetherId() {return togetherId;}
	public void setTogetherId(String togetherId) {this.togetherId = togetherId;}
	
	public Order getOrder() {return order;}
	public void setOrder(Order order) {this.order = order;}

	public Together getTogether() {return together;}
	public void setTogether(Together together) {this.together = together;}
	
}
