package main;
import java.util.ArrayList;  
import java.util.Arrays;  
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;//Count from 0.
	
	public String addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBER_ORDERED) {
			return "The cart is full. You can't add any DVDs now";
		}
		else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			if(qtyOrdered == MAX_NUMBER_ORDERED) {
				return "The disc has been added. The cart is full.";
			}
			else if(qtyOrdered == MAX_NUMBER_ORDERED - 1) {
				return "The disc has been added. The cart is almost full.";
			}
			else {
				return "The disc has been added.";
			}
		}
	}
	public String addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if(qtyOrdered == MAX_NUMBER_ORDERED - 1) {
			return "The cart is full. You can't add any DVDs now";
		}
		else {
			itemsOrdered[qtyOrdered] = disc1;
			qtyOrdered += 1;
			itemsOrdered[qtyOrdered] = disc2;
			qtyOrdered += 1;
			if(qtyOrdered == MAX_NUMBER_ORDERED) {
				return "The disc has been added. The cart is full.";
			}
			else if(qtyOrdered == MAX_NUMBER_ORDERED - 1) {
				return "The disc has been added. The cart is almost full.";
			}
			else {
				return "The disc has been added.";
			}
		}
	}
	public String addDigitalVideoDisc(DigitalVideoDisc[] disc) {
		if(qtyOrdered == MAX_NUMBER_ORDERED) {
			return "The cart is full. You can't add any DVDs now";
		}
		else if(disc.length > MAX_NUMBER_ORDERED - qtyOrdered) {
			return "The list is bigger than the leftover space";
		}
		else {
			for(int i = 0; i <disc.length; i++) {
				itemsOrdered[qtyOrdered] = disc[i];
				qtyOrdered += 1;
			}
			if(qtyOrdered == MAX_NUMBER_ORDERED) {
				return "The disc has been added. The cart is full.";
			}
			else if(qtyOrdered == MAX_NUMBER_ORDERED - 1) {
				return "The disc has been added. The cart is almost full.";
			}
			else {
				return "The disc has been added.";
			}
		}
	}
	public String removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == 0) {
			return "The cart is empty.";
		}
		else {
			ArrayList<DigitalVideoDisc> itemsOrderedList = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));  
			for(int i = 0; i < qtyOrdered; i++) {
				if(itemsOrdered[i].getTitle().equals(disc.getTitle())
						&& itemsOrdered[i].getCategory().equals(disc.getCategory())
						&& itemsOrdered[i].getDirector().equals(disc.getDirector())
						&& itemsOrdered[i].getLength() == disc.getLength()
						&& itemsOrdered[i].getCost() == disc.getCost()) {
					itemsOrderedList.remove(i);
					itemsOrdered = itemsOrderedList.toArray(itemsOrdered);
					qtyOrdered -= 1;
					return "The disc has been removed.";
				}
			}
			if(qtyOrdered == 0) {
				return "The cart now is empty";
			}
			return "The disc hasn't been in the cart";
		}
	}
	public StringBuffer seeCart() {
		StringBuffer seeCart = new StringBuffer();
		for(int i = 0; i < qtyOrdered; i++) {
			seeCart.append((i+1) + ". The DVD's title is " + itemsOrdered[i].getTitle() + ", the category is " + itemsOrdered[i].getCategory() + ", the director is " + itemsOrdered[i].getDirector() + ", its length is " +itemsOrdered[i].getLength() + " and it costs " +itemsOrdered[i].getCost()+"\n");
		}
		return seeCart;
	}
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
}