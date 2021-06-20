package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartItem implements Serializable {

  /* Private Fields */
  private String cartItemId;
  private String userId;
  private String pcId;
  private String productId;
  private String productName;
  private int quantity;
  private int price;
  private int unitPrice;
  private int shippingFee;
  private byte[] img;
  private String img64;

  /* JavaBeans Properties */

  public String getCartItemId() { return cartItemId; }
  public void setCartItemId(String cartItemId) { this.cartItemId = cartItemId.trim(); }
  
  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }

  public String getPcId() { return pcId; }
  public void setPcId(String pcId) { this.pcId = pcId; }

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }

  public String getProductName() { return productName; }
  public void setProductName(String productName) { this.productName = productName; }
  
  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) { this.quantity = quantity; }

  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }

  public int getShippingFee() { return shippingFee; }
  public void setShippingFee(int shippingFee) { this.shippingFee = shippingFee; }

  public byte[] getImg() { return img; }
  public void setImg(byte[] img) { this.img = img; }

  public String getImg64() { return img64; }
  public void setImg64(String img64) { this.img64 = img64; }
  
  /* Public methods */
  public int getUnitPrice() {
	  int totalPrice = 0;
	  totalPrice += quantity * price;
//	  if (totalPrice <= 30000) {
//		  totalPrice += shippingFee;
//	  }
	  this.unitPrice = totalPrice;
	  return unitPrice;
  }

  public void incrementQuantity() {
    quantity++;
  }
  
  public void decrementQuantity() {
	if(quantity > 0) quantity--;
  }
@Override
public String toString() {
	return "CartItem [cartItemId=" + cartItemId + ", userId=" + userId + ", productId=" + productId + ", quantity="
			+ quantity + ", price=" + price + ", shippingFee=" + shippingFee + "]";
}
}
