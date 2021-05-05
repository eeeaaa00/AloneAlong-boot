package com.dwu.alonealong.service;

import java.util.List;

import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.domain.Restaurant;


public interface AloneAlongFacade {

	//PRODUCT
	List<Product> getProductList(String pcId, String sortType);	
	List<Product> searchProductList(String keywords);
	Product getProduct(String productId);
	List<ProductReview> getReviewsByProductId(String productId, String sortType);
	void insertProductReview(ProductReview productReview);
	void deleteProductReview(String reviewId);
	
	//Restaurant
	List<Restaurant> getRestaurantList();
	
	List<Restaurant> searchRestaurantList(String keywords);
//
	Restaurant getRestaurantByUserId(String userId);
	Restaurant getRestaurantByResId(String resId);
//
	List<Food> getFoodListByRestaurant(String resId);
//
	Food getFood(String foodId);
	FoodCart getFoodCart(String resId);
	List<FoodReview> getFoodReviewList(String resId);
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