package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dwu.alonealong.dao.ProductReviewDAO;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.dao.mybatis.mapper.ProductReviewMapper;

@Repository
public class MybatisProductReviewDAO implements ProductReviewDAO{
	@Autowired
	private ProductReviewMapper productReviewMapper;

	//get Product List Method
	public ProductReview getProductReview(String reviewId, String userId) throws DataAccessException{
		return productReviewMapper.getProductReview(reviewId, userId);
	}
	
	//get ProductReview List Method
	public List<ProductReview> getProductReviewList(String productId, String sortType, String userId) throws DataAccessException{
		switch(sortType) {
			case "new" : return productReviewMapper.getProductReviewList(productId, userId);
			case "recommend" : return productReviewMapper.getProductReviewListByRecommend(productId, userId);
			case "lowRating" : return productReviewMapper.getProductReviewListByLowRating(productId, userId);
			case "highRating" : return productReviewMapper.getProductReviewListByHighRating(productId, userId);
			
		}
	    return productReviewMapper.getProductReviewList(productId, userId);
	}
	public List<ProductReview> getProductReviewListByUserId(String userId) throws DataAccessException{
		return productReviewMapper.getProductReviewListByUserId(userId);
	}
	
	public void insertProductReview(ProductReview productReview) throws DataAccessException{
		productReviewMapper.insertProductReview(productReview);
		return;
	}
	public void updateProductReview(ProductReview productReview) throws DataAccessException{
		productReviewMapper.updateProductReview(productReview);
		return;
	}
	
	@Transactional
	public void deleteProductReview(String reviewId) throws DataAccessException{
		productReviewMapper.deleteProductReviewRecommendByReviewId(reviewId);
		productReviewMapper.deleteProductReview(reviewId);
		return;
	}
	
	public int numOfReviews(String productId) throws DataAccessException{
		return productReviewMapper.numOfReviews(productId);
	}
	public double averageOfReviews(String productId) throws DataAccessException{
		return productReviewMapper.averageOfReviews(productId);
	}
	public int mostRatingOfReviews(String productId) throws DataAccessException{
		return productReviewMapper.mostRatingOfReviews(productId);
	}

	public void insertProductReviewRecommend(String reviewId, String userId){
		productReviewMapper.insertProductReviewRecommend(reviewId, userId);
		return;
	}
	public void deleteProductReviewRecommend(String reviewId, String userId){
		productReviewMapper.deleteProductReviewRecommend(reviewId, userId);
		return;
	}
}
