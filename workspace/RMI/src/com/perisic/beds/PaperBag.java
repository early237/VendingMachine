package com.perisic.beds;
import java.util.Random;

/**
 *  This class represents the Paper Bag object that can be inserted into the recycle machine.
 * 
 * @author James Early - 1506910
 *
 */
//Each item class that can be inserted extends the Deposit Item class 
public class PaperBag extends DepositItem {
	// This is the constructor for the Paper Bag object
	public PaperBag() { 
		Random randomNumber = new Random();
		value = 3; 
		weight = randomNumber.nextInt(100)+ 1;
		size = randomNumber.nextInt(30) + 5;
	/**
	 * 
	 * Here i have used the Random package to generate a random int for both the weight
	 * and size of the Paper Bag as each bottle won't be the same when inserted in theory.
	 *  
	 * The random number generated has a set 
	 * minimum and maximum to make the weight and size more accurate
	 * 
	 */
		
	}
	}

