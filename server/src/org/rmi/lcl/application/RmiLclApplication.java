package org.rmi.lcl.application;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.rmi.lcl.stub.RmiLclRemote;
import org.rmi.lcl.stub.impl.RmiLclRemoteImpl;

public class RmiLclApplication {
	
	public static void main(String[] args) {
		try {
			RmiLclRemoteImpl remoteImpl = new RmiLclRemoteImpl();
			RmiLclRemote rmiLclRemote = (RmiLclRemote) UnicastRemoteObject.exportObject(remoteImpl, 9527);
			Registry registry = LocateRegistry.createRegistry(9527);
			registry.rebind("RmiLclRemote", rmiLclRemote);
			System.err.println("RmiLclApplication is running!");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
