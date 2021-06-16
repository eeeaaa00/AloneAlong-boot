package com.dwu.alonealong.dao;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.Order;


public interface OrderInfoDAO {
	void insertFoodOrderInfo(FoodOrder order) throws DataAccessException;
	String getRecentOrderId();
	
	void insertTogetherOrderInfo(Order order) throws DataAccessException;
}
