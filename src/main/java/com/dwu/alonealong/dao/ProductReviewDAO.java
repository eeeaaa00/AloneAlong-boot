package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.dwu.alonealong.domain.ProductReview;

public interface ProductReviewDAO {
	//get ProductReview Method
	ProductReview getProductReview(String reviewId, String userId) throws DataAccessException;
	
	//get ProductReview List Method
	List<ProductReview> getProductReviewList(String productId, String sortType, String userId) throws DataAccessException;
	List<ProductReview> getProductReviewListByUserId(String userId) throws DataAccessException;
		
	void insertProductReview(ProductReview productReview)throws DataAccessException;
	void updateProductReview(ProductReview productReview)throws DataAccessException;
	void deleteProductReview(String reviewId)throws DataAccessException;

	//계산
	int numOfReviews(String productId) throws DataAccessException;
	double averageOfReviews(String productId) throws DataAccessException;
	int mostRatingOfReviews(String productId) throws DataAccessException;
	
	//추천
	void insertProductReviewRecommend(String reviewId, String userId) throws DataAccessException;
	void deleteProductReviewRecommend(String reviewId, String userId) throws DataAccessException;
}
