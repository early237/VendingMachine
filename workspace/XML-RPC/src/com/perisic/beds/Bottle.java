package com.perisic.beds;
import java.util.Random;

/**
 * 
 * This class represents the bottle object that can be inserted into the recycle machine.
 * @author James Early - 1506910
 *
 */
// Each item class that can be inserted extends the Deposit Item class 
public class Bottle extends DepositItem {
	// This is the constructor for the Bottle object
	public Bottle() { 
		Random randomNumber = new Random();
		value = 18;
		weight = randomNumber.nextInt(100)+ 1;
		size = randomNumber.nextInt(15)+ 5;
		/**
		 * 
		 * Here i have used the Random package to generate a random int for both the weight
		 * and size of the bottle as each bottle won't be the same when inserted in theory.
 
		 * The random number generated has a set 
		 * minimum and maximum to make the weight and size more accurate
		 * 
		 */
		
			
		
	}
}
