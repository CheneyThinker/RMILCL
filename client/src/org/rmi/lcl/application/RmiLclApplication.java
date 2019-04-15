package org.rmi.lcl.application;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.rmi.lcl.entity.RmiLclEntity;
import org.rmi.lcl.stub.RmiLclRemote;

import com.alibaba.fastjson.JSON;

public class RmiLclApplication {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 9527);
			RmiLclRemote rmiLclRemote = (RmiLclRemote) registry.lookup("RmiLclRemote");
			RmiLclEntity rmiLclEntity = new RmiLclEntity();
			rmiLclEntity.setId(1L);
			rmiLclEntity.setFirstName("Cheney");
			rmiLclEntity.setLastName("Thinker");
			rmiLclEntity.setSalary(new Float(9000));
			rmiLclEntity.setAge(27);
			rmiLclEntity.setSex(new Boolean(true));
			System.err.println(rmiLclRemote.saveRmiLclEntity(rmiLclEntity));
			System.err.println(rmiLclRemote.updateRmiLclEntity(rmiLclEntity));
			System.err.println(rmiLclRemote.getRmiLclEntityById(1L));
			System.err.println(JSON.toJSONString(rmiLclRemote.gRmiLclEntities(), true));
			System.err.println(rmiLclRemote.deleteRmiLclEntityById(1L));
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
