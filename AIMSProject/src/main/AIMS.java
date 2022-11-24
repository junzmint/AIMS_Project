package main;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
public class AIMS {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("Cart:\n"+ anOrder.seeCart());
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		anOrder.removeDigitalVideoDisc(dvd4);
		System.out.println("Cart:\n"+ anOrder.seeCart());
		System.out.println("Total: "+ anOrder.totalCost());
		DigitalVideoDisc[] newArray = new DigitalVideoDisc[0];
		ArrayList<DigitalVideoDisc> newArrayList = new ArrayList<DigitalVideoDisc>(Arrays.asList(newArray));
		newArrayList.add(dvd1);
		newArrayList.add(dvd4);
		newArrayList.add(dvd3);
		newArrayList.add(dvd2);
		newArray = newArrayList.toArray(newArray);
		anOrder.addDigitalVideoDisc(newArray);
		System.out.println("Cart:\n"+ anOrder.seeCart());
//		while(true) {
//			String option;
//	        option = JOptionPane.showInputDialog(null,"Welcome to AIMS\n"
//	        		+ "Please input your option:\n"
//	        		+ "1. Add items to your cart\n"
//	        		+ "2. Remove items from your cart\n"
//	        		+ "3. See your cart\n"
//	        		+ "4. Total cost\n"
//	        		+ "5. Exit\n","Welcome to the AIMS",JOptionPane.INFORMATION_MESSAGE);
//	        switch(option){
//	        	case "1":
//	        		String titleAdd;
//	        		String categoryAdd;
//	        		String directorAdd;
//	        		int lengthAdd;
//	        		float costAdd;
//	        		titleAdd = JOptionPane.showInputDialog(null,"Please input title: ","Input the title of the DVD to add to cart",JOptionPane.INFORMATION_MESSAGE);
//	        		categoryAdd = JOptionPane.showInputDialog(null,"Please input category: ","Input the category of the DVD to add to cart",JOptionPane.INFORMATION_MESSAGE);
//	        		directorAdd = JOptionPane.showInputDialog(null,"Please input director: ","Input the director of the DVD to add to cart",JOptionPane.INFORMATION_MESSAGE);
//	        		lengthAdd = Integer.parseInt(JOptionPane.showInputDialog(null,"Please input length: ","Input the length of the DVD to add to cart",JOptionPane.INFORMATION_MESSAGE));
//	        		costAdd = Float.parseFloat(JOptionPane.showInputDialog(null,"Please input cost: ","Input the cost of the DVD to add to cart",JOptionPane.INFORMATION_MESSAGE));
//	        		DigitalVideoDisc dvdAdd = new DigitalVideoDisc(titleAdd,categoryAdd,directorAdd,lengthAdd,costAdd);
//	        		JOptionPane.showMessageDialog(null,anOrder.addDigitalVideoDisc(dvdAdd));
//	        		break;
//	        	case "2":
//	        		String titleRemove;
//	        		String categoryRemove;
//	        		String directorRemove;
//	        		int lengthRemove;
//	        		float costRemove;
//	        		titleRemove = JOptionPane.showInputDialog(null,"Please input title: ","Input the title of the DVD to remove from cart",JOptionPane.INFORMATION_MESSAGE);
//	        		categoryRemove = JOptionPane.showInputDialog(null,"Please input category: ","Input the category of the DVD to remove from cart",JOptionPane.INFORMATION_MESSAGE);
//	        		directorRemove = JOptionPane.showInputDialog(null,"Please input director: ","Input the director of the DVD to remove from cart",JOptionPane.INFORMATION_MESSAGE);
//	        		lengthRemove = Integer.parseInt(JOptionPane.showInputDialog(null,"Please input length: ","Input the length of the DVD to remove from cart",JOptionPane.INFORMATION_MESSAGE));
//	        		costRemove = Float.parseFloat(JOptionPane.showInputDialog(null,"Please input cost: ","Input the cost of the DVD to remove from cart",JOptionPane.INFORMATION_MESSAGE));
//	        		DigitalVideoDisc dvdRemove = new DigitalVideoDisc(titleRemove,categoryRemove,directorRemove,lengthRemove,costRemove);
//	        		JOptionPane.showMessageDialog(null,anOrder.removeDigitalVideoDisc(dvdRemove));
//	        		break;
//	        	case "3":
//	        		JOptionPane.showMessageDialog(null,"Your cart\n" + anOrder.seeCart());
//	        		break;
//	        	case "4":
//	        		JOptionPane.showMessageDialog(null,"Total: " + anOrder.totalCost());
//	        		break;
//	        	case "5":
//	        		JOptionPane.showMessageDialog(null, "Goodbye");
//	        		System.exit(0);
//	        		break;
//	        	default:
//	        		JOptionPane.showMessageDialog(null, "Option is Invalid. Please type again");
//	        		break;
//	        }
//		}
	}

}
