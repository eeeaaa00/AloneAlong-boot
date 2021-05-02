package com.dwu.alonealong.dao;

import java.util.List;

import com.dwu.alonealong.domain.Restaurant;

public interface RestaurantDAO {
	
	List<Restaurant> getRestaurantListByCategory(String categoryId);
	
	List<Restaurant> searchRestaurantList(String keywords);
	
	Restaurant getRestaurant(String resId);
	
	void insertRestaurant(Restaurant res);
	
	void updateRestaurant(Restaurant res);
	
	void deleteRestaurant(Restaurant res);
	
}
