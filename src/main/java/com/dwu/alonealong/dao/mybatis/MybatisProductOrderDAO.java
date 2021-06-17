package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dwu.alonealong.dao.ProductOrderDAO;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.dao.mybatis.mapper.ProductMapper;
import com.dwu.alonealong.dao.mybatis.mapper.ProductOrderMapper;

@Repository
public class MybatisProductOrderDAO implements ProductOrderDAO{
	@Autowired
	private ProductOrderMapper productOrderMapper;
	@Autowired
	private ProductMapper productMapper;

	@Transactional
	public List<ProductOrder> getOrdersByUserId(String userId) throws DataAccessException{
		List<ProductOrder> productOrder = productOrderMapper.getOrdersByUserId(userId);
		for(ProductOrder order : productOrder) {
			order.setLineItems(productOrderMapper.getLineItemsByOrderId(order.getOrderId()));
		}
		return productOrder;
	}
//	List<ProductOrder> getOrdersByProductId(String productId) throws DataAccessException;
	
  	//get ProductOrder Method
  	public ProductOrder getProductOrder(String orderId) throws DataAccessException{
  		return productOrderMapper.getProductOrder(orderId);
  	}
  	
	@Transactional
	public void insertProductOrder(ProductOrder order) throws DataAccessException{
	    productOrderMapper.insertProductOrder(order);
		productMapper.updateProductStock(order.getLineItems());
	}
	
	public boolean checkUsersOrder(String userId, String productId) throws DataAccessException{
		if(productOrderMapper.checkUsersOrder(userId, productId) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
