package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.FoodDAO;
import com.dwu.alonealong.dao.FoodOrderDAO;
import com.dwu.alonealong.dao.OrderInfoDAO;
import com.dwu.alonealong.dao.mybatis.mapper.FoodMapper;
import com.dwu.alonealong.dao.mybatis.mapper.FoodOrderMapper;
import com.dwu.alonealong.dao.mybatis.mapper.OrderInfoMapper;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.Order;

@Repository
public class MyBatisOrderInfoDAO implements OrderInfoDAO{
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Override
	public void insertFoodOrderInfo(FoodOrder order) throws DataAccessException {
		orderInfoMapper.insertFoodOrderInfo(order);
	}
	@Override
	public void deleteFoodOrderInfo(String orderId) throws DataAccessException {
		orderInfoMapper.deleteFoodOrderInfo(orderId);
	}

	@Override
	public String getRecentOrderId() {
		return orderInfoMapper.getRecentOrderId();
	}

	@Override
	public List<FoodOrder> getOrdersByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return orderInfoMapper.getOrdersByUserId(userId);
	}
	
	@Override
	public void insertTogetherOrderInfo(Order order) throws DataAccessException {
		orderInfoMapper.insertTogetherOrderInfo(order);
	}

	@Override
	public void deleteTogetherOrderInfo(String orderId) throws DataAccessException {
		orderInfoMapper.deleteTogetherOrderInfo(orderId);
	}

	@Override
	public void updateTogetherOrderInfo(Order order) throws DataAccessException {
		orderInfoMapper.updateTogetherOrderInfo(order);
	}


	
}
