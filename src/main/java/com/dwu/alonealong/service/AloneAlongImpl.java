package com.dwu.alonealong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwu.alonealong.dao.UserDAO;
import com.dwu.alonealong.dao.CartItemDAO;
import com.dwu.alonealong.dao.FoodDAO;
import com.dwu.alonealong.dao.PaymentDAO;
import com.dwu.alonealong.dao.ProductDAO;
import com.dwu.alonealong.dao.ProductOrderDAO;
import com.dwu.alonealong.dao.ProductReviewDAO;
import com.dwu.alonealong.dao.RestaurantDAO;
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

@Service
@Transactional
public class AloneAlongImpl implements AloneAlongFacade{

	//Autowired 오류 수정 전까지 주석처리
	@Autowired
	private RestaurantDAO restaurantDao;
	
	@Autowired
	private FoodDAO foodDao;
//	@Autowired
//	private UserDAO userDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private ProductReviewDAO productReviewDao;
//	@Autowired
//	private ProductOrderDAO productOrderDao;
//	@Autowired
//	private PaymentDAO paymentDao;
	@Autowired
	private CartItemDAO cartItemDao;
	
	private UserDAO userDao;
//	private ProductDAO productDao;
//	private ProductReviewDAO productReviewDao;
	private ProductOrderDAO productOrderDao;
	private PaymentDAO paymentDao;

	//User
	public User getUser(String Id) {
		return userDao.getUser(Id);
	}
	public User getUser(String Id, String password) {
		return userDao.getUser(Id, password);
	}
	public void createUser(User user) {
		userDao.createUser(user);
		return;
	}
	public void updateUser(User user) {
		userDao.updateUser(user);
		return;
	}
	public void removeUser(String Id) {
		userDao.removeUser(Id);
		return;
	}
	public List<String> getUserIdList(){
		return userDao.getUserIdList();
	}
	
	//Product
	public List<Product> getProductList(int pcId, String sortType){
		return productDao.getProductList(pcId, sortType);
	}
	public List<Product> searchProductList(String keywords){
		return productDao.searchProductList(keywords);
	}
	public Product getProduct(String productId){
		return productDao.getProduct(productId);
	}
	
	//Product Review
	public ProductReview getProductReview(String reviewId){
		return productReviewDao.getProductReview(reviewId);
	}
	public List<ProductReview> getProductReviewList(String productId, String sortType){
		return productReviewDao.getProductReviewList(productId, sortType);
	}
	public List<ProductReview> getProductReviewListByUserId(String userId){
		return productReviewDao.getProductReviewListByUserId(userId);
	}
	public void insertProductReview(ProductReview productReview) {
		productReviewDao.insertProductReview(productReview);
		return;
	}
	public void updateProductReview(ProductReview productReview) {
		productReviewDao.updateProductReview(productReview);
		return;
	}
	public void deleteProductReview(String reviewId) {
		productReviewDao.deleteProductReview(reviewId);
		return;
	}
	public int numOfReviews(String productId) {
		return productReviewDao.numOfReviews(productId);
	}
	public double averageOfReviews(String productId){
		return productReviewDao.averageOfReviews(productId);
	}
	public int mostRatingOfReviews(String productId){
		return productReviewDao.mostRatingOfReviews(productId);
	}
	
	//PRODUCT Order
	public List<ProductOrder> getProductOrdersByUserId(String userId){
		return productOrderDao.getOrdersByUserId(userId);
	}
	public List<ProductOrder> getProductOrdersByProductId(String productId){
		return productOrderDao.getOrdersByProductId(productId);
	}
	public ProductOrder getProductOrder(int orderId){
		return productOrderDao.getProductOrder(orderId);
	}
	public int insertProductOrder(ProductOrder order){
		return productOrderDao.insertProductOrder(order);
	}
	
	//cart
	public List<CartItem> getAllCartItem(String userId) throws DataAccessException{
		return cartItemDao.getAllCartItem(userId);
	}
	public CartItem getCartItem(String cartItemId) throws DataAccessException{
		return cartItemDao.getCartItem(cartItemId);
	}
	public void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException{
		cartItemDao.insertCartItem(productId, quantity, userId);
		return;
	}
	public void deleteCartItem(String cartItemId) throws DataAccessException{
		cartItemDao.deleteCartItem(cartItemId);
		return;
	}
	public void updateCartItem(CartItem cartItem) throws DataAccessException{
		cartItemDao.updateCartItem(cartItem);
		return;
	}
	
	//Payment
	public Payment getCard(String Id) {
		return paymentDao.getCard(Id);
	}
	public void createCard(Payment payment) {
		paymentDao.createCard(payment);
	}
	public void updateCard(Payment payment) {
		paymentDao.updateCard(payment);
	}
	
	@Override
	public List<Restaurant> getRestaurantList() {
		return restaurantDao.getRestaurantList();
	}

	@Override
	public List<Restaurant> searchRestaurantList(String keywords) {
		return restaurantDao.searchRestaurantList(keywords);
	}

	@Override
	public Restaurant getRestaurantByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurantByResId(String resId) {
		// TODO Auto-generated method stub
		return restaurantDao.getRestaurant(resId);
	}

	@Override
	public List<Food> getFoodListByRestaurant(String resId) {
		return foodDao.getFoodListByResId(resId);
	}

	@Override
	public Food getFood(String foodId) {
		return foodDao.getFood(foodId);
	}

//	@Override
//	public FoodCart getFoodCart(String resId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<FoodReview> getFoodReviewList(String resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFoodOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FoodOrder getFoodOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodOrder> getOrdersByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertRestaurant(Restaurant res) {
		restaurantDao.insertRestaurant(res);
		
	}

}