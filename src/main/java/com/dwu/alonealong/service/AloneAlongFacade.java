package com.dwu.alonealong.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.User;


public interface AloneAlongFacade {

	//USER
	User getUser(String Id); //throws DataAccessException;
	User getUser(String Id, String password);
	void createUser(User user);
	void updateUser(User user);
	void removeUser(String Id);
	List<String> getUserIdList();
	  
	//PRODUCT
	List<Product> getProductList(String pcId, String sortType);	
	List<Product> searchProductList(String keywords);
	Product getProduct(String productId);
	List<ProductReview> getReviewsByProductId(String productId, String sortType);
	
	//PRODUCT Review
	int insertProductReview(ProductReview productReview);
	int deleteProductReview(String reviewId);
	int recommendProductReview(String reviewId);
	
	//PRODUCT Order
	List<ProductOrder> getProductOrdersByUserId(String userId);
	List<ProductOrder> getProductOrdersByProductId(String productId);
  	ProductOrder getProductOrder(int orderId);
	int insertProductOrder(ProductOrder order);
	
	//CART
	List<CartItem> getAllCartItem(String userId) throws DataAccessException;
	CartItem getCartItem(String cartItemID) throws DataAccessException;
	void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException;
	void deleteCartItem(String cartItemID) throws DataAccessException;
	void updateQuantity(String cartItemID, int quantity) throws DataAccessException;
	
	//PAYMENT
	Payment getCard(String Id);
	void createCard(Payment payment);
	void updateCard(Payment payment);
	
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