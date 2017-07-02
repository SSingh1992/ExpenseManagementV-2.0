package com.epm.jdbc;

import com.epm.dao.UsersDAO;
import com.epm.dao.impl.UsersDAOImpl;
import java.sql.Connection;

public class ConnectionManagerTest {
	//static UsersDAO udao = new UsersDAOImpl(); 
	/*= new UsersDAOImpl()*/
    public static void main(String args[]){
        try{
            
            ConnectionManagerDataSource cn = new ConnectionManagerDataSource();
            Connection connection = cn.giveConnection();            
            if (connection != null){
                System.out.println("Connection established");
                
            }
            /*if(udao.login(1, "heli")){
    			System.out.println("We got from SQL");
    		}*/
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Wrong");
        }   
    }
}
