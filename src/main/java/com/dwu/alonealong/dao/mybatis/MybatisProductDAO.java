package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.ProductDAO;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.dao.mybatis.mapper.ProductMapper;

@Repository
public class MybatisProductDAO implements ProductDAO{
	@Autowired
	private ProductMapper productMapper;

	//get Product List Method
	//카테고리별 반환
	public List<Product> getProductList(String pcId, String sortType) throws DataAccessException{
	    return productMapper.getProductList(pcId, sortType);
	}
	//검색
	public List<Product> searchProductList(String keyword) throws DataAccessException{
	    return productMapper.searchProductList(keyword);
	}

	//get Product Method
	public Product getProduct(String productId) throws DataAccessException{
	    return productMapper.getProduct(productId);
	}
}
