package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private int length;
	private String title;
	public int getLength() {
		return length;
	}
	public String getTitle() {
		return title;
	}
	public Track() {
		
	}
	public Track(String title,int length) {
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
