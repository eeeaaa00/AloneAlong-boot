package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Cart;
import com.dwu.alonealong.domain.CartItem;

public interface CartItemDAO {
	List<CartItem> getAllCartItem(String userId) throws DataAccessException;
	CartItem getCartItem(String cartItemID) throws DataAccessException;

//	int getUnitPrice(String cartItemID) throws DataAccessException;
//	int getTotalPrice(String userId) throws DataAccessException;
	
	void InsertCartItem(CartItem cartItem, String userId)  throws DataAccessException;
	void DeleteCartItem(String cartItemID) throws DataAccessException;
	void UpdateQuantity(String cartItemID, int quantity) throws DataAccessException;
}
