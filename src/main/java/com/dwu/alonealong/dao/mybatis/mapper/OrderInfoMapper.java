package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.Order;

@Mapper
public interface OrderInfoMapper {
	
	void insertFoodOrderInfo(FoodOrder order) throws DataAccessException;
	void deleteFoodOrderInfo(String orderId) throws DataAccessException;
	String getRecentOrderId();
	List<FoodOrder> getOrdersByUserId(String userId) throws DataAccessException;
	
	void insertTogetherOrderInfo(Order order) throws DataAccessException;
	void deleteTogetherOrderInfo(String orderId) throws DataAccessException;
	void updateTogetherOrderInfo(Order order) throws DataAccessException;
}
