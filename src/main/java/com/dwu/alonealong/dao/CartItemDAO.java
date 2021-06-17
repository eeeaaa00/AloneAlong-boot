package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.CartItem;

public interface CartItemDAO {
	List<CartItem> getAllCartItem(String userId) throws DataAccessException;
	CartItem getCartItem(String cartItemId) throws DataAccessException;

//	int getUnitPrice(String cartItemID) throws DataAccessException;
//	int getTotalPrice(String userId) throws DataAccessException;
	
	void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException;
	void deleteCartItem(String cartItemId) throws DataAccessException;
	void deleteAllCartItem(String userId) throws DataAccessException;
	void updateCartItem(CartItem cartItem) throws DataAccessException;
}
