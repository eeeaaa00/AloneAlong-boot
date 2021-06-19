package com.dwu.alonealong.dao.mybatis;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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
	public void deleteTogether(String togId) throws DataAccessException {
		togetherMapper.deleteTogether(togId);
	}

	@Override
	public void updateTogether(Together together) throws DataAccessException {
		togetherMapper.updateTogether(together);
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
	public List<Together> searchTogetherList(String keyword) throws DataAccessException{
		List<Together> togetherList = togetherMapper.searchTogetherList(keyword);
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		return togetherList;
	}

	@Override
	public List<Together> getTogetherListByCategory(String area, String date, String kind, int price, String sex, String age)
			throws DataAccessException {
		switch(area) {
			case "all" : area = ""; break;
			case "seoul" : area = "서울특별시"; break;
			case "gyenggi" : area = "경기도"; break;
			case "busan" : area = "부산광역시"; break;
			case "incheon" : area = "인천광역시"; break;
			case "deagu" : area = "대구광역시"; break;
			case "deageon" : area = "대전광역시"; break;
			case "guangju" : area = "광주광역시"; break;
			case "ulsan" : area = "울산광역시"; break;
		}
		
		switch(kind) {
			case "all" : kind = ""; break;
			case "korean" : kind = "한식"; break;
			case "western" : kind = "양식"; break;
			case "japanese" : kind = "일식"; break;
			case "chinese" : kind = "중식"; break;
			case "etc" : kind = "기타"; break;
		}
		
		switch(sex) {
			case "all" : sex = ""; break;
			case "female" : sex = "여성"; break;
			case "male" : sex = "남성"; break;
		}
		
		switch(age) {
			case "all" : age = ""; break;
			case "10" : age = "10대"; break;
			case "20" : age = "20대"; break;
			case "30" : age = "30대"; break;
			case "40" : age = "40대"; break;
			case "50" : age = "50대 이상"; break;
		}
		
		List<Together> togetherList = togetherMapper.getTogetherListByCategory(area, date, kind, price, sex, age);
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		
		return togetherList;
	}

	@Override
	public List<Together> recommandTogetherList(String sex, String address) throws DataAccessException {
		StringTokenizer st = new StringTokenizer(address); //주소에서 '서울'만 따기
		String addressTag = st.nextToken();
		
		List<Together> togetherList = togetherMapper.recommandTogetherList(sex, addressTag);
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		
		return togetherList;
	}

	@Override
	public List<Together> getTogetherListByResId(String resId) throws DataAccessException {
		List<Together> togetherList = togetherMapper.getTogetherListByResId(resId);
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		
		return togetherList;
	}

}
