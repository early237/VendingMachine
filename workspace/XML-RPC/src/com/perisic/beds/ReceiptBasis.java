package com.perisic.beds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.perisic.peripherals.RecyclingGUI; 

/**
 * This is where the data lives, i.e. cans, bottles and crates are recorded
 * in this class. We might call it our database (if we insist!). 
 * It also provides a summative statement about all the items inserted into the 
 * machine. 
 * @author James Early - 1506910	
 */
public class ReceiptBasis {
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	/**
	 * @param item an item that has been inserted into the machine (such as can, bottle, crate). 
	 */
	public void addItem(DepositItem item) { 
		myItems.add(item); 
		item.number = myItems.indexOf(item) + 1; 
	}
	
	//Method used to add up total weight of each item inserted
	public int computeWeight()
	{
		int totalWeight = 0;
		int weight = 0;
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
			totalWeight += item.weight;
	}
		return totalWeight;
	}
	
	/**
	 * Calculates a summary based on the items inserted.
	 * @return the overall value/weight/sum of the items inserted by the customer.
	 */
	public String computeSum() { 
		// String Receipt is "blank"
		String receipt = "";
		//Declared a list of ints to be used to calculate the sum of the item, value, weight and size.
		int sumValue = 0;
		int sumSize = 0;
		int sumWeight = 0;
		int sumBottle = 0;
		int sumCan = 0;
		int sumPaperBag = 0;
		int sumCrate = 0;
		receipt = receipt + ("****************************** RECEIPT ******************************");
		receipt = receipt + System.getProperty("line.separator");
		
		// For Loop - Each iteration of the loop 
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
				
			// A Switch that counts how many times each item is inserted
			switch(item.getName()){
			case "Bottle":
				sumBottle++;
				break;
			case "Crate":
				sumCrate++;
				break;
			case "Can":
				sumCan++;
				break;
			case "PaperBag":
				sumPaperBag++;
				break;
			}
			/** This adds the item number, value and name to the receipt
			 * 	It also adds the weight and size of each item inserted into the receipt 
			 */
			receipt = receipt + item.getName();
			receipt = receipt + System.getProperty("line.separator");
			receipt = receipt + "No. " + item.number +" Item Value: "+item.value +" Item Weight: "+ item.weight + "kg" + " Item Size: "+item.size +" ";
			receipt = receipt + System.getProperty("line.separator");
			sumValue = sumValue + item.value; 
			sumWeight = sumWeight + item.weight; 
			sumSize = sumSize + item.size;
		}

		/** These add up the sums of all aspects of the item to then be displayed 
		 * 	in the "Totals" section of the receipt.
		 */
		receipt = receipt + "************************** TOTALS ******************************";
		receipt = receipt + System.getProperty("line.separator");
		receipt = receipt + " *** Value: "+ sumValue + " Weight: "+ sumWeight + " Size: " + sumSize + " ***";
		receipt = receipt + System.getProperty("line.separator");
		receipt = receipt + "*** Bottles = " + sumBottle + " Cans = " + sumCan + " Crates = " + sumCrate + " Paper Bags = " + sumPaperBag + "***";
		receipt = receipt + System.getProperty("line.separator");
		receipt = receipt + System.getProperty("line.separator");
		receipt = receipt + System.getProperty("line.separator");
		receipt = receipt + System.getProperty("line.separator");
		return receipt;
	
	}

}
