package com.perisic.util;

import java.net.*;
import java.io.*;

/**
 * This class returns the value of items as well as other attributes using a URL 
 * and displays them in a simple GUI
 * @author James Early - 1506910
 */
public class ItemReader {
	/**
	 * 
	 * @param what one of can, bottle or crate. 
	 * @return the value of this item as found on perisic.com
	 * @throws Exception
	 */
    public static int getValueOf(String what) throws Exception {
        URL prices = new URL("http://www.perisic.com/uob/CIS007-3/prices.php?item="+what);
        BufferedReader in = new BufferedReader( new InputStreamReader(prices.openStream()));
        String inputLine;
        int result = -2; 
        while ((inputLine = in.readLine()) != null) {
        	result = Integer.parseInt(inputLine); 
        	}
        in.close(); 
        return result; 
    }
   
    public static void main(String [] args ) { 
    	try {
			System.out.println("Can = "+getValueOf("can")); 
			System.out.println("Bottle = "+getValueOf("bottle")); 
			System.out.println("Crate = "+getValueOf("crate")); 
		} catch (Exception e) {
			System.out.println("An exception has occured: "+e.toString());
			e.printStackTrace();
		} 
    }  
}