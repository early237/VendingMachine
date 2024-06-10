package com.perisic.util;

import java.awt.Color;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.*;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */

import org.apache.xmlrpc.XmlRpcClient;

import com.perisic.beds.CustomerPanel;
import com.perisic.beds.PrinterInterface;
import com.perisic.beds.ReceiptBasis;
import com.perisic.peripherals.RecyclingGUI;
/**
 * 
 * This class contains the client side of the XML-RPC application and allows the connection
 * between the client to the server
 * @author James Early - 1506910
 *
 */
public class ClientGUI extends JFrame implements ActionListener, PrinterInterface  {
	
	// Session cookie isn't set yet
	private static String sessioncookie = "??"; 
	// String machineServer is set to a HTTP address (likely to change depending on location of user)
	public String machineServer = "http://192.168.0.14";

	// Action Listeners of the buttons of client panel
	/**
	 * ****** ITEMS BUTTON ACTION LISTENER ******
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(items)) { 
			try { 
				// Creates a new instance of the server
			   XmlRpcClient server = new XmlRpcClient(machineServer); 
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    */
			   Object result = server.execute("sample.getNumberOfItems", args);
			   
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    * else = show number of items in the machine
			    */
			   if( result.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   console.setText("There are "+result.toString()+" items in the machine.");
			   } 
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		}
		/**
		 * ****** RESET MACHINE BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(resetMachine)) { 
			try { 
				// Creates a new instance of the server
				XmlRpcClient server = new XmlRpcClient(machineServer); 
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    *  EXECUTES 2 METHODS THEREFORE I NEEDED 2 RESULT SETS
			    */
			   Object result = server.execute("sample.authClearReceipt", args);
			   Object result1 = server.execute("sample.executeClearNumberOfItems", args);
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    * else = sets console text "Machine Cleared"
			    */
			   if( result.toString().equals("-1") && result1.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   console.setText("Machine Cleared");
			   }    
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		}
		/**
		 * ****** ADD CAN BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(addCan)) { 
			try { 
				// Creates a new instance of the server
				XmlRpcClient server = new XmlRpcClient(machineServer);
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    */
			   Object result = server.execute("sample.addCan", args);
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    * else = sets console text "Can added"
			    */
			   if( result.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   console.setText("Can Added");
			   }  
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		}
		/**
		 * ****** ADD BOTTLE BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(addBottle)) { 
			try { 
				// Creates a new instance of the server
				XmlRpcClient server = new XmlRpcClient(machineServer); //
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    */
			   Object result = server.execute("sample.addBottle", args);
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    * else = sets console text "bottle added"
			    */
			   if( result.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   console.setText("Bottle Added");
			   }  
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
			 
		
		}
		/**
		 * ****** ADD CRATE BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(addCrate)) { 
			try { 
				// Creates a new instance of the server
				XmlRpcClient server = new XmlRpcClient(machineServer); 
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    */
			   Object result = server.execute("sample.addCrate", args);
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    * else = sets console text "crate added"
			    */
			   if( result.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   console.setText("Crate Added");
			   } 
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		}
		/**
		 * ****** ADD PAPERBAG BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(addPaperBag)) { 
			try { 
				// Creates a new instance of the server
				XmlRpcClient server = new XmlRpcClient(machineServer);
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    */
			   Object result = server.execute("sample.addPaperBag", args);
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    * else = sets console text "paperbag added"
			    */
			   if( result.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   console.setText("Paperbag Added");
			   }  
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		}
		/**
		 * ****** PRINTS RECEIPT BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(printReceipt)) { 
			try { 
				// Creates a new instance of the server
				XmlRpcClient server = new XmlRpcClient(machineServer); 
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   /**
			    *  Creates and object called "result" then executes the method 
			    *  from the Customer Panel class to set as the result
			    *  EXECUTES 2 METHODS THEREFORE I NEEDED 2 RESULT SETS
			    */
			   Object result = server.execute("sample.authPrintReceipt", args);
			   Object result1 = server.execute("sample.executeClearNumberOfItems", args);
			   /**
			    * This IF statement implements that if the result returns as -1 then 
			    * the user will need to login (which sets the sessioncookie)
			    */
			   if( result.toString().equals("-1") && result1.toString().equals("-1")) { 
				   JOptionPane.showMessageDialog(null, "Please login first");
			   } else { 
				   
			   }  
 
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		}
		/**
		 * ****** LOGIN BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(login)){ 
			String message = JOptionPane.showInputDialog("Please enter your password"); 
				try {   
					// Creates a new instance of the server
					XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); //
					Vector args  = new Vector(); 
					args.addElement(message); 
						/**
					    *  Creates and object called "result" then executes the method 
					    *  from the Customer Panel class to set as the result
					    */
					Object result = server.execute("sample.login", args );
					 /**
					    * This IF statement implements that if the result returns as -1 then 
					    * the user will need to login (which sets the sessioncookie)
					    * else = sets session cookie which will allow the user to use all buttons
					    */
					if(result.equals("wrong")) { 
						 JOptionPane.showMessageDialog(null, "Wrong password!");
					} else { 
						 JOptionPane.showMessageDialog(null, "You can now use all admin features"); 
						sessioncookie = result.toString(); 
					}
					

				} catch (Exception exception) {
					System.err.println("JavaClient: " + exception);
				}

		} 
	}
	
	
	/**
	 * ****** GUI COMPONENTS ******
	 */

	// Creates the Buttons and Labels for the client panel
	JLabel lHeader = new JLabel("Welcome to Recycling Machine: ");
	JLabel lIP = new JLabel();
	JButton items = new JButton("Items"); 
	JButton login = new JButton("Login"); 
	JButton logout = new JButton("Logout"); 
	JButton addCan = new JButton("Add Can"); 
	JButton addBottle = new JButton("Add Bottle"); 
	JButton addCrate = new JButton("Add Crate"); 
	JButton addPaperBag = new JButton("Add Paperbag"); 
	JButton resetMachine = new JButton("Reset Machine"); 
	JButton printReceipt = new JButton("Print Receipt");
	
	// Creates the textArea 
	public static JTextArea console = new JTextArea(30,30);
	
	//Method that creates and displays the panel
	public ClientGUI() {
		super();
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.setBackground(Color.RED);
		
		// Add the buttons to panel
		panel.add(items); 
		panel.add(login);
		panel.add(logout); 
		panel.add(printReceipt); 
		panel.add(console); 
		panel.add(addCan);
		panel.add(addBottle); 
		panel.add(addCrate); 
		panel.add(addPaperBag); 
		panel.add(resetMachine); 
		
		// Action Listeners 
		items.addActionListener(this);
		login.addActionListener(this);
		logout.addActionListener(this); 
		addCan.addActionListener(this); 
		addBottle.addActionListener(this);
		addCrate.addActionListener(this); 
		addPaperBag.addActionListener(this); 
		resetMachine.addActionListener(this); 
		printReceipt.addActionListener(this); 
		
		// Gets content pane and repaints the panel
		getContentPane().add(panel);
		panel.repaint();
		
		// This Action Listener logs the user out and resets the session cookie by randomly giving it an number
		logout.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	sessioncookie = "Reset"+Math.random(); 
				JOptionPane.showMessageDialog(null, "You are now logged out, bye bye!");
				Window w = SwingUtilities.getWindowAncestor(panel);
				w.setVisible(false);   
				}    
		});	
	}

	// Main Method that creates a new instance of the client GUI
	public static void main(String [] args ) { 
		ClientGUI myGUI = new ClientGUI(); 
		myGUI.setVisible(true); 

	}

	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		
	}
}
