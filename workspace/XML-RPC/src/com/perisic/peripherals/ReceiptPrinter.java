package com.perisic.peripherals;


import com.perisic.beds.PrinterInterface;

/**
 * The interface with the real world printer. 
 * Knows, how to print stuff. 
 * @author James Early - 1506910	
 *
 */
public class ReceiptPrinter implements PrinterInterface {
	/**
	 * @param str
	 */
	public void print(String str) { 
		// add code here to work with a real printer... 
		System.out.println(str);
	}
}
