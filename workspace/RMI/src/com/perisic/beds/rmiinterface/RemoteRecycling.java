package com.perisic.beds.rmiinterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * This class acts as an Interface used to pass the various ints and strings to the methods
 * in the RMIImplementation Class
 * @author James
 *
 */

public interface RemoteRecycling extends Remote {
	public int getNumberOfItems(String authenticationCookie) throws RemoteException;
	public int addCan(String authenticationCookie) throws RemoteException;
	public int addBottle(String authenticationCookie) throws RemoteException;
	public int addCrate(String authenticationCookie) throws RemoteException;
	public int addPaperBag(String authenticationCookie) throws RemoteException;
	public int authClearReceipt(String authenticationCookie) throws RemoteException;
	public int executeClearNumberOfItems(String authenticationCookie) throws RemoteException;
	public int authPrintReceipt(String authenticationCookie) throws RemoteException;
	public String login(String password) throws RemoteException; 
}
