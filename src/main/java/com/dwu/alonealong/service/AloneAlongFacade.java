package com.dwu.alonealong.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Order;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;


public interface AloneAlongFacade {

	//USER
	User getUserByUserId(String Id) throws DataAccessException;
	User getUserByUserIdAndPassword(String Id, String password);
	void createUser(User user);
	void updateUser(User user);
	void removeUser(String Id);
	List<String> getUserIdList();
	  
	//PRODUCT
	List<Product> getProductList(int pcId, String sortType);	
	List<Product> searchProductList(String keywords);
	Product getProduct(String productId);
	boolean checkStock(String productId, int quantity);
	void updateProduct(Product product);
	
	//PRODUCT Review
	ProductReview getProductReview(String reviewId, String userId);
	List<ProductReview> getProductReviewList(String productId, String sortType, String userId);
	List<ProductReview> getProductReviewListByUserId(String userId);
	void insertProductReview(ProductReview productReview);
	void updateProductReview(ProductReview productReview);
	void deleteProductReview(String reviewId);
	int numOfReviews(String productId);
	double averageOfReviews(String productId);
	int mostRatingOfReviews(String productId);
	void insertProductReviewRecommend(String reviewId, String userId);
	void deleteProductReviewRecommend(String reviewId, String userId);
	
	//PRODUCT Order
	List<ProductOrder> getOrdersByUserId(String userId);
//	List<ProductOrder> getOrdersByProductId(String productId);
  	ProductOrder getProductOrder(String orderId);
	void insertProductOrder(ProductOrder order);
	boolean checkUsersOrder(String userId, String productId);
	
	//CART
	List<CartItem> getAllCartItem(String userId) throws DataAccessException;
	CartItem getCartItem(String cartItemId) throws DataAccessException;
	void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException;
	void deleteCartItem(String cartItemId) throws DataAccessException;
	void deleteAllCartItem(String userId) throws DataAccessException;
	void updateCartItem(CartItem cartItem) throws DataAccessException;
	
	//PAYMENT
	Payment getCard(String Id) throws DataAccessException;
	void createCard(Payment payment);
	void updateCard(Payment payment);
	
	//Restaurant
	void insertRestaurant(Restaurant res);
	void updateRestaurant(Restaurant res);
	void deleteRestaurant(String ownerId);
	List<Restaurant> getRestaurantList();
	List<Restaurant> getRestaurantListByCategory(String category1, String category2, String sortType);
	List<Restaurant> searchRestaurantList(String keywords);
//
	Restaurant getRestaurantByUserId(String userId);
	Restaurant getRestaurantByResId(String resId);
	
	//Food
	void insertFood(Food food);
	void updateFood(Food food);
	void deleteFood(String foodId );
	List<Food> getFoodListByRestaurant(String resId); 
	Food getFood(String foodId);

	void insertFoodOrder(FoodOrder order);
	FoodOrder getFoodOrder(int orderId); //사용x
	List<FoodOrder> getFoodOrdersByUserId(String userId);
	
	public List<FoodReview> getFoodReviewListByResId(String resId, String sortType);
	public void insertFoodReview(FoodReview foodReview);
	void updateAvgRating(int rating, String resId);
	
	//Together
	Together getTogetherByTogId(String togId);
	List<Together> getTogetherList();
	void insertTogether(Together together);
	List<Together> getTogetherListByCategory(String area, String date, String kind, int price, String sex, String age);
	void updateTogether(Together together);
	List<Together> recommandTogetherList(String sex, String address);
	List<Together> getTogetherListByResId(String resId);
	List<Together> searchTogetherList(String keyword);

	
	//TogetherFood
	List<TogetherFood> getTogetherFoodListByTogId(String togId);
	void insertTogetherFood(TogetherFood togetherFood);
	
	//TogetherMember
	List<TogetherMember> getTogetherMemberListByTogId(String togId);
	void insertTogetherMember(TogetherMember togetherMember);
	
	//TogetherOrder 관련
	void insertTogetherOrderInfo(Order order);
	void insertTogetherOrder(TogetherOrder togetherOrder);
	void insertFoodOrderForTogetherOrder(FoodOrder foodOrder);
}