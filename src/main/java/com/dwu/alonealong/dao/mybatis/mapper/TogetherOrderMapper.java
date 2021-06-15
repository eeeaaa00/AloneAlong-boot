package com.dwu.alonealong.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherOrder;

@Mapper
public interface TogetherOrderMapper {
	void insertTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException;
}
