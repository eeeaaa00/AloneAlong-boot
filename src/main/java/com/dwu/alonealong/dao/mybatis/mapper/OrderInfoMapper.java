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
	String getRecentOrderId();
	
	void insertTogetherOrderInfo(Order order) throws DataAccessException;
}
