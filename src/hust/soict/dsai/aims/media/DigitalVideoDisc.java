package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
