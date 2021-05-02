package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class ProductOrder implements Serializable {

  /* Private Fields */

  private String orderId;
  private String date;
  private int totalPrice;
  private String status;
  private String userId;
  private String cardNum;
  private String cardDate;
  private String shipName;
  private String shipZip;
  private String shipAddress;
  private String shipPhone; 
  
  private List<LineItem> lineItems = new ArrayList<LineItem>();

  /* JavaBeans Properties */

  public String getOrderId() { return orderId;  }
  public void setOrderId(String orderId) { this.orderId = orderId; }
  
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }
  
  public int getTotalPrice() { return totalPrice; }
  public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
  
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  
  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }
  
  public String getCardNum() { return cardNum; }
  public void setCardNum(String cardNum) { this.cardNum = cardNum; }
  
  public String getCardDate() { return cardDate; }
  public void setCardDate(String cardDate) { this.cardDate = cardDate; }
  
  public List<LineItem> getLineItems() { return lineItems; }
  public void setLineItems(List<LineItem> lineItems) { this.lineItems = lineItems; }
  
  public void addLineItem(CartItem cartItem) {  LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);  addLineItem(lineItem); }
  public void addLineItem(LineItem lineItem) {  lineItems.add(lineItem); }

  public String getShipName() { return shipName; }
  public void setShipName(String shipName) { this.shipName = shipName; }
  
  public String getShipZip() { return shipZip; }
  public void setShipZip(String shipZip) { this.shipZip = shipZip; }
  
  public String getShipAddress() { return shipAddress; }
  public void setShipAddress(String shipAddress) { this.shipAddress = shipAddress; }
  
  public String getShipPhone() { return shipPhone; }
  public void setShipPhone(String shipPhone) { this.shipPhone = shipPhone; }
  
  /* Public Methods */

  //장바구니에서 주문으로 넘어간 경우
//  public void initOrderByCart(Account account, Cart cart) { 
//	  setTotalPrice(cart.getTotalPrice());
//	  for(CartItem cartItem : cart.getCartItemList()) {
//		  LineItem lineItem = new LineItem();
//		  lineItems.add(lineItem);
//	  }
//  }
  /*
  //기등록 결제방식 사용
  public void setOrderByPaymentmethod(Paymentmethod method) {
	  setCardNum(method.getCardNum);
	  setCardDate(method.getCardDate);
  }
  
  //배송정보가 주문정보와 동일
  public void setShipInfoByUserInfo(Account account) {
	  setShipName(account.getUsername());
	  setShipZip(account.getZip());
	  setShipAddress(account.getAddress());
	  setShipPhone(account.getPhone());
  }
  */
}