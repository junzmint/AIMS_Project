package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;  
import java.util.List;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;  
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() < 20) {
			itemsOrdered.add(media);
			if(itemsOrdered.size() == 20) {
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
					);
					System.out.println("The media is removed from the list.");
					return;
				}
			}
		System.out.println("The media is not in the list.");
	}
	

	public float totalCost() {
		float totalCost = 0;
		for(Media mediaAdded : this.itemsOrdered) {
			totalCost += mediaAdded.getCost();
		}
		return totalCost;
	}
	
}