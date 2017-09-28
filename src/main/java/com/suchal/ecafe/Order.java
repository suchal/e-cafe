package com.suchal.ecafe;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Item> items;
	private float totalPrice;
	public int id;
	public static int count;
	public Order() {
		super();
		this.id = ++Order.count;
		this.items = new ArrayList<Item>();
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void addItem(Item item) {
		this.items.add(item);
		this.totalPrice += item.getPrice();
	}
	
}
