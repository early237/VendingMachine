package com.perisic.peripherals;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.perisic.beds.CustomerPanel;
import com.perisic.beds.rmiinterface.RemoteRecycling;


public class RecyclingMachineRMIImplementation extends UnicastRemoteObject implements RemoteRecycling {

	protected RecyclingMachineRMIImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	CustomerPanel myCustomerPanel = null; 
	
	void setCustomerPanel(CustomerPanel myPanel) { 
		myCustomerPanel = myPanel; 
	}

	@Override
	public int getNumberOfItems(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.getNumberOfItems(authenticationCookie); 
	}
	public int addCan(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.addCan(authenticationCookie); 
	}
	public int addBottle(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.addBottle(authenticationCookie); 
	}
	public int addCrate(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.addCrate(authenticationCookie); 
	}
	public int addPaperBag(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.addPaperBag(authenticationCookie); 
	}
	public int authClearReceipt(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.authClearReceipt(authenticationCookie); 
	}
	public int executeClearNumberOfItems(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.executeClearNumberOfItems(authenticationCookie); 
	}
	public int authPrintReceipt(String authenticationCookie) throws RemoteException {
		return myCustomerPanel.authPrintReceipt(authenticationCookie); 
	}

		@Override
	public String login(String password) throws RemoteException {
		return myCustomerPanel.login(password); 
	}

}
