package hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBER_IN_STORE = 10000;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBER_IN_STORE];
	private int qtyInStore = 0;
	public String addDVD(DigitalVideoDisc disc) {
		if(qtyInStore == MAX_NUMBER_IN_STORE) {
			return "The store's list is full. You can't add any DVDs now";
		}
		else {
			itemsInStore[qtyInStore] = disc;
			qtyInStore += 1;
			if(qtyInStore == MAX_NUMBER_IN_STORE) {
				return "The disc has been added to the store. The store's list is full.";
			}
			else if(qtyInStore == MAX_NUMBER_IN_STORE - 1) {
				return "The disc has been added to the store. The store's list is almost full.";
			}
			else {
				return "The disc has been added to the store.";
			}
		}
	}
	public String removeDVD(DigitalVideoDisc disc) {
		if(qtyInStore == 0) {
			return "The store's list is empty.";
		}
		else {
			ArrayList<DigitalVideoDisc> itemsOrderedList = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsInStore));  
			for(int i = 0; i < qtyInStore; i++) {
				if(itemsInStore[i].getTitle().equals(disc.getTitle())
						&& itemsInStore[i].getCategory().equals(disc.getCategory())
						&& itemsInStore[i].getDirector().equals(disc.getDirector())
						&& itemsInStore[i].getLength() == disc.getLength()
						&& itemsInStore[i].getCost() == disc.getCost()) {
					itemsOrderedList.remove(i);
					itemsInStore = itemsOrderedList.toArray(itemsInStore);
					qtyInStore -= 1;
					return "The disc has been removed out of the store.";
				}
			}
			if(qtyInStore == 0) {
				return "The store's list now is empty";
			}
			return "The disc hasn't been in the store's list";
		}
	}
	public StringBuffer seeStoreList() {
		StringBuffer seeCart = new StringBuffer();
		for(int i = 0; i < qtyInStore; i++) {
			seeCart.append((i+1) + ". The DVD's title is " + itemsInStore[i].getTitle() + ", the category is " + itemsInStore[i].getCategory() + ", the director is " + itemsInStore[i].getDirector() + ", its length is " +itemsInStore[i].getLength() + " and it costs " +itemsInStore[i].getCost()+"\n");
		}
		return seeCart;
	}
}