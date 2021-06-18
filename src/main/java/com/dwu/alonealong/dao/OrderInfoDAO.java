package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.Order;


public interface OrderInfoDAO {
	void insertFoodOrderInfo(FoodOrder order) throws DataAccessException;
	String getRecentOrderId();

	List<FoodOrder> getOrdersByUserId(String userId) throws DataAccessException;
	
    void insertTogetherOrderInfo(Order order) throws DataAccessException;
    void deleteTogetherOrderInfo(String orderId) throws DataAccessException;
    void updateTogetherOrderInfo(Order order) throws DataAccessException;
}
