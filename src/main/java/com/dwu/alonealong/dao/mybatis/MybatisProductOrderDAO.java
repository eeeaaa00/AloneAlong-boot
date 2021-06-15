package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.ProductOrderDAO;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.dao.mybatis.mapper.ProductOrderMapper;

@Repository
public class MybatisProductOrderDAO implements ProductOrderDAO{
	@Autowired
	private ProductOrderMapper productOrderMapper;

	//get Product Method
	public void insertProductOrder(ProductOrder order) throws DataAccessException{
	    productOrderMapper.insertProductOrder(order);
	}
}
