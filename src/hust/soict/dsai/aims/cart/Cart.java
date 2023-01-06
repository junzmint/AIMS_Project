package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;  
import java.util.List;
import hust.soict.dsai.aims.media.Media; 
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	public int getQtyOrdered() {
        return itemsOrdered.size();
    }
	public void addMedia(Media media) {
		if(itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			if(itemsOrdered.size() == MAX_NUMBER_ORDERED) {
				System.out.println("The media is added to the list. The list is full");
			}
			else {
				System.out.println("The media is added to the list.");
			}
		}
		else{
			System.out.println("The list is full. Cannot add more.");
		}
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.size()==0) {
			System.out.println("The list is empty.");
		}
		else {
			for(Media mediaAdded : this.itemsOrdered) {
				if(mediaAdded.getTitle().equals(media.getTitle())
					&& mediaAdded.getCategory().equals(media.getCategory())
					&& mediaAdded.getId() == media.getId()
					&& mediaAdded.getCost() == media.getCost()
					) {
					this.itemsOrdered.remove(mediaAdded);
					System.out.println("The media is removed from the list.");
					return;
					}
				}
			}
		System.out.println("The media is not in the list.");
	}
	public void clearCart() {
        itemsOrdered.clear();
    }

	public float totalCost() {
		float totalCost = 0;
		for(Media mediaAdded : this.itemsOrdered) {
			totalCost += mediaAdded.getCost();
		}
		return totalCost;
	}
	public void sortCartByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortCartByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
    public void viewCart() {
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost:" + totalCost());
    }
    public void searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println(media.toString());
            }
        }
    }
    public Media searchCart(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }
}