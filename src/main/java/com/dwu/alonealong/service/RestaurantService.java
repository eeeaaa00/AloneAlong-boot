package com.dwu.alonealong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dwu.alonealong.controller.RestaurantForm;
import com.dwu.alonealong.domain.Restaurant;

@Service
public class RestaurantService { //db랑 impl 쓰기 전에 내부 데이터 저장 확인용
	
	private int nextResId = 0;
	private Map<String, Restaurant> resMap = new HashMap<>();
	
	public RestaurantService() {
		resMap.put("r1", new Restaurant("r1", "누들아한타이", "태국음식", "서울 월곡"));
		resMap.put("r2", new Restaurant("r2", "스시안", "일식", "서울 길음"));
		resMap.put("r3", new Restaurant("r3", "놀부부대찌개", "한식", "서울 강남"));
		nextResId = 4;
	}
	
	public Restaurant getRestaurant(String resId) {
		return resMap.get(resId);
	}
	
	//수정함수 일단 패스
	
	public List<Restaurant> getRestaurantList(){
		return new ArrayList<Restaurant>(resMap.values());
	}
	
	public String insertNewRestaurant(RestaurantForm resForm) {
		Restaurant res = new Restaurant("r" + nextResId, resForm.getResName(),
				resForm.getCategoryId(), resForm.getResAddress());
		nextResId++;
		resMap.put(res.getResId(), res);
		return res.getResId();
	}
	
	//가게정보 userId로 불러오는 함수
	public Restaurant getRestaurantByResId(String resId) {
		for(Restaurant res : resMap.values()) {
			if(res.getResId().equals(resId))
				return res;
		}
		return null;
	}
}
