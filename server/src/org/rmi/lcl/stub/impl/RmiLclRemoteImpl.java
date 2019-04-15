package org.rmi.lcl.stub.impl;

import java.rmi.RemoteException;
import java.util.List;

import org.rmi.lcl.db.RmiLclDB;
import org.rmi.lcl.entity.RmiLclEntity;
import org.rmi.lcl.stub.RmiLclRemote;

public class RmiLclRemoteImpl implements RmiLclRemote {
	
	private RmiLclDB rmiLclDB;
	
	public RmiLclRemoteImpl() {
		rmiLclDB = new RmiLclDB();
	}
	
	public boolean saveRmiLclEntity(RmiLclEntity rmiLclEntity) throws RemoteException {
		return rmiLclDB.saveRmiLclEntity(rmiLclEntity);
	}
	
	public boolean updateRmiLclEntity(RmiLclEntity rmiLclEntity) throws RemoteException {
		return rmiLclDB.updateRmiLclEntity(rmiLclEntity);
	}
	
	public boolean deleteRmiLclEntityById(Long id) throws RemoteException {
		return rmiLclDB.deleteRmiLclEntityById(id);
	}
	
	public RmiLclEntity getRmiLclEntityById(Long id) throws RemoteException {
		return rmiLclDB.getRmiLclEntityById(id);
	}
	
	public List<RmiLclEntity> getRmiLclEntities() throws RemoteException {
		return rmiLclDB.getRmiLclEntities();
	}

}
