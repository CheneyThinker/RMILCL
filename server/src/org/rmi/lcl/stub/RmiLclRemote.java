package org.rmi.lcl.stub;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.rmi.lcl.entity.RmiLclEntity;

public interface RmiLclRemote extends Remote {
	
	boolean saveRmiLclEntity(RmiLclEntity rmiLclEntity) throws RemoteException;
	boolean updateRmiLclEntity(RmiLclEntity rmiLclEntity) throws RemoteException;
	boolean deleteRmiLclEntityById(Long id) throws RemoteException;
	RmiLclEntity getRmiLclEntityById(Long id) throws RemoteException;
	List<RmiLclEntity> getRmiLclEntities() throws RemoteException;

}
