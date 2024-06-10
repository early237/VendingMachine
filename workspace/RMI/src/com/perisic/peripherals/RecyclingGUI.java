package com.perisic.peripherals;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import org.apache.xmlrpc.WebServer;

import com.perisic.beds.CustomerPanel;
import com.perisic.beds.DepositItem;
import com.perisic.beds.PrinterInterface;
import com.perisic.beds.ReceiptBasis;
import com.perisic.beds.rmiinterface.RemoteRecycling;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * This class combines three different aspects: 
 * 1) Starting the software
 * 2) Implementing the GUI
 * 3) Handling events
 * @author James Early
 *
 */
public class RecyclingGUI extends JFrame implements ActionListener, PrinterInterface  {
	CustomerPanel myPanel = new CustomerPanel(this);
	//Ints for each item that will show how many of each item is inserted in total
	public int runs = 0;
	public int bag = 0;
	public int can = 0;
	public int crate = 0;
	public int bottle = 0;
	
	private static final long serialVersionUID = -1077856539035586635L;
	
	// An ActionListener for each button that contains multiple embedded IF statements
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * ****** CAN BUTTON ACTION LISTENER ******
		 */
		if( e.getSource().equals(slot1)) {
			//Int variable "can" increased everytime a can is inserted
			can++;
			progressBar.setStringPainted(true);
			//IF statement that increases the progress bar when item inserted
			if (myPanel.calculatePercentage()<= 100) {
				progressBar.setValue((int)myPanel.calculatePercentage());
				
			}else {
				progressBar.setValue(100);
				//this triggers the full machine warning.
				JOptionPane.showInternalMessageDialog(emptyMachine, "Max Weight 2000kg, Please Empty Machine or Print Receipt");	
			}
			output.append("Can Inserted" + System.getProperty("line.separator"));
			System.getProperty("line.separator");
			//Uses the itemReceived method in the Customer Panel class to tell what item is inserted into machine
			myPanel.itemReceived(1);
		} 
		/**
		 * ****** BOTTLE BUTTON ACTION LISTENER ******
		 */
		else if( e.getSource().equals(slot2)) { 
			//Int variable "can" increased everytime a can is inserted
			bottle++;
			progressBar.setStringPainted(true);
			//IF statement that increases the progress bar when item inserted
			if (myPanel.calculatePercentage()<= 100) {
				progressBar.setValue((int)myPanel.calculatePercentage());
			}else {
				progressBar.setValue(100);
				//this triggers the full machine warning.
				JOptionPane.showInternalMessageDialog(emptyMachine, "Max Weight 2000kg, Please Empty Machine or Print Receipt");	
			}
			output.append("Bottle Inserted" + System.getProperty("line.separator"));
			//Uses the itemReceived method in the Customer Panel class to tell what item is inserted into machine
			myPanel.itemReceived(2);
		} 
		/**
		 * ****** CRATE BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(slot3)) { 
			//Int variable "can" increased everytime a can is inserted
			crate++;
			progressBar.setStringPainted(true);
			//IF statement that increases the progress bar when item inserted
			if (myPanel.calculatePercentage()<= 100) {
				progressBar.setValue((int)myPanel.calculatePercentage());
				
			}else {
				progressBar.setValue(100);
				//this triggers the full machine warning.
				JOptionPane.showInternalMessageDialog(emptyMachine, "Max Weight 2000kg, Please Empty Machine or Print Receipt");	
			}
			output.append("Crate Inserted" + System.getProperty("line.separator"));
			//Uses the itemReceived method in the Customer Panel class to tell what item is inserted into machine
			myPanel.itemReceived(3);
		} 
		/**
		 * ****** BAG BUTTON ACTION LISTENER ******
		 */
		else if(e.getSource().equals(slot4)) { 
			//Int variable "can" increased everytime a can is inserted
			 bag++;
			 progressBar.setStringPainted(true);
				//IF statement that increases the progress bar when item inserted
				if (myPanel.calculatePercentage()<= 100) {
					progressBar.setValue((int)myPanel.calculatePercentage());
					
				}else {
					progressBar.setValue(100);
					//this triggers the full machine warning.
					JOptionPane.showInternalMessageDialog(emptyMachine, "Max Weight 2000kg, Please Empty Machine or Print Receipt");
				}
			output.append("Bag Inserted" + System.getProperty("line.separator"));
			//Uses the itemReceived method in the Customer Panel class to tell what item is inserted into machine
			myPanel.itemReceived(4);
		}
		/**
		 * ****** RECEIPT BUTTON ACTION LISTENER ******
		 */
		 else if(e.getSource().equals(receipt)) { 
			//This calls the printReceipt method from the Customer Panel class to print receipt
			myPanel.printReceipt();
			//This calls the nonAuthClearNumberOfItems method from the Customer Panel class to clear number of items
			myPanel.nonAuthClearNumberOfItems();
			//Everytime receipt is printed, the runs int increments by 1
			runs++;
			
			// This exports the current contents of the output textArea into a txt file to be used as "Machine History"
			try (BufferedWriter fileOut = new BufferedWriter(new FileWriter("test.txt", true))) {
				
			    output.write(fileOut);
			    fileOut.write(System.getProperty("line.separator"));
			    fileOut.write(System.getProperty("line.separator"));
			    fileOut.write(System.getProperty("line.separator"));
			}
			catch (IOException ioe) {
			    ioe.printStackTrace();
			}
		} 
	}
	
	
	/**
	 * *************** GUI COMPONENTS **************
	 */
	
	// Creates the buttons for the GUI
	JButton slot1 = new JButton(new ImageIcon("Images\\can.png"));
	JButton slot2 = new JButton(new ImageIcon("Images\\bottle.png")); 
	JButton slot3 = new JButton(new ImageIcon("Images\\crate.png"));
	JButton slot4 = new JButton(new ImageIcon("Images\\bag.png"));
	JButton checkMachineStatus = new JButton(new ImageIcon("Images\\cogs.png"));
	JButton machineHistory = new JButton(new ImageIcon("Images\\book.png"));
	JButton emptyMachine = new JButton(new ImageIcon("Images\\trash.png"));
	JButton receipt = new JButton((new ImageIcon("Images\\tick.png"))); 
	JButton clearLog = new JButton((new ImageIcon("Images\\x.png")));
	JButton checkCurrentWeight = new JButton((new ImageIcon("Images\\scales.png")));
	JButton startServer = new JButton("Start Server"); 
	static JTextArea output = new JTextArea(15, 40);
	
	//Crates the TextArea, ScrollPane and Font
	JScrollPane scrollPane = new JScrollPane(output);
	JProgressBar progressBar = new JProgressBar();
	Font font = new Font("Ariel", Font.PLAIN,12);
	
	// The constructor for the GUI, creates the panel then adds the buttons to the panel.
	public RecyclingGUI() {
		super();
		JFrame frame = new JFrame("James RECYCLING MACHINE");
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		frame.add(panel);
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
		// Adds item buttons to panel
		panel.add(slot1); 
		panel.add(slot2);
		panel.add(slot3);
		panel.add(slot4);
		panel.add(receipt);
		
		// Adds the textarea and rest of features
		panel.add(scrollPane);
		panel.add(clearLog);
		panel.add(checkCurrentWeight);
		panel.add(checkMachineStatus);
		panel.add(machineHistory);
		panel.add(emptyMachine);
		
		// Adds the progress bar
		panel.add(progressBar);
		progressBar.setStringPainted(true);
		
		//Sets font of textArea
		output.setFont(font);

		//The action listeners for the item and receipt buttons
		slot1.addActionListener(this); 
		slot2.addActionListener(this); 
		slot3.addActionListener(this); 
		slot4.addActionListener(this); 
		receipt.addActionListener(this); 
		
		//Sets attributes of textArea
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		output.setBorder(BorderFactory.createCompoundBorder(border, 
		BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		output.setEditable(false);
		
		/**
		 * This method is used for the user inactivity
		 * If user is inactive for 30seconds then clear receipt basis 
		 * to reset machine to default stage
		 */
		Action reset = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "User Inactive, Machine will reset");
				myPanel.executeClearReceiptBasis();
		    	progressBar.setValue(0);
		        output.setText(null);
			}
		};
		InactivityListener listener = new InactivityListener(frame, reset, 1);
		listener.start();
		
		/**
		 * This ActionListener is used to view the machine history
		 * It reads the exported txt file and displays it in the textarea
		 */
		machineHistory.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
		    		
		    		FileReader reader = new FileReader("test.txt");
		            output.read(reader,"test.txt"); //Object of JTextArea
		    }
		    	catch (IOException ex) {
		    	    System.out.println("unkownerror");
		    	}
		    	}
		});
		
		/**
		 * This Action Listener checks the machine status by displaying various stats of the machine
		 * Including the total capacity, number of times each item inserted and a few disclaimers
		 */
		checkMachineStatus.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        output.setText("RUNNING DIAGNOSTICS....." + System.getProperty("line.separator") +"STATUS: RUNNING" +  System.getProperty("line.separator"));
		        output.append("TOTAL CAPACITY OF THIS MACHINE: 2000KG");
		        output.append (System.getProperty("line.separator"));
		        output.append("TOTAL NUMBER OF RUNS: ");
		        output.append(String.valueOf(runs));
		        output.append (System.getProperty("line.separator"));
		        output.append("TOTAL NUMBER OF BOTTLES INSERTED: ");
		        output.append(String.valueOf(bottle));
		        output.append (System.getProperty("line.separator"));
		        output.append("TOTAL NUMBER OF CANS INSERTED: ");
		        output.append(String.valueOf(can));
		        output.append (System.getProperty("line.separator"));
		        output.append("TOTAL NUMBER OF CRATES INSERTED: ");
		        output.append(String.valueOf(crate));
		        output.append (System.getProperty("line.separator"));
		        output.append("TOTAL NUMBER OF PAPER BAGS INSERTED: ");
		        output.append(String.valueOf(bag));
		        output.append (System.getProperty("line.separator"));
		        output.append (System.getProperty("line.separator"));
		        output.append (System.getProperty("line.separator"));
		        output.append("************ CREATED & COPYRIGHTED BY JAMES EARLY© ************");
		        output.append (System.getProperty("line.separator"));
		        output.append("************ UNIVERSITY OF BEDFORDSHIRE ************");
		        output.append (System.getProperty("line.separator"));
		        output.append (System.getProperty("line.separator"));
		   }
		});
		
		/**
		 * This Action Listener checks the current weight against the max weight
		 */
		checkCurrentWeight.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JOptionPane.showMessageDialog(null, "Current Weight: " + myPanel.checkCurrentWeight() + "KG / " + myPanel.calculatePercentage() + "% Full" +(System.getProperty("line.separator")) + "Max Weight: 2000KG");
		    }
		});
		
		/** 
		 * This Action Listener empties the machine.
		 */
		emptyMachine.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JOptionPane.showMessageDialog(null, "Machine Emptied");
		    	myPanel.executeClearReceiptBasis();
		    	myPanel.nonAuthClearNumberOfItems();
		    	progressBar.setValue(0);
		        output.setText(null);
		    }
		});
		
		/**
		 * This Action Listener clears the Machine History log by deleteing all text in the txt file
		 */
		clearLog.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JOptionPane.showMessageDialog(null, "Machine History Log Cleared");
		    	output.setText(null);
		    	try (BufferedWriter fileOut = new BufferedWriter(new FileWriter("test.txt"))) {
					
				    fileOut.write("");  
				}
				catch (IOException ioe) {
				    ioe.printStackTrace();
				}
		    }
		});
		
		// Adds contents pane to panel and repaints it.
		getContentPane().add(panel);
		panel.repaint();
	}
	
	// Main method which runs when the program starts
	public static void main(String [] args )  { 
		// Creates a new instance of the Recycling Machine
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true); 
		
		/**
		 * This creates a new instance of the class RecyclingMachineRMIImplementation
		 * then creates a registry to then be binded with the Recycling Machine.
		 */
		try {	
			output.setText("Server has been started, this Recycling Machine can be connected using RMI");
			output.append (System.getProperty("line.separator"));
			
			RecyclingMachineRMIImplementation recyclingImpl = new RecyclingMachineRMIImplementation();

			recyclingImpl.setCustomerPanel(myGUI.myPanel);

			RemoteRecycling recyclingInterface = recyclingImpl; 

			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("RecyclingService1718",recyclingInterface);

			System.out.println("Starting Service. Welcome to the RMI Recyling Service!");
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	/**
	 * This method outputs the receipt as a string then sets the textArea as that string
	 */
	@Override
	public void print(String str) {
		System.out.println(str);
		output.setText(str);
		progressBar.setStringPainted(true);
		if (myPanel.calculatePercentage()<= 100) {
			progressBar.setValue((int)myPanel.calculatePercentage());
			
		}else {
			progressBar.setValue(100);
		}
		}
}