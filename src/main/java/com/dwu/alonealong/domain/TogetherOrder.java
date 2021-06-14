package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TogetherOrder implements Serializable {
	
	private String orderId;
	private String togetherId;
	private Together together;
	
	public TogetherOrder(String orderId, String togetherId) {
		super();
		this.orderId = orderId;
		this.togetherId = togetherId;
	}
	
	public String getOrderId() {return orderId;}
	public void setOrderId(String orderId) {this.orderId = orderId;}

	public String getTogetherId() {return togetherId;}
	public void setTogetherId(String togetherId) {this.togetherId = togetherId;}

	public Together getTogether() {return together;}
	public void setTogether(Together together) {this.together = together;}
	
}
