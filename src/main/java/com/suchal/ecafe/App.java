package com.suchal.ecafe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class App 
{
	private List<Item> Items;
	private Scanner sc;
	private List<Order> orders;
	private Queue<Item>[] cooks;
	
	public App() {
		this.cooks = new LinkedList [4];
		
		for(int i = 0; i < 4; i++) {
			this.cooks[i] = new LinkedList<Item>();
		}
		
		this.sc = new Scanner(System.in);
		
		this.orders = new ArrayList<Order>();
		
		Items = new ArrayList<Item>(); 
		Items.add(new Item("Spicy Chicken Wings",10, 1, 10));
		Items.add(new Item("Dumplings",15,  1, 10));
		Items.add(new Item("Chicken Spring Rolls", 12,  1, 5));
		Items.add(new Item("Veg Spring Rolls", 9,  1, 10));
		Items.add(new Item("Hot and Sour", 17,2, 15));
		Items.add(new Item("Sweet Corn", 16, 2, 15));
		Items.add(new Item("Schzewan Noodles",22,  3, 20));
		Items.add(new Item("Mexican Steak", 40,  3, 30));
		Items.add(new Item("Manchurian", 25, 3, 20));
		Items.add(new Item("Egg Friend Rice", 20, 3, 20));
		Items.add(new Item("Supreme Pizza", 45, 3, 20));
		Items.add(new Item("Peporoni Pizza", 45, 3, 20));
		Items.add(new Item("Fries", 5, 4, 5));
		Items.add(new Item("Molten Lava Cake", 10, 4, 5));
		Items.add(new Item("Onion Rings", 5, 4, 5));
		
		
		
	}
	protected int inputOrder() {
		while(true) {
	       try
	        {
	            int num = this.sc.nextInt();
	            if(num >= 0 && num <= this.Items.size()) return num;
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	        	System.out.println("Please enter a valid value");
	            this.sc.nextLine();
	        }
		}
	}
	public void printMenu(Item[] items) {
		
		for(int i = 0; i < items.length; i++) {
			System.out.println((i+1) +"\t" + items[i].getType() + "\t$" + items[i].getPrice() + "\t" + items[i].getName() );
		}
	}
	
	public Order takeOrder() {
		Order order = new Order();
		Item[] items = this.Items.toArray( new Item[this.Items.size()] );
		this.printMenu(items);
        while(true) {
        	
        	System.out.println("To save order, enter 0.");
        	System.out.println("Please select an item to add to order: ");
        	int item_num = this.inputOrder();
        	if(item_num == 0)
        		break;
        	Item item = new Item(items[item_num]);
        	item.orderId = order.id;
        	order.addItem(item);
        }
        this.orders.add(order);
        this.distributeWork(order);
        this.showOrder(order);
        return order;
	}
	
	public void distributeWork(Order order) {

		Item[] items = order.getItems().toArray( new Item[order.getItems().size()] );
		
		for(int j = 0; j < items.length; j++) {
			int minLength = 9999;
			int minIndex = 0;
			for(int i = 0; i < this.cooks.length; i++) {
				int s = this.cooks[i].size();
				if(s < minLength) {
					minLength = s;
					minIndex = i;
				}
			}
			this.cooks[minIndex].add(items[j]);
		}

	}
	
	public void showOrder(Order order) {
		System.out.println("\n\nTHANK YOU FOR PLACING AN ORDER");
		System.out.println("Order number: " + order.id +"\tTotal Items: " + order.getItems().size() + "\tTotal Price: $" + order.getTotalPrice());
		
		Item[] items = order.getItems().toArray( new Item[order.getItems().size()] );
		this.printMenu(items);
		System.out.println("\n\n\n");
	}
    public static void main( String[] args )
    {
        System.out.println( "Welcome to eCafe" );
        App $app = new App();
        while(true) {
        	$app.takeOrder();
        }

        
    }
}
