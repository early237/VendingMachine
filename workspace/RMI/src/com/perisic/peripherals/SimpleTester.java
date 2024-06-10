package com.perisic.peripherals;
import com.perisic.beds.*;
/**
 *
 * This class tests the recycling machine without the use of the GUI
 * @author James Early - 1506910
 *
 */
public class SimpleTester {
	
	public static void main(String [] args) { 
		
		PrinterInterface myPrinter = new Display(); 
		
		CustomerPanel myPanel = new CustomerPanel(myPrinter); 
		myPanel.itemReceived(1);
		myPanel.itemReceived(1);
		myPanel.itemReceived(3);
		myPanel.itemReceived(2);
		myPanel.itemReceived(3);
		myPanel.itemReceived(4); // this is to test adding a paper bag into slot 4. 
		myPanel.itemReceived(4);
		myPanel.printReceipt();
		
	}
}
