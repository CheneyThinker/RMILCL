package org.rmi.lcl.db;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.rmi.lcl.entity.RmiLclEntity;

public class RmiLclDB {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.exit(0);
		}
	}
	
	public boolean saveRmiLclEntity(RmiLclEntity rmiLclEntity) throws RemoteException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into lcl(firstName, lastName, salary, age, sex) values(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, rmiLclEntity.getFirstName());
			preparedStatement.setString(2, rmiLclEntity.getLastName());
			preparedStatement.setFloat(3, rmiLclEntity.getSalary());
			preparedStatement.setInt(4, rmiLclEntity.getAge());
			preparedStatement.setBoolean(5, rmiLclEntity.getSex());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		} finally {
			release(preparedStatement);
			release(connection);
		}
	}
	
	public boolean updateRmiLclEntity(RmiLclEntity rmiLclEntity) throws RemoteException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update lcl set firstName = ?, lastName = ?, salary = ?, age = ?, sex = ? where id = ?");
			preparedStatement.setString(1, rmiLclEntity.getFirstName());
			preparedStatement.setString(2, rmiLclEntity.getLastName());
			preparedStatement.setFloat(3, rmiLclEntity.getSalary());
			preparedStatement.setInt(4, rmiLclEntity.getAge());
			preparedStatement.setBoolean(5, rmiLclEntity.getSex());
			preparedStatement.setLong(6, rmiLclEntity.getId());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		} finally {
			release(preparedStatement);
			release(connection);
		}
	}
	
	public boolean deleteRmiLclEntityById(Long id) throws RemoteException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from lcl where id = ?");
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		} finally {
			release(preparedStatement);
			release(connection);
		}
	}
	
	public RmiLclEntity getRmiLclEntityById(Long id) throws RemoteException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("select id, firstName, lastName, salary, age, sex from lcl where id = ?");
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			RmiLclEntity rmiLclEntity = new RmiLclEntity();
			while (resultSet.next()) {
				rmiLclEntity.setId(resultSet.getLong("id"));
				rmiLclEntity.setFirstName(resultSet.getString("firstName"));
				rmiLclEntity.setLastName(resultSet.getString("lastName"));
				rmiLclEntity.setSalary(resultSet.getFloat("salary"));
				rmiLclEntity.setAge(resultSet.getInt("age"));
				rmiLclEntity.setSex(resultSet.getBoolean("sex"));
			}
			return rmiLclEntity;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		} finally {
			release(resultSet);
			release(preparedStatement);
			release(connection);
		}
	}
	
	public List<RmiLclEntity> getRmiLclEntities() throws RemoteException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("select id, firstName, lastName, salary, age, sex from lcl");
			resultSet = preparedStatement.executeQuery();
			List<RmiLclEntity> rmiLclEntities = new ArrayList<>();
			while (resultSet.next()) {
				RmiLclEntity rmiLclEntity = new RmiLclEntity();
				rmiLclEntity.setId(resultSet.getLong("id"));
				rmiLclEntity.setFirstName(resultSet.getString("firstName"));
				rmiLclEntity.setLastName(resultSet.getString("lastName"));
				rmiLclEntity.setSalary(resultSet.getFloat("salary"));
				rmiLclEntity.setAge(resultSet.getInt("age"));
				rmiLclEntity.setSex(resultSet.getBoolean("sex"));
				rmiLclEntities.add(rmiLclEntity);
			}
			return rmiLclEntities;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		} finally {
			release(resultSet);
			release(preparedStatement);
			release(connection);
		}
	}
	
	public Connection getConnection() throws RemoteException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lcl", "root", "root");
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		}
		return connection;
	}
	
	public void release(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public void release(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public void release(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
		}
	}

}
