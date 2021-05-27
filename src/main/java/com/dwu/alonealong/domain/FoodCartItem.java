package com.dwu.alonealong.domain;

public class FoodCartItem {
	private Food food;
	private int quantity;
	
	//
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }	
	
	//
	public int getTotalPrice() {
		if (food != null) {
			return food.getPrice() * quantity;
		}
		else {
			return 0;
		}
	}
	public void incrementQuantity() {
		quantity++;
	}	
	public void decrementQuantity() {
		quantity--;
	}	
}
