package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.FoodDAO;
import com.dwu.alonealong.dao.FoodOrderDAO;
import com.dwu.alonealong.dao.mybatis.mapper.FoodMapper;
import com.dwu.alonealong.dao.mybatis.mapper.FoodOrderMapper;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodOrder;

@Repository
public class MyBatisFoodOrderDAO implements FoodOrderDAO{
	
	@Autowired
	private FoodOrderMapper foodOrderMapper;
	
	@Override
	public List<FoodOrder> getFoodOrdersByUsername(String username) {
		return foodOrderMapper.getFoodOrdersByUsername(username);
	}

	@Override
	public FoodOrder getFoodOrder(int orderId) {
		return foodOrderMapper.getFoodOrder(orderId);
	}

	@Override
	public void insertFoodOrder(FoodOrder foodOrder, String orderId) {
		foodOrderMapper.insertFoodOrder(foodOrder, orderId);
		
	}

	@Override
	public void insertFoodOrderForTogetherOrder(FoodOrder foodOrder) {
		foodOrderMapper.insertFoodOrderForTogetherOrder(foodOrder);
	}

	
}
