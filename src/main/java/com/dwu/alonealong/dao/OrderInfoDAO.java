package com.dwu.alonealong.dao;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.FoodOrder;


public interface OrderInfoDAO {
	void insertFoodOrderInfo(FoodOrder order) throws DataAccessException;
	String getRecentOrderId();
}
