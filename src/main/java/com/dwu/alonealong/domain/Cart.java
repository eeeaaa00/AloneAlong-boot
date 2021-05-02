package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

@SuppressWarnings("serial")
public class Cart implements Serializable {

  /* Private Fields */
  private String userId;
  private List<CartItem> cartItemList;
  private final Map<String, CartItem> cartItemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
 //  private final PagedListHolder<CartItem> itemList = new PagedListHolder<CartItem>();

  /* JavaBeans Properties */

  public void setUserId(String userId) { this.userId = userId; }
  public String getUserId() { return userId; }
  
  public void setCartItemList(List<CartItem> cartItemList) { this.cartItemList = cartItemList; }
  public List<CartItem> getCartItemList() { return cartItemList; }
  
  /* Public Methods */
  
  public boolean containsItemId(String cartItemId) {
    return cartItemMap.containsKey(cartItemId);
  }

  public int getNumOfCartItem() {
	  return cartItemList.size();
  }
  
//  public void addItem(CartItem cartItem, boolean isInStock) {
//	String productId = cartItem.getProductId();
//	for(CartItem listItem : cartItemList) {
//		if (listItem.getProductId() == productId) {
//			cartItem.incrementQuantity();
//			return;
//		}
//	}
//	//else
//	cartItemList.add(cartItem);
//	cartItemMap.put(cartItem.getCartItemId(), cartItem);
//	
//  }
//
//  public CartItem removeCartItemById(String cartItemId) {
//	if (cartItemMap.containsKey(cartItemId)) {
//		CartItem cartItem = cartItemMap.remove(cartItemId);
//		cartItemList.remove(cartItem);
//		return cartItem;
//	}
//	return null;
//  }
//
//  public void incrementQuantityByItemId(String cartItemId) {
//    CartItem cartItem = cartItemMap.get(cartItemId);
//    cartItem.incrementQuantity();
//  }
//
//  public void setQuantityByItemId(String cartItemId, int quantity) {
//    CartItem cartItem = cartItemMap.get(cartItemId);
//    cartItem.setQuantity(quantity);
//  }
//
//  public int getTotalPrice() {
//    int totalPrice = 0;
//	for(CartItem listItem : cartItemList) {
//		totalPrice += listItem.getUnitPrice();
//	}
//    return totalPrice;
//  }
}
