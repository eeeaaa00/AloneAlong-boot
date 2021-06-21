package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class ProductLineItem implements Serializable {
	private String productId;
	private String productName;
	private int quantity;
	private int unitPrice;
	private int price;

	public ProductLineItem() {
		super();
	}
	
	public ProductLineItem(Product product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.quantity = product.getQuantity();
		this.price = product.getProductPrice();
		this.unitPrice = product.getUnitPrice();
	}
	
	public ProductLineItem(CartItem cartItem) {
		this.productId = cartItem.getProductId();
		this.productName = cartItem.getProductName();
		this.quantity = cartItem.getQuantity();
		this.price = cartItem.getPrice();
		this.unitPrice = cartItem.getUnitPrice();
	}
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId = productId; }

	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName = productName; }

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }

	public int getUnitPrice() { return unitPrice; }
	public void setUnitPrice(int unitPrice) { this.unitPrice = unitPrice; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	@Override
	public String toString() {
		return "ProductLineItem [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", price=" + price + "]";
	}
}
