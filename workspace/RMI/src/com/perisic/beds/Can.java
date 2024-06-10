package com.perisic.beds;
import java.util.Random;

/**
 * This class represents the Can object that can be inserted into the recycle machine.
 * 
 * @author James Early - 1506910
 *
 */
//Each item class that can be inserted extends the Deposit Item class 
public class Can extends DepositItem {
	// This is the constructor for the Can object
	public Can() { 
		Random randomNumber = new Random();
		value = 16;
		weight = randomNumber.nextInt(100)+ 1;
		size = randomNumber.nextInt(30)+ 5;
		/**
		 * 
		 * Here i have used the Random package to generate a random int for both the weight
		 * and size of the Can as each Can won't be the same when inserted in theory.
		
		 * The random number generated has a set 
		 * minimum and maximum to make the weight and size more accurate
		 * 
		 */
	
	}
}
