package com.dwu.alonealong.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.domain.User;

@SuppressWarnings("serial")
public class PaymentForm implements Serializable {

	private Payment payment;
	private boolean newPayment;

	public PaymentForm(Payment payment) {
		this.payment = payment;
		this.newPayment = false;
	}

	public PaymentForm() {
		this.payment = new Payment();
		
		this.newPayment = true;
	}

	public Payment getPayment() {
		return payment;
	}

	public boolean isNewPayment() {
		return newPayment;
	}
	
}