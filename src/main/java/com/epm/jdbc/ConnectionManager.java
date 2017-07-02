package com.epm.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	
	Connection connection ;
    public String dbname;
    public Properties LoadProperties() throws Exception{
        File f = new File("C:\\Users\\Sanket\\Documents\\ExpenseManagement\\ExpenseManagement\\resources\\database.properties");
        if(f.exists()){
            FileInputStream fis = new FileInputStream(f);
            Properties prop = new Properties();
            prop.load(fis);
            return prop;			  
        }
        else {
                throw new RuntimeException("File doesn't exist.");
        }
    }
  
    public Connection getConnection() throws Exception
    {
        if (connection == null){
            Properties properties = LoadProperties();
            if ( properties.getProperty("database").equals("oracle") ){
                String jdbcUrl = properties.getProperty("orcl_jdbcurl");
                String username = properties.getProperty("username").trim();			 
                String password = properties.getProperty("password").trim();
                dbname = "oracle";
                connection = DriverManager.getConnection(jdbcUrl,  username , password);
            }
            else{
                String driverName = properties.getProperty("mysql_driver");
                Class.forName(driverName);
                String jdbcUrl = properties.getProperty("mysql_jdbcurl");
                String username = properties.getProperty("username").trim();			 
                String password = properties.getProperty("password").trim();
                dbname = "mysql";
                connection = DriverManager.getConnection(jdbcUrl,username,password);
            }
        }
        return connection;
    }
    
    public void closeConnection() throws Exception{
        if (connection != null ){
            connection.close();
        }
    }

}
