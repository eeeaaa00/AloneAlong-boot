package com.dwu.alonealong.service;

import java.util.List;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Restaurant;


public interface AloneAlongFacade {

//	Account getAccount(String username);
//
//	Account getAccount(String username, String password);
//
//	void insertAccount(Account account);
//
//	void updateAccount(Account account);
//
//	List<String> getUsernameList();
//
//
//	List<Category> getCategoryList();
	
//
//	Category getCategory(String categoryId);
//	
//
//	List<Product> getProductListByCategory(String categoryId);
	List<Restaurant> getRestaurantList();
	
//	List<Product> searchProductList(String keywords);
	List<Restaurant> searchRestaurantList(String keywords);
//
//	Product getProduct(String productId);
	Restaurant getRestaurantByUserId(String userId);
	Restaurant getRestaurantByResId(String resId);
//
//
//	List<Item> getItemListByProduct(String productId);
	List<Food> getFoodListByRestaurant(String resId);
//
//	Item getItem(String itemId);
	Food getFood(String foodId);
	FoodCart getFoodCart(String resId);
	List<FoodReview> getFoodReviewList(String resId);
//
//	boolean isItemInStock(String itemId);
//
//
//	void insertOrder(Order order);
	void insertFoodOrder(FoodOrder order);
//
//	Order getOrder(int orderId);
	FoodOrder getFoodOrder(int orderId);
//
//	List<Order> getOrdersByUsername(String username);
	List<FoodOrder> getOrdersByUserId(String userId);

}