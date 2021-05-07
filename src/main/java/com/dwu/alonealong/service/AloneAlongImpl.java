package com.dwu.alonealong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwu.alonealong.dao.UserDAO;
import com.dwu.alonealong.dao.PaymentDAO;
import com.dwu.alonealong.dao.ProductDAO;
import com.dwu.alonealong.dao.ProductOrderDAO;
import com.dwu.alonealong.dao.ProductReviewDAO;
import com.dwu.alonealong.dao.RestaurantDAO;
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
//	@Autowired
//	private RestaurantDAO restaurantDao;
//	@Autowired
//	private UserDAO userDao;
	@Autowired
	private ProductDAO productDao;
//	@Autowired
//	private ProductReviewDAO productReviewDao;
//	@Autowired
//	private ProductOrderDAO productOrderDao;
//	@Autowired
//	private PaymentDAO paymentDao;
	
	private UserDAO userDao;
//	private ProductDAO productDao;
	private ProductReviewDAO productReviewDao;
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
	public List<Product> getProductList(String pcId, String sortType){
		return productDao.getProductList(pcId, sortType);
	}
	public List<Product> searchProductList(String keywords){
		return productDao.searchProductList(keywords);
	}
	public Product getProduct(String productId){
		return productDao.getProduct(productId);
	}
	public List<ProductReview> getReviewsByProductId(String productId, String sortType){
		return productReviewDao.getReviewsByProductId(productId, sortType);
	}
	public int insertProductReview(ProductReview productReview) {
		return productReviewDao.insertProductReview(productReview);
	}
	public int deleteProductReview(String reviewId) {
		return productReviewDao.deleteProductReview(reviewId);
	}
	public int recommendProductReview(String reviewId) {
		return productReviewDao.recommendProductReview(reviewId);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> searchRestaurantList(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurantByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurantByResId(String resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getFoodListByRestaurant(String resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food getFood(String foodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart getFoodCart(String resId) {
		// TODO Auto-generated method stub
		return null;
	}

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

}