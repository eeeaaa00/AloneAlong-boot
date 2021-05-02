package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

  /* Private Fields */

  private String productId;
  private String pcId; //productCategoryId
  private String name;
  private String info;
  private String img;
  private String date;
  private String contents;
  private int price;
  private int sales;
  private int stock;
  private int shippingFee;
  private int quantity;
  
  /* JavaBeans Properties */

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId.trim(); }

  public String getPcId() { return pcId; }
  public void setPcId(String pcId) { this.pcId = pcId; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public String getInfo() { return info; }
  public void setInfo(String info) { this.info = info; }
  
  public String getImg() { return img; }
  public void setImg(String img) { this.img = img; }
  
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }
  
  public String getContents() { return contents; }
  public void setContents(String contents) { this.contents = contents; }
  
  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }
  
  public int getSales() { return sales; }
  public void setSales(int sales) { this.sales = sales; }
  
  public int getStock() { return stock; }
  public void setStock(int stock) { this.stock = stock; }
  
  public int getShippingFee() { return shippingFee; }
  public void setShippingFee(int shippingFee) { this.shippingFee = shippingFee; }

  
  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) {	this.quantity = quantity; }

  /*Additional Methods*/
  public boolean isInStock() {
	  if (stock == 0) return true;
	  return false;
  }

  public int getTotalPrice() {
	  int totalPrice = 0;
	  totalPrice += this.quantity * price;
	  if (totalPrice <= 30000) {
		  totalPrice += shippingFee;
	  }
	  return totalPrice;
  }
  /* Public Methods*/
	public String toString() {
    return getName();
  }
}
