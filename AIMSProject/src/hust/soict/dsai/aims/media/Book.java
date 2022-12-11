package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {		
		super();
	}

	public void addAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			System.out.println("The author is already in the list.");
		}
		else {
			this.authors.add(authorName);
			System.out.println("The author is added to the list.");
		}
	}
	public void removeAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			this.authors.remove(authorName);
			System.out.println("The author is removed from the list.");
		}
		else {
			System.out.println("The author is not in the list.");
		}
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
