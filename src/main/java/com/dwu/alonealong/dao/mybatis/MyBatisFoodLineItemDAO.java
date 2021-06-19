package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.FoodDAO;
import com.dwu.alonealong.dao.FoodLineItemDAO;
import com.dwu.alonealong.dao.FoodOrderDAO;
import com.dwu.alonealong.dao.mybatis.mapper.FoodLineItemMapper;
import com.dwu.alonealong.dao.mybatis.mapper.FoodMapper;
import com.dwu.alonealong.dao.mybatis.mapper.FoodOrderMapper;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodLineItem;
import com.dwu.alonealong.domain.FoodOrder;

@Repository
public class MyBatisFoodLineItemDAO implements FoodLineItemDAO{

	@Autowired
	private FoodLineItemMapper foodLineItemMapper;
	
	@Override
	public List<FoodLineItem> getFoodLineItemByOrderId(String orderId) {
		return foodLineItemMapper.getFoodLineItemByOrderId(orderId);
	}

	@Override
	public void insertFoodLineItem(FoodLineItem foodLineItem) {
		foodLineItemMapper.insertFoodLineItem(foodLineItem);		
	}

}
