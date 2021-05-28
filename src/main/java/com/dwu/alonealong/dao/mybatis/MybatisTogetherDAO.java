package com.dwu.alonealong.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherFoodMapper;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherMapper;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherMemberMapper;
import com.dwu.alonealong.domain.Together;

@Repository
public class MybatisTogetherDAO implements TogetherDAO {
	@Autowired
	private TogetherMapper togetherMapper;
	//추가함
	@Autowired
	private TogetherFoodMapper togetherFoodMapper;
	@Autowired
	private TogetherMemberMapper togetherMemberMapper;
	
	@Override
	public Together getTogetherByTodId(String togId) throws DataAccessException {
		Together together = togetherMapper.getTogetherByTogId(togId);
		String togetherId = together.getTogetherId();
		together.setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togetherId));
		together.setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togetherId));
		
		return together;
	}

	@Override
	public void insertTogether(Together together) throws DataAccessException {
		togetherMapper.insertTogether(together);
	}

	@Override
	public void removeTogether(Together together) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTogether(Together together) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Together> getTogetherList() throws DataAccessException {
		List<Together> togetherList = togetherMapper.getTogetherList();
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		
		return togetherList;
	}

	@Override
	public List<Together> getTogetherListByCategory(String area, /*Date date,*/ String kind, int price, String sex, String age)
			throws DataAccessException {
		switch(area) {
			case "none" : area = ""; break; //변경해야함
			case "seoul" : area = "서울특별시"; break;
			case "busan" : area = "부산광역시"; break;
			case "incheon" : area = "인천광역시"; break;
			case "deagu" : area = "대구광역시"; break;
			case "deageon" : area = "대전광역시"; break;
			case "guangju" : area = "광주광역시"; break;
			case "ulsan" : area = "울산광역시"; break;
		}
		
		switch(kind) {
			case "none" : kind = ""; break; //변경해야함
			case "korean" : kind = "한식"; break;
			case "western" : kind = "양식"; break;
			case "japanese" : kind = "일식"; break;
			case "chinese" : kind = "중식"; break;
			case "etc" : kind = "기타"; break;
		}
		
		switch(sex) {
			case "none" : sex = "상관없음"; break;
			case "female" : sex = "여성"; break;
			case "male" : sex = "남성"; break;
		}
		
		switch(age) {
			case "none" : age = "상관없음"; break;
			case "10" : age = "10대"; break;
			case "20" : age = "20대"; break;
			case "30" : age = "30대"; break;
			case "40" : age = "40대"; break;
			case "50" : age = "50대 이상"; break;
		}
		
		List<Together> togetherList = togetherMapper.getTogetherListByCategory(area, /*Date date,*/ kind, price, sex, age);
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		
		return togetherList;
	}

}
