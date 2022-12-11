package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.test.aims.utils.MediaComparatorByCostTitle;
import hust.soict.dsai.test.aims.utils.MediaComparatorByTitleCost;

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean equals(Media media) {
		if(this.getTitle().equals(media.getTitle())) {
			return true;
		}
		return false;
	}
	@Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.title == ((Media) obj).title;
    }

    public boolean isMatch(String st) {
        if (this.title.equals(st))
            return true;
        return false;
    }
    public abstract void play();
}
