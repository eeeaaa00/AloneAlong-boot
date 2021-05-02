package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.ProductOrder;

public interface ProductOrderDAO {
	//get ProductOrder List Method
	List<ProductOrder> getOrdersByUserId(String userId) throws DataAccessException;
	List<ProductOrder> getOrdersByProductId(String productId) throws DataAccessException;

  	//get ProductOrder Method
  	ProductOrder getProductOrder(int orderId) throws DataAccessException;
  	
  	//주문 추가
	void insertProductOrder(ProductOrder order) throws DataAccessException;
	
	//너무 자잘구리하면 뺄...
	//상품 Id를 통한 주문 횟수 반환
//	int getCountOrdersByProductId(String productId) throws DataAccessException; 

	//해당 상품을 주문한 사용자인지 확인
//	ProductOrder isOrderUser(String userId, String productId) throws DataAccessException;
}

