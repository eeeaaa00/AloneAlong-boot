package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

  /* Private Fields */

  private String productId;
  private String pcId; //productCategoryId
  private String productName;
  private String productInfo;
  private String productDate;
  private byte[] productImg;
  private byte[] productContents;
  private int productPrice;
  private int productSales;
  private int productStock;
  private int shippingFee;
  private int quantity;
  
  /* JavaBeans Properties */
  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }
  
  public String getPcId() { return pcId; }
  public void setPcId(String pcId) { this.pcId = pcId; }
  
  public String getProductName() { return productName; }
  public void setProductName(String productName) { this.productName = productName; }
  
  public String getProductInfo() { return productInfo; }
  public void setProductInfo(String productInfo) { this.productInfo = productInfo; }
  
  public String getProductDate() { return productDate; }
  public void setProductDate(String productDate) { this.productDate = productDate; }
  
  public byte[] getProductImg() { return productImg; }
  public void setProductImg(byte[] productImg) { this.productImg = productImg; }
  
  public byte[] getProductContents() { return productContents; }
  public void setProductContents(byte[] productContents) { this.productContents = productContents; }
  
  public int getProductPrice() { return productPrice; }
  public void setProductPrice(int productPrice) { this.productPrice = productPrice; }
  
  public int getProductSales() { return productSales; }
  public void setProductSales(int productSales) { this.productSales = productSales; }
  
  public int getProductStock() { return productStock; }
  public void setProductStock(int productStock) { this.productStock = productStock; }
  
  public int getShippingFee() { return shippingFee; }
  public void setShippingFee(int shippingFee) { this.shippingFee = shippingFee; }
  
  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) { this.quantity = quantity; }

  /*Additional Methods*/
  public boolean isInStock() {
	  if (productStock == 0) return true;
	  return false;
  }

public int getUnitPrice() {
	  int unitPrice = 0;
	  unitPrice += quantity * productPrice;
	  if (unitPrice <= 30000) {
		  unitPrice += shippingFee;
	  }
	  return unitPrice;
  }
  
  /* Public Methods*/
	public String toString() {
    return getProductName();
  }
}
