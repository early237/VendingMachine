package com.perisic.beds;

import java.util.Random;

/**
 *  This class represents the Create object that can be inserted into the recycle machine.
 * @author James Early - 1506910
 */
//Each item class that can be inserted extends the Deposit Item class 
public class Crate extends DepositItem {
	// This is the constructor for the Create object
	public Crate() {
	Random randomNumber = new Random();
	value = 42; 
	weight = randomNumber.nextInt(200)+ 50;
	size = randomNumber.nextInt(1000)+ 100;
	/**
	 * 
	 * Here i have used the Random package to generate a random int for both the weight
	 * and size of the Create as each Create won't be the same when inserted in theory.
	 * 
	 * The random number generated has a set 
	 * minimum and maximum to make the weight and size more accurate
	 * 
	 */
	 
	}

		
		
		
	}

