package com.dwu.alonealong.controller;

import java.util.Date;

import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Payment;

public class FoodOrderForm {
	
	private FoodCart foodCart;
	private String reserveType;
	private String visitDate;
	private String visitTime;
	String ccName;
	String ccNum;
	String ccDate;
	String ccCVC;
	private Payment payment;
	
	FoodOrderForm(){
		
	}

	public FoodOrderForm(FoodCart foodCart, String reserveType, String visitDate, Payment payment) {
		super();
		this.foodCart = foodCart;
		this.reserveType = reserveType;
		this.visitDate = visitDate;
		this.payment = payment;
	}

	public String getCcCVC() {
		return ccCVC;
	}

	public void setCcCVC(String ccCVC) {
		this.ccCVC = ccCVC;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getCcNum() {
		return ccNum;
	}

	public void setCcNum(String ccNum) {
		this.ccNum = ccNum;
	}

	public String getCcDate() {
		return ccDate;
	}

	public void setCcDate(String ccDate) {
		this.ccDate = ccDate;
	}
	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	
}
