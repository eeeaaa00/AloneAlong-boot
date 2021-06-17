package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Restaurant;

public interface RestaurantDAO {
	
	List<Restaurant> getRestaurantListByCategory(String category1, String category2, String sortType) throws DataAccessException;
	List<Restaurant> getRestaurantList() throws DataAccessException;
	
	List<Restaurant> searchRestaurantList(String keywords) throws DataAccessException;
	
	Restaurant getRestaurant(String resId) throws DataAccessException;
	Restaurant getRestaurantByOwnerId(String ownerId) throws DataAccessException;

	
	void insertRestaurant(Restaurant res) throws DataAccessException;
	void updateRestaurant(Restaurant res) throws DataAccessException;
	void deleteRestaurant(String ownerId) throws DataAccessException;
	
	void updateAvgRating(int rating, String resId) throws DataAccessException;
	 
}
