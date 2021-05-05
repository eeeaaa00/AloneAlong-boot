package com.dwu.alonealong.domain;

import java.util.List;

public class ProductLineItem {
	private String productId;
	private int quantity;
	private int unitPrice;
	private List<ProductLineItem> orderList;
	
	public ProductLineItem(String productId, int quantity, int unitPrice){
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public List<ProductLineItem> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ProductLineItem> orderList) {
		this.orderList = orderList;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public ProductLineItem() {
	}
	
	public ProductLineItem(String productId) {
		super();
		this.productId = productId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductLineItem [productId=" + productId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	
}
