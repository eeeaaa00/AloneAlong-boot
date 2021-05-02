package com.dwu.alonealong.domain;
import java.io.Serializable;

@SuppressWarnings("serial")
public class LineItem implements Serializable {

  /* Private Fields */

  private int orderId;
  private int lineNumber;
  private int quantity;
  private String itemId;
  private double unitPrice;

  /* Constructors */

  public LineItem() {}

  public LineItem(CartItem cartItem) {
    this.quantity = cartItem.getQuantity();
    this.itemId = cartItem.getCartItemId();
    this.unitPrice = cartItem.getUnitPrice();
  }

  public LineItem(int lineNumber, CartItem cartItem) {
    this.lineNumber = lineNumber;
    this.quantity = cartItem.getQuantity();
    this.itemId = cartItem.getCartItemId();
    this.unitPrice = cartItem.getUnitPrice();
  }

  /* JavaBeans Properties */
  public int getOrderId() { return orderId; }
  public void setOrderId(int orderId) { this.orderId = orderId; }

  public int getLineNumber() { return lineNumber; }
  public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }

  public String getItemId() { return itemId; }
  public void setItemId(String itemId) { this.itemId = itemId; }

  public double getUnitPrice() { return unitPrice; }
  public void setUnitPrice(double unitprice) { this.unitPrice = unitprice; }

  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalPrice() {
	return this.unitPrice * this.quantity;
  }
}