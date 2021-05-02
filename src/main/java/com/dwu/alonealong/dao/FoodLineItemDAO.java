package com.dwu.alonealong.dao;

import java.util.List;

import com.dwu.alonealong.domain.FoodLineItem;

public interface FoodLineItemDAO {
	
	List<FoodLineItem> getFoodLineItemByOrderId(String orderId);
	void insertFoodLineItem(FoodLineItem foodLineItem);
}
