package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Restaurant;

public interface RestaurantDAO {
	
	List<Restaurant> getRestaurantListByCategory(String categoryId) throws DataAccessException;
	List<Restaurant> getRestaurantList() throws DataAccessException;
	
	List<Restaurant> searchRestaurantList(String keywords) throws DataAccessException;;
	
	Restaurant getRestaurant(String resId) throws DataAccessException;;
	
	void insertRestaurant(Restaurant res) throws DataAccessException;;
	
	void updateRestaurant(Restaurant res) throws DataAccessException;;
	
	void deleteRestaurant(Restaurant res) throws DataAccessException;;
	 
}
