package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Payment implements Serializable{
	
	private String cardName;
	private String cardNumber;
	private String cardDate;
	
	

	public Payment(String cardName, String cardNumber, String cardDate) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cardDate = cardDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String name) {
		this.cardName = name;
	}

	public String getCardDate() {
		return cardDate;
	}

	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}

}
