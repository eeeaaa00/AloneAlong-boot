package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Restaurant;

@Mapper
public interface RestaurantMapper {
	
	List<Restaurant> getRestaurantList() throws DataAccessException;
	List<Restaurant> getRestaurantListByCategory(String categoryId) throws DataAccessException;
	
	List<Restaurant> searchRestaurantList(String keywords) throws DataAccessException;

	Restaurant getRestaurant(String resId) throws DataAccessException;
	
	
	void insertRestaurant(Restaurant res) throws DataAccessException;
	void updateRestaurant(Restaurant res) throws DataAccessException;
	void deleteRestaurant(Restaurant res) throws DataAccessException;
	 
}
