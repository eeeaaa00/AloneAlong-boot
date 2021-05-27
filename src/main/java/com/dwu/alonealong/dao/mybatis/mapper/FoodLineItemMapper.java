package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodLineItem;
import com.dwu.alonealong.domain.FoodOrder;

@Mapper
public interface FoodLineItemMapper {
	
	List<FoodLineItem> getFoodLineItemByOrderId(String orderId);
	void insertFoodLineItem(FoodLineItem foodLineItem);
	
}
