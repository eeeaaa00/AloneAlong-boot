package com.dwu.alonealong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwu.alonealong.dao.ProductDAO;
import com.dwu.alonealong.dao.ProductReviewDAO;
import com.dwu.alonealong.dao.RestaurantDAO;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.domain.Restaurant;

@Service
@Transactional
public class AloneAlongImpl implements AloneAlongFacade{

	@Autowired
	private RestaurantDAO restaurantDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private ProductReviewDAO productReviewDao;

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
	public void insertProductReview(ProductReview productReview) {
		productReviewDao.insertProductReview(productReview);
		return;
	}
	public void deleteProductReview(String reviewId) {
		productReviewDao.deleteProductReview(reviewId);
		return;
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