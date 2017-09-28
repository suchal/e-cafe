package com.suchal.ecafe;

public class Item {
	private String name;
	private int type;
	private int preparationTime;
	private float price;
	private boolean isComplete;
	public int orderId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
//		return type;
		if(type == 1) return "Appetizers";
		if(type == 2) return "Soups";
		if(type == 3) return "Main Course";
		return "Side Dish";
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public Item(String name, float price, int type, int preparationTime) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.preparationTime = preparationTime;
	}
	public Item(Item item) {
		this.name = item.name;
		this.type = item.type;
		this.price = item.price;
		this.preparationTime = item.preparationTime;
	}
	
}
