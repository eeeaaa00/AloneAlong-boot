package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProductReview implements Serializable {

  /* Private Fields */
  private String reviewId;
  private String productId;
  private String userId;
  private String nickname;
  private Date reviewDate;
  private String reviewContents;
  private int rating;
  private int recommend;
  private boolean checkRecommend;
  
  public String getReviewId() { return reviewId; }
  public void setReviewId(String reviewId) { this.reviewId = reviewId; }

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }

  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }

  public String getNickname() { return nickname; }
  public void setNickname(String nickname) { this.nickname = nickname; }
  
  public Date getReviewDate() { return reviewDate; }
  public void setReviewDate(Date reviewDate) { this.reviewDate = reviewDate; }
  
  public String getReviewContents() { return reviewContents; }
  public void setReviewContents(String reviewContents) { this.reviewContents = reviewContents; }
  
  public int getRating() { return rating; }
  public void setRating(int rating) { this.rating = rating; }
  
  public int getRecommend() { return recommend; }
  public void setRecommend(int recommend) { this.recommend = recommend; }
  
  public boolean getCheckRecommend() { return checkRecommend; }
  public void setCheckRecommend(boolean checkRecommend) { this.checkRecommend = checkRecommend; }
  
  /* Public Methods */
  public void increaseRecommend() {
	  this.recommend++;
  }
  public void decreaseRecommend() {
	  this.recommend--;
  }

}