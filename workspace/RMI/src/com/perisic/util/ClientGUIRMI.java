package com.perisic.util;


import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.Vector;

import javax.swing.*;

import com.perisic.beds.PrinterInterface;
import com.perisic.beds.rmiinterface.RemoteRecycling;
/**
 * A Simple Graphical User Interface for the client side of the Recycling Machine.
 * @author Marc Conrad
 *
 */
public class ClientGUIRMI extends JFrame implements ActionListener, PrinterInterface {
	// Session cookie isn't set yet
	private static String sessioncookie = "??"; 
	private RemoteRecycling myRecyclingMachine = null; 
	
	// Action Listeners of the buttons of client panel
		/**
		 * ****** ITEMS BUTTON ACTION LISTENER ******
		 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(items)) { 
			try { 
				//Assigns "result" the outcome of the getNumberOfItems method
				int result = myRecyclingMachine.getNumberOfItems(sessioncookie); 
				/**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    * else = show number of items in the machine
				    */
				if( result == -1) { 
					JOptionPane.showMessageDialog(null, "Please login first"); 
				} else { 
					console.setText("There are "+result+" items in the machine.");	 
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
				//Assigns "result" the outcome of the addCan method
				int result = myRecyclingMachine.addCan(sessioncookie); 
				/**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    * else = console set text "Can Inserted"
				    */
				if( result == -1) { 
					JOptionPane.showMessageDialog(null, "Please login first");
				} else { 
					console.setText("Can Inserted.");	
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
				//Assigns "result" the outcome of the addBottle method
				int result = myRecyclingMachine.addBottle(sessioncookie); 
				/**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    * else = console set text "Bottle Inserted"
				    */
				if( result == -1) { 
					JOptionPane.showMessageDialog(null, "Please login first");
				} else { 
					console.setText("Bottle Inserted.");
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
				//Assigns "result" the outcome of the addCrate method
				int result = myRecyclingMachine.addCrate(sessioncookie); 
				/**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    * else = console set text "Crate Inserted"
				    */
				if( result == -1) { 
					JOptionPane.showMessageDialog(null, "Please login first");
				} else { 
					console.setText("Crate Inserted");
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
				//Assigns "result" the outcome of the addPaperBag method
				int result = myRecyclingMachine.addPaperBag(sessioncookie); 
				/**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    * else = console set text "PaperBag Inserted"
				    */
				if( result == -1) { 
					JOptionPane.showMessageDialog(null, "Please login first");
				} else { 
					console.setText("Paperbag Inserted");
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
				//Assigns "result" the outcome of the authClearReceipt method
				//Assigns "result1" the outcome of the executeClearNumberOfItems method
				int result = myRecyclingMachine.authClearReceipt(sessioncookie); 
				int result1 = myRecyclingMachine.executeClearNumberOfItems(sessioncookie); 
				/**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    * else = shows dialog box "Machine Reset"
				    * EXECUTES 2 METHODS THEREFORE I NEEDED 2 RESULT SETS
				    */
				if( result == -1 && result1 == -1) { 
					JOptionPane.showMessageDialog(null, "Please login first");
				} else { 
					JOptionPane.showMessageDialog(null, "Machine Reset");
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
					// Assigns result the string inputed into the message dialog box
					String result = myRecyclingMachine.login(message); 
					/**
					    * This IF statement implements that if the result returns as -1 then 
					    * the user will need to login (which sets the sessioncookie)
					    * else = console sets text "Login successful. You may now use all features."
					    * and the session cookie is set to give the user full access to buttons
					    */
					if(result.equals("wrong")) { 
						System.out.println("Sorry, wrong password"); 
					} else { 
						console.setText("Login successful. You may now use all features."); 
						sessioncookie = result.toString(); 
					}
				} catch (Exception exception) {
					System.err.println("JavaClient: " + exception);
				}
		}
		/**
		 * ****** PRINT RECEIPT BUTTON ACTION LISTENER ******
		 */
		 else if( e.getSource().equals(printReceipt))
		{ 
			 try {   
				//Assigns "result" the outcome of the authPrintReceipt method
				 int result = myRecyclingMachine.authPrintReceipt(sessioncookie); 
				 int result1 = myRecyclingMachine.executeClearNumberOfItems(sessioncookie); 
				 /**
				    * This IF statement implements that if the result returns as -1 then 
				    * the user will need to login (which sets the sessioncookie)
				    */
				 if( result == -1 && result1 == -1) { 
						JOptionPane.showMessageDialog(null, "Please login first"); 
					} else { 
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
	JButton items = new JButton("Items"); 
	JButton login = new JButton("Login"); 
	JButton logout = new JButton("Logout");
	JButton printReceipt = new JButton("Print Receipt"); 
	JButton addCan = new JButton("Add Can"); 
	JButton addBottle = new JButton("Add Bottle"); 
	JButton addCrate = new JButton("Add Crate"); 
	JButton addPaperBag = new JButton("Add Paperbag"); 
	JButton resetMachine = new JButton("Reset Machine"); 
	JTextArea console = new JTextArea(30,30);
	
	//Method that creates and displays the panel
	public ClientGUIRMI() {
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
		ClientGUIRMI myGUI = new ClientGUIRMI(); 
		myGUI.setVisible(true); 
		
		// When run, the client looksup for the registry of the recycling machine
		 try {
			  myGUI.myRecyclingMachine
					= (RemoteRecycling) Naming.lookup("rmi://localhost/RecyclingService1718"); 
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
	}
	public void print(String str) {
		System.out.println(str);
		console.setText(str);
}
	}