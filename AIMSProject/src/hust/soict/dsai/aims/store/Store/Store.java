package hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBER_IN_STORE = 10000;
	private List<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsInStore.size() < MAX_NUMBER_IN_STORE) {
			itemsInStore.add(media);
			if(itemsInStore.size() == MAX_NUMBER_IN_STORE) {
				System.out.println("The media is added to the store's list. The store's list is full");
			}
			else {
				System.out.println("The media is added to the store's list.");
			}
		}
		else{
			System.out.println("The store's list is full. Cannot add more.");
		}
	}
	public void removeMedia(Media media) {
		if(itemsInStore.size()==0) {
			System.out.println("The store's list is empty.");
		}
		else {
			for(Media mediaAdded : this.itemsInStore) {
				if(mediaAdded.getTitle().equals(media.getTitle())
					&& mediaAdded.getCategory().equals(media.getCategory())
					&& mediaAdded.getId() == media.getId()
					&& mediaAdded.getCost() == media.getCost()
					) {
					this.itemsInStore.remove(mediaAdded);
					System.out.println("The media is removed from the store's list.");
					return;
				}
				}
		}
		System.out.println("The media is not in the store's list.");
	}
	public StringBuffer viewStoreList() {
		StringBuffer seeStoreList = new StringBuffer();
		for(Media mediaAdded : this.itemsInStore) {
			seeStoreList.append("The DVD's title is " + mediaAdded.getTitle() + ", the category is " + mediaAdded.getCategory() + " and it costs " + mediaAdded.getCost()+"\n");
		}
		return seeStoreList;
	}

    public Media searchStore(String searchItem) {
        for (Media media : itemsInStore) {
            if (media.isMatch(searchItem)) {
                return media;
            }
        }
        return null;
    }

}
