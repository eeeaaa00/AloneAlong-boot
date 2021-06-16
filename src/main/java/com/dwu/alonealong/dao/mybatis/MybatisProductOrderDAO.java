package com.dwu.alonealong.dao.mybatis;

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
	public void insertProductOrder(ProductOrder order) throws DataAccessException{
	    productOrderMapper.insertProductOrder(order);
		productMapper.updateProduct(order.getLineItems());
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
