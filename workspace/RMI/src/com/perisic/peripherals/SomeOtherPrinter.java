package com.perisic.peripherals;

import com.perisic.beds.PrinterInterface;

public class SomeOtherPrinter implements PrinterInterface {

	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		System.out.println("++++ The Receipt is ++++\n"+str); 	
		System.out.println("Thank you!"); 
	}

}
