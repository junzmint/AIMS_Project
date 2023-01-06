package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private String director;
	private int length;
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
