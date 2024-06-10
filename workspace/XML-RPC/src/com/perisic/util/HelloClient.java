package com.perisic.util;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.xmlrpc.*;

/**
 * A simple GUI that tests the connection of the recycling machine using XML-RPC
 * @author James Early - 1506910
 *
 */
public class HelloClient {
	
	public String hello() {
		  return "Connection Working";
	}
 public static void main (String [] args)  {
	 
	 JFrame f = new JFrame("A JFrame");
	    f.setSize(250, 250);
	    f.setLocation(300,200);
	    final JTextArea textArea = new JTextArea(10, 40);
	    f.getContentPane().add(BorderLayout.CENTER, textArea);
	    final JButton button = new JButton("Send");
	    f.getContentPane().add(BorderLayout.SOUTH, button);
	    
	    button.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            textArea.append("Button was clicked\n");

	        }
	    });
	    f.setVisible(true); 
  try {
	  XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); //
	   Object result = server.execute("sample.getNumberOfItems", new Vector() );
	   System.out.println("The result is: "+result.toString()); 
	  } catch (Exception exception) {
	   System.err.println("JavaClient: " + exception);
	   }
  }
}