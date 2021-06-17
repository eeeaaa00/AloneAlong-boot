package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.ProductOrder;

public interface ProductOrderDAO {
	//get ProductOrder List Method
	List<ProductOrder> getOrdersByUserId(String userId) throws DataAccessException;
//	List<ProductOrder> getOrdersByProductId(String productId) throws DataAccessException;
	
  	//get ProductOrder Method
  	ProductOrder getProductOrder(String orderId) throws DataAccessException;
  	
	void insertProductOrder(ProductOrder order) throws DataAccessException;
	
	boolean checkUsersOrder(String userId, String productId) throws DataAccessException;
}

