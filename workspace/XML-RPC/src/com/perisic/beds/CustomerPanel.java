package com.perisic.beds;

/**
 * This is the interface of the system. It represents the interaction from 
 * the customer with the system. 
 * The customer panel knows the recycling machine (i.e. the Deposit Item Receiver class)
 * @author James Early - 1506910
 */

// The receiver is set to null to begin with
public class CustomerPanel {
	DepositItemReceiver receiver = null; 
	
	//sessioncookie for XML-RPC isn't set at this point
	private String sessioncookie = "not set yet"; 
		
	// The constructor initialises the receiver  
	public CustomerPanel(PrinterInterface myPrinter) {
		super(); 
		receiver = new DepositItemReceiver(myPrinter); 
	}
	
	/**
	 * Use Case I - an item has been entered into the system.
	 * @param slot
	 */
	public void itemReceived(int slot) { 
		receiver.classifyItem(slot); 
	}
	/**
	 * Use Case II - a receipt has been requested. 
	 */
	
	//This method calls the clearReceiptBasis method from the receiver class
	public void executeClearReceiptBasis() { 
		receiver.clearReceiptBasis(); 
	}
	
	//Calls the calculateWeightPercentage method from the receiver class then returns a float value
	public float calculatePercentage() {
		return receiver.calculateWeightPercentage();
	}
	
	//Calls the checkWeight method from the receiver class then returns an int value
	public int checkCurrentWeight() {
		return receiver.checkWeight();
	}
	
	//Calls the clearNumbeOfItems method from the receiver class then returns an int value
	public int nonAuthClearNumberOfItems() {
		 return receiver.clearNumberOfItems();
	}
	
	//Method to call the printReceipt method from the receiver class
	public void printReceipt() { 
		receiver.printReceipt();
		}
	
	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call getNumberOfItems method from receiver class.
	 * Then return the result ELSE return -1
	 */
	public int getNumberOfItems(String authenticationcookie ) {
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.getNumberOfItems();
		return result; 
		} else { 
		return -1; 
		}
	}
	
	/**
	 * Compares the sessioncookie with the authentication cookie. 
	 * If statement - IF equal then call clearNumberOfItems method from receiver class.
	 * Then return the result ELSE return -1
	 */
	public int executeClearNumberOfItems(String authenticationcookie ) {
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.clearNumberOfItems();
		return result; 
		} else { 
			return -1; 
		}
	}
	
	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call clearReceiptBasis method from receiver class.
	 * Then return the result ELSE return -1
	 */
	public int authClearReceipt(String authenticationcookie ) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			receiver.clearReceiptBasis(); 
		} else { 
			return -1;
		}
		return -1;
	}
	
	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call classifyItem method from receiver class.
	 * The the argument "1" states what type of item inserted, in this case a Can is inserted
	 * Then return the result ELSE return -1
	 */
	public int addCan(String authenticationcookie ) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.classifyItem(1); 
			return result;
		} else { 
			return -1;
		}
	}
	
	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call classifyItem method from receiver class.
	 * The the argument "2" states what type of item inserted, in this case a Bottle is inserted
	 * Then return the result ELSE return -1
	 */
	public int addBottle(String authenticationcookie ) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.classifyItem(2); 
			return result;
		} else { 
			return -1;
		}
	}
	
	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call classifyItem method from receiver class.
	 * The the argument "3" states what type of item inserted, in this case a Crate is inserted
	 * Then return the result ELSE return -1
	 */
	public int addCrate(String authenticationcookie ) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.classifyItem(3); 
			return result;
		} else { 
			return -1;
		}
	}
	
	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call classifyItem method from receiver class.
	 * The the argument "4" states what type of item inserted, in this case a PaperBag is inserted
	 * Then return the result ELSE return -1
	 */
	public int addPaperBag(String authenticationcookie ) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.classifyItem(4); 
			return result;
		} else { 
			return -1;
		}
	}

	/**
	 * Sets the word "password" as the String password
	 * If statement - IF String password equal to "password" then sets the sessionscookie as random 
	 * Then returns the sessioncookie ELSE returns "Wrong"
	 */
	public String login(String password) { 
		if(password.equals("password")) {
			sessioncookie = "Random"+Math.random(); 
			return sessioncookie; 
		} else { 
			return "wrong"; 
		}
	}

	/**
	 * Compares the session cookie with the authentication cookie. 
	 * If statement - IF equal then call printReceiptt method from receiver class.
	 * Then return the result ELSE return -1
	 */
	public int authPrintReceipt(String authenticationcookie) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.printReceiptXML();
			return result;
		} else { 
			return -1;
		}
	}
	
	// Add something like for Task 2, b: receiver.setPrinter(myPrinter); 
	public void setPrinter(PrinterInterface myPrinter) { 
		
	}
	
}
