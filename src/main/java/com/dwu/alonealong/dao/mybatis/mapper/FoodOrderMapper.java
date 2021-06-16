package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodOrder;

@Mapper
public interface FoodOrderMapper {
	
	List<FoodOrder> getFoodOrdersByUsername(String username);
	FoodOrder getFoodOrder(int orderId);

	void insertFoodOrder(FoodOrder foodOrder, String orderId);
	
	void insertFoodOrderForTogetherOrder(FoodOrder foodOrder); //추가함
}
