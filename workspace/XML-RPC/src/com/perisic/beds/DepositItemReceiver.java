package com.perisic.beds;
import javax.swing.JOptionPane;

/** 
 * This class represents the overall system. 
 * @author James Early - 1506910	
 */
	//Class DepositItemReceiver
	public class DepositItemReceiver {
	//Sets theReceiptBasis = null
	ReceiptBasis theReceiptBasis = null; 
	//Int Counter is set to 0
	private int counter = 0; 
	
	/**
	 * The deposit item receiver is constructed with the output device (i.e. the printer)
	 * @param printer
	 */
	
	// Constructor that initialises the printer
	public DepositItemReceiver(PrinterInterface printer) {
		super();
		this.printer = printer;
	}
	
	//PrinterInterface is set to Null
	PrinterInterface printer = null; 
	/**
	 * This method creates a receipt basis for the items inserted
	 */
	public void createReceiptBasis() { 
		theReceiptBasis = new ReceiptBasis(); 
	}
	
	//Method that clears the receiptBasis by setting it to null
	public void clearReceiptBasis() { 
		theReceiptBasis = null;
	}
	
	//This method returns the weight from the method computeWeight from the ReceiptBasis class
	public int checkWeight()
	{
		int weight = 0;
		try{
			weight = theReceiptBasis.computeWeight();
		}
		catch(Exception e)
		{
		}
		return weight;
	}
	
	//This method returns the percentage used for the progress bar.
	public float calculateWeightPercentage()
	{
		float percentage;
		int weight = 0;
		int maxWeight = 2000;
		try{
			weight = theReceiptBasis.computeWeight();
		}
		catch(Exception e)
		{
			
		}
		percentage = (weight*100/maxWeight);
		return percentage;
	}
	
	/**
	 * The method contains an if statement that creates new items to be deposited into slots 
	 * @return 
	 */
	public int classifyItem(int slot) { 
		DepositItem item = null; 
		if( slot == 1 ) { 
			item = new Can(); 
		} else if( slot == 2 ) { 
			item = new Bottle(); 
		} else if ( slot == 3 ) { 
			item = new Crate(); 
		} else if (slot == 4) { 
			item = new PaperBag(); 
		}
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item);  
		return counter = counter + 1; 
	}
	/**
	 * This method computes the receipt then prints it
	 * I have also wrapped this method in a try/catch statement to fix the bug when
	 * clicking on the receipt button twice
	 */
	public void printReceipt() { 
		try{
		String str = theReceiptBasis.computeSum(); 
		printer.print(str); 
		theReceiptBasis = null; 
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "There is nothing in the machine");
		}
	}
	
	//This method is the same as above however returns an int instead 
	//(Used as XML-RPC cannot return strings)
	public int printReceiptXML() { 
		try{
		String str = theReceiptBasis.computeSum(); 
		printer.print(str); 
		theReceiptBasis = null; 
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "There is nothing in the machine");
		}
		return 0;
	}
	
	//Method used to get the number of items inserted into machine. It it returns the counter int 
	int getNumberOfItems() {
		// TODO Auto-generated method stub
		return counter;
	}
	
	//Method used to clear number of items into machine. It sets counter as 0 and returns it
	int clearNumberOfItems() {
		return counter = 0;
	}
}
