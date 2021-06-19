package com.dwu.alonealong.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class FoodCart implements Serializable{
	private final Map<String, FoodCartItem> foodMap = Collections.synchronizedMap(new HashMap<String, FoodCartItem>());
	private List<FoodCartItem> foodItemList = new ArrayList<FoodCartItem>();
	
	public FoodCart() {}
	public Iterator<FoodCartItem> getAllFoodCartItems() { return foodItemList.iterator(); }
	
	
	public Map<String, FoodCartItem> getFoodMap() {
		return foodMap;
	}
	public List<FoodCartItem> getFoodItemList() {
		return foodItemList;
	}
	
	public void addFood(Food food) {
		FoodCartItem foodCartItem;
		System.out.println(food.getFoodId());
		if(!containsFoodId(food.getFoodId())) { //카트에 음식정보가 없으면 추가하고
			foodCartItem = new FoodCartItem();
			foodCartItem.setFood(food);
			foodCartItem.setQuantity(1);
			foodMap.put(food.getFoodId(), foodCartItem);
			foodItemList.add(foodCartItem); //리스트 왜있지?
		}else {
			foodCartItem = foodMap.get(food.getFoodId());
		}
		//foodCartItem.incrementQuantity(); //카트 내의 음식 개수 추가
	}
	
	public boolean containsFoodId(String id) {
		return foodMap.containsKey(id);
	}
	public FoodCartItem getFoodCartItem(String foodId) {
		return foodMap.get(foodId);
	}
	
	public Food removeFoodById(String id) {
	    FoodCartItem foodCartItem = foodMap.remove(id);
	    if (foodCartItem == null) {
	      return null;
	    }
		else {
	      foodItemList.remove(foodCartItem);
	      return foodCartItem.getFood(); //이거 받아서 어디다 쓰지
	    }
	 }
	public void incrementQuantityByFoodId(String id) { //카트에서 수량 증가
		FoodCartItem foodCartItem = foodMap.get(id);
		foodCartItem.incrementQuantity();
	}
	public void decrementQuantityByFoodId(String id) { //카트에서 수량 감소
		FoodCartItem foodCartItem = foodMap.get(id);
		foodCartItem.decrementQuantity();
	}
	public int getSubTotal() {
		int subTotal = 0;
		Iterator<FoodCartItem> items = getAllFoodCartItems();
		while(items.hasNext()) {
			FoodCartItem cartItem = items.next();
			Food food = cartItem.getFood();
			int price = food.getPrice();
			int quantity = cartItem.getQuantity();
			subTotal += price * quantity;
		}
		return subTotal;
		
	}
	public void setQuantityByFoodId(String itemId, int quantity) {
		FoodCartItem cartItem = foodMap.get(itemId);
	    cartItem.setQuantity(quantity);
	}
	
	
}
