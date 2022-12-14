package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD,cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
	}
//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}
	public static void changeTitle(DigitalVideoDisc disc, String title) {
		String oldTitle = disc.getTitle();
		disc.setTitle(title);
		disc = new DigitalVideoDisc(oldTitle);
	}
	public static void swap(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		String title1 = disc1.getTitle();
		String title2 = disc2.getTitle();
		disc1.setTitle(title2);
		disc2.setTitle(title1);
	}
	//Java is pass-by-value programming language. 
	//Việc ta làm ở phương thức swap đó là chúng ta cho o1 và o2 trỏ đến vùng nhớ mà jungleDVD và cinderellaDVD trỏ tới
	// và thay đổi giá trị của o1 và o2
	//Việc ta làm ở phương thức changeTitle là chúng ta cho disc trỏ tới vùng nhớ mà jungleDVD trỏ tới, thay đổi giá trị ở vùng nhớ đó
	//nên giá trị của jungleDVD cung bị thay đổi.
	//còn câu lệnh cuối ở phương thức này là chúng ta khiến biến disc trỏ tới vùng nhớ khác chứ không phải jungleDVD
}
