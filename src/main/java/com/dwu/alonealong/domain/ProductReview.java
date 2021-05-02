package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductReview implements Serializable {

  /* Private Fields */
  private String reviewId;
  private String productId;
  private String userId;
  private String date;
  private String contents;
  private int rating;
  private int recommend;
  

  /* JavaBeans Properties */

  public String getReviewId() { return reviewId; }
  public void setReviewId(String reviewId) { this.reviewId = reviewId; }

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }

  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }
  
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }
  
  public String getContents() { return contents; }
  public void setContents(String contents) { this.contents = contents; }
  
  public int getRating() { return rating; }
  public void setRating(int rating) { this.rating = rating; }
  
  public int getRecomment() { return recommend; }
  public void setRecomment(int recommend) { this.recommend = recommend; }
  
  /* Public Methods */

}