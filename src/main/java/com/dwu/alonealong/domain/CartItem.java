package com.dwu.alonealong.domain;

import java.io.Serializable;

import com.dwu.alonealong.dao.ProductDAO;

@SuppressWarnings("serial")
public class CartItem implements Serializable {

  /* Private Fields */
  private String cartItemId;
  private String userId;
  private String productId;
  private int quantity;
  private int price;
  private int shippingFee;

  /* JavaBeans Properties */

  public String getCartItemId() { return cartItemId; }
  public void setCartItemId(String cartItemId) { this.cartItemId = cartItemId.trim(); }
  
  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }
  
  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) { this.quantity = quantity; }

  /* Public methods */
  public int getUnitPrice() {
	  int unitPrice = 0;
	  unitPrice += quantity * price;
	  if (unitPrice <= 30000) {
		  unitPrice += shippingFee;
	  }
	  return unitPrice;
  }

  public void incrementQuantity() {
    quantity++;
  }
  
  public void decrementQuantity() {
	if(quantity > 0) quantity--;
  }
}
