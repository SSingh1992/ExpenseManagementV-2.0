package com.epm.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.*;

public class ConnectionManagerDataSource {
	
	Connection connection ;    
    public void closeConnection() throws Exception{
        if (connection != null ){
            connection.close();
        }
    }
	public Connection giveConnection() throws SQLException, NamingException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		if (connection == null){
			System.out.println("in giveConnection() and first connection is null");
			Context initContext = new InitialContext();
	        Context envContext = (Context) initContext.lookup("java:comp/env");
	        DataSource ds = (DataSource) envContext.lookup("jdbc/expenseManagement");
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = ds.getConnection();
		}        
		
		System.out.println("returning connection");		
		return connection;
	}

}

