package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.CartItemDAO;
import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.dao.mybatis.mapper.CartItemMapper;

@Repository
public class MybatisCartItemDAO implements CartItemDAO{
	@Autowired
	private CartItemMapper cartItemMapper;
	
	public List<CartItem> getAllCartItem(String userId) throws DataAccessException{
		return cartItemMapper.getAllCartItem(userId);
	}
	public CartItem getCartItem(String cartItemId) throws DataAccessException{
	    return cartItemMapper.getCartItem(cartItemId);
	}

	public void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException{
		//cartItem이 이미 있으면 더하기
		CartItem cartItem = cartItemMapper.isInCart(productId, userId);
		if(cartItem != null) {
			System.out.println(cartItem);
			int newQuantity = cartItem.getQuantity() + quantity;
			cartItem.setQuantity(newQuantity);
			cartItemMapper.updateCartItem(cartItem);
		}
		//없으면 새로추가
		else{
			cartItemMapper.insertCartItem(productId, quantity, userId);
		}
	    return;
	}
	public void deleteCartItem(String cartItemId) throws DataAccessException{
		cartItemMapper.deleteCartItem(cartItemId);
	    return;
	}
	public void deleteAllCartItem(String userId) throws DataAccessException{
		cartItemMapper.deleteAllCartItem(userId);
	    return;
	}
	public void updateCartItem(CartItem cartItem) throws DataAccessException{
		cartItemMapper.updateCartItem(cartItem);
	    return;
	}
	
//	public CartItem getCartItem(String cartItemID) throws DataAccessException{
//	    return cartItemMapper.getCartItem(cartItemID);
//	}
//
//	public void InsertCartItem(CartItem cartItem, String userId)  throws DataAccessException{
//	    return cartItemMapper.InsertCartItem(cartItem, userId);
//	}
//	public void DeleteCartItem(String cartItemID) throws DataAccessException{
//	    return cartItemMapper.DeleteCartItem(cartItemID);
//	}
//
//	public void UpdateQuantity(String cartItemID, int quantity) throws DataAccessException{
//	    return cartItemMapper.UpdateQuantity(cartItemID, quantity);
//	}
}
