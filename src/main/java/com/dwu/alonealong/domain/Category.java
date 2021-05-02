package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {

  /* Private Fields */
  private String categoryId;
  private String categoryName;

  /* JavaBeans Properties */

  public String getCategoryId() { return categoryId; }
  public void setCategoryId(String categoryId) { this.categoryId = categoryId.trim(); }

  public String getName() { return categoryName; }
  public void setName(String name) { this.categoryName = categoryName; }

  public String toString() {
    return getCategoryId();
  }
}
