package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc() {
		super();
	}
	public void addTrack(Track track) {
		for(Track trackAdded : tracks) {
			if(track.getTitle().equals(trackAdded.getTitle()) && track.getLength() == trackAdded.getLength()) {
				System.out.println("The track is already in the list.");
				return;
			}
		}
		this.tracks.add(track);
		System.out.println("The track is added to the list.");
	}
	public void removeTrack(Track track) {
		for(Track trackAdded : tracks) {
			if(track.getTitle().equals(trackAdded.getTitle()) && track.getLength() == trackAdded.getLength()) {
				this.tracks.remove(trackAdded);
				System.out.println("The track is removed from the list.");
				return;
			}
		}
		System.out.println("The track is not in the list.");
	}
	public int getLength() {
		int sumLength = 0;
		for(Track trackAdded : tracks) {
			sumLength += trackAdded.getLength();
		}
		return sumLength;
	}
	public void play() {
		for(Track trackAdded : tracks) {
			trackAdded.play();
		}
	}
}
