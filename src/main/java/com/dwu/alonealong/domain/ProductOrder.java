package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
  private String billName;
  private String billPhone;
  private String shipName;
  private int shipZip;
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

  public String getBillName() { return billName; }
  public void setBillName(String billName) { this.billName = billName; }
  
  public String getBillPhone() { return billPhone; }
  public void setBillPhone(String billPhone) { this.billPhone = billPhone; }
  
  public String getShipName() { return shipName; }
  public void setShipName(String shipName) { this.shipName = shipName; }
  
  public int getShipZip() { return shipZip; }
  public void setShipZip(int shipZip) { this.shipZip = shipZip; }
  
  public String getShipAddress() { return shipAddress; }
  public void setShipAddress(String shipAddress) { this.shipAddress = shipAddress; }
  
  public String getShipPhone() { return shipPhone; }
  public void setShipPhone(String shipPhone) { this.shipPhone = shipPhone; }
  
  /* Public Methods */
  public void initProductOrder(User user, Payment paymentMethod, List<ProductLineItem> orderList) {
	  totalPrice = 0;
	  //status = ?;
	  
	  userId = user.getId();
	  date = (new Date()).toString();

	  shipName = user.getName();
	  shipPhone = user.getPhone();
	  shipZip = user.getZip();
	  shipAddress = user.getAddress();

	  billName = user.getName();
	  billPhone = user.getPhone();
	  
	  if(paymentMethod != null) {
		  cardNum = paymentMethod.getCardNumber();
		  cardDate = paymentMethod.getCardDate();
	  }
	  
	  for(ProductLineItem orderItem : orderList) {
		  totalPrice += orderItem.getUnitPrice();
	  }
	}

  //��ٱ��Ͽ��� �ֹ����� �Ѿ ���
//  public void initOrderByCart(Account account, Cart cart) { 
//	  setTotalPrice(cart.getTotalPrice());
//	  for(CartItem cartItem : cart.getCartItemList()) {
//		  LineItem lineItem = new LineItem();
//		  lineItems.add(lineItem);
//	  }
//  }
  /*
  //���� ������� ���
  public void setOrderByPaymentmethod(Paymentmethod method) {
	  setCardNum(method.getCardNum);
	  setCardDate(method.getCardDate);
  }
  
  //��������� �ֹ������� ����
  public void setShipInfoByUserInfo(Account account) {
	  setShipName(account.getUsername());
	  setShipZip(account.getZip());
	  setShipAddress(account.getAddress());
	  setShipPhone(account.getPhone());
  }
  */
}