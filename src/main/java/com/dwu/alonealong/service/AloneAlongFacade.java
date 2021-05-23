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
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
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
	List<Product> getProductList(int pcId, String sortType);	
	List<Product> searchProductList(String keywords);
	Product getProduct(String productId);
	
	//PRODUCT Review
	ProductReview getProductReview(String reviewId);
	List<ProductReview> getProductReviewList(String productId, String sortType);
	List<ProductReview> getProductReviewListByUserId(String userId);
	void insertProductReview(ProductReview productReview);
	void updateProductReview(ProductReview productReview);
	void deleteProductReview(String reviewId);
	int numOfReviews(String productId);
	double averageOfReviews(String productId);
	int mostRatingOfReviews(String productId);
	
	//PRODUCT Order
	List<ProductOrder> getProductOrdersByUserId(String userId);
	List<ProductOrder> getProductOrdersByProductId(String productId);
  	ProductOrder getProductOrder(int orderId);
	int insertProductOrder(ProductOrder order);
	
	//CART
	List<CartItem> getAllCartItem(String userId) throws DataAccessException;
	CartItem getCartItem(String cartItemId) throws DataAccessException;
	void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException;
	void deleteCartItem(String cartItemId) throws DataAccessException;
	void updateCartItem(CartItem cartItem) throws DataAccessException;
	
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
	void insertRestaurant(Restaurant res);
//
	List<Food> getFoodListByRestaurant(String resId);
// 
	Food getFood(String foodId);
//	FoodCart getFoodCart(String resId);
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
	
	//Together
	Together getTogetherByTogId(String togId);
	List<Together> getTogetherList();
	void insertTogether(Together together);
	
	//TogetherFood
	List<TogetherFood> getTogetherFoodListByTogId(String togId);
	void insertTogetherFood(TogetherFood togetherFood);
	
	//TogetherMember
	List<TogetherMember> getTogetherMemberListByTogId(String togId);
	void insertTogetherMember(TogetherMember togetherMember);
}