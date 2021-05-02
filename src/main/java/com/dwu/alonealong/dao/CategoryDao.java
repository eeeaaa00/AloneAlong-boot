package com.dwu.alonealong.dao;

import java.util.List;

import com.dwu.alonealong.domain.Category;

public interface CategoryDao {

	List<Category> getCategoryList(); // throws DataAccessException;

	Category getCategory(String categoryId); // throws DataAccessException;

}
