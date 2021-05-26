/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductReview;


@Mapper
public interface ProductReviewMapper {
	//get Method
	ProductReview getProductReview(String reviewId, String userId) throws DataAccessException;
	List<ProductReview> getProductReviewList(String productId, String userId) throws DataAccessException;
	List<ProductReview> getProductReviewListByRecommend(String productId, String userId) throws DataAccessException;
	List<ProductReview> getProductReviewListByLowRating(String productId, String userId) throws DataAccessException;
	List<ProductReview> getProductReviewListByHighRating(String productId, String userId) throws DataAccessException;
	List<ProductReview> getProductReviewListByUserId(String userId) throws DataAccessException;
	
	void insertProductReview(ProductReview productReview)throws DataAccessException;
	void updateProductReview(ProductReview productReview)throws DataAccessException;
	void deleteProductReview(String reviewId)throws DataAccessException;
	
	int numOfReviews(String productId) throws DataAccessException;
	double averageOfReviews(String productId) throws DataAccessException;
	int mostRatingOfReviews(String productId) throws DataAccessException;
	
	void insertProductReviewRecommend(String reviewId, String userId) throws DataAccessException;
	void deleteProductReviewRecommend(String reviewId, String userId) throws DataAccessException;
}
