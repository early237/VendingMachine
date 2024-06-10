package com.perisic.beds;

/**
 * This represents an item that has been inserted into 
 * the recycling machine. 
 * @author James Early - 1506910
 *
 */
public abstract class DepositItem {
	/**
	 * The running number when the item was inserted. 
	 */
	int number; 
	/** 
	 * the value of the item. 
	 */
	int value; 
	/**
	 * the weight of the item
	 */
	int weight;
	/**
	 * the size of the item
	 */
	int size;
	
	
	// String getName is used to return the name of the item for the receipt 
	String getName() { 
		return this.getClass().getSimpleName();   // needs something better. 
	}
}
