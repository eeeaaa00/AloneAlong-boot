package com.dwu.alonealong.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.dwu.alonealong.domain.Product;

public interface ProductDAO {

	//get Product List Method
	//카테고리별 반환
	List<Product> getProductList(int pcId, String sortType) throws DataAccessException;
	//검색
	List<Product> searchProductList(String keyword) throws DataAccessException;

	//get Product Method
	Product getProduct(String productId) throws DataAccessException;
	
	boolean checkStock(String productId, int quantity) throws DataAccessException;
	
	void updateProduct(Product product) throws DataAccessException;
}