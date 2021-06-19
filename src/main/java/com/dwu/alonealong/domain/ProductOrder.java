package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ProductOrder implements Serializable {

  /* Private Fields */
  private String orderId;
  private String orderDate;
  private int totalPrice;
  private String status; //현재 DB에는 존재하지만 이용X
  private String userId;
  private String cardNum;
  private String cardMonth;
  private String cardYear;
  private String cardCVC;
  private String cardName;
  private String shipName;
  private String shipPhone1;
  private String shipPhone2;
  private String shipPhone3;
  private String shipEmail;
  private String shipZip;
  private String shipAddress; 
  private String shipAddress2;
  
  private List<ProductLineItem> lineItems = new ArrayList<ProductLineItem>();

  /* JavaBeans Properties */

  public String getOrderId() { return orderId;  }
  public void setOrderId(String orderId) { this.orderId = orderId; }
  
  public String getOrderDate() { return orderDate; }
  public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
  
  public int getTotalPrice() { return totalPrice; }
  public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
  
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  
  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }
  
  public String getCardNum() { return cardNum; }
  public void setCardNum(String cardNum) { this.cardNum = cardNum; }
  
  public String getCardMonth() { return cardMonth; }
  public void setCardMonth(String cardMonth) { this.cardMonth = cardMonth; }
  public String getCardYear() { return cardYear; }
  public void setCardYear(String cardYear) { this.cardYear = cardYear; }
  
  public String getCardName() { return cardName; }
  public void setcardName(String cardName) { this.cardName = cardName; }

  public String getCardCVC() { return cardCVC; }
  public void setCardCVC(String cardCVC) { this.cardCVC = cardCVC; }
  
  public List<ProductLineItem> getLineItems() { return lineItems; }
  public void setLineItems(List<ProductLineItem> lineItems) { this.lineItems = lineItems; }
    
  public String getShipName() { return shipName; }
  public void setShipName(String shipName) { this.shipName = shipName; }
  
  public String getShipZip() { return shipZip; }
  public void setShipZip(String shipZip) { this.shipZip = shipZip; }
  
  public String getShipAddress() { return shipAddress; }
  public void setShipAddress(String shipAddress) { this.shipAddress = shipAddress; }
  public String getShipAddress2() { return shipAddress2; }
  public void setShipAddress2(String shipAddress2) { this.shipAddress2 = shipAddress2; }
  
  public String getShipPhone1() { return shipPhone1; }
  public void setShipPhone1(String shipPhone1) { this.shipPhone1 = shipPhone1; }
  public String getShipPhone2() { return shipPhone2; }
  public void setShipPhone2(String shipPhone2) { this.shipPhone2 = shipPhone2; }
  public String getShipPhone3() { return shipPhone3; }
  public void setShipPhone3(String shipPhone3) { this.shipPhone3 = shipPhone3; }

  public String getShipEmail() { return shipEmail; }
  public void setShipEmail(String shipEmail) { this.shipEmail = shipEmail; }
  
  @Override
  public String toString() {
	return "ProductOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", status="
			+ status + ", userId=" + userId + ", cardNum=" + cardNum + ", cardMonth=" + cardMonth + ", cardYear="
			+ cardYear + ", cardName=" + cardName + ", shipName=" + shipName + ", shipPhone1=" + shipPhone1
			+ ", shipPhone2=" + shipPhone2 + ", shipPhone3=" + shipPhone3 + ", shipEmail=" + shipEmail + ", shipZip="
			+ shipZip + ", shipAddress=" + shipAddress + "]";
  }
  
  public int getShippingFee() {
	if(getTotalPrice() < 30000) {
		return 3000;
	}
	else {
		return 0;
	}
  }
}