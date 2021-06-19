package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class Payment implements Serializable {

	private String user_id;
	private String card_num;
	private String card_name;
	private String card_date;
	private String card_month;
	private String card_year;
	private String card_cvc;

	public Payment() {

	}

	public Payment(String cardName, String cardNumber, String cardDate, String cardCVC) {
		super();
		this.card_num = cardNumber;
		this.card_name = cardName;
		this.card_date = cardDate;
		this.card_cvc = cardCVC;
	}

	public String getId() {
		return user_id;
	}

	public void setId(String id) {
		this.user_id = id;
	}

	public String getCard_num() {
		return card_num;
	}

	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public String getCard_date() {
		return card_date;
	}

	public void setCard_date(String card_date) {
		this.card_date = card_date;

		String ds = "^\\d{2}/\\d{2}$";
		boolean regex = Pattern.matches(ds, card_date);
		if (regex) {
			StringTokenizer itr = new StringTokenizer(card_date, "/");
			card_month = itr.nextToken();
			card_year = itr.nextToken();
		}
	}

	public String getCard_cvc() {
		return card_cvc;
	}

	public void setCard_cvc(String card_cvc) {
		this.card_cvc = card_cvc;
	}

	public String getCard_month() {
		return card_month;
	}

	public String getCard_year() {
		return card_year;
	}

	@Override
	public String toString() {
		return "Payment [user_id =" + user_id + " cardNUm" + card_num + " cardName" + card_name + " cardCVC" + card_cvc
				+ "]";
	}

}
