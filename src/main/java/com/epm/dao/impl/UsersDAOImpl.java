package com.epm.dao.impl;

import com.epm.dao.Sqls;
import com.epm.dao.UsersDAO;
import com.epm.dto.Users;
import com.epm.jdbc.ConnectionManager;
import com.epm.jdbc.ConnectionManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDAOImpl implements UsersDAO, Sqls{
	public Connection conn;
    public UsersDAOImpl() {
        try {
//            ConnectionManager cm = new ConnectionManager();
        	ConnectionManagerDataSource cm = new ConnectionManagerDataSource();
            conn = cm.giveConnection();
            if (conn != null ){
                System.out.println("Database Connection established properly with the application!!!");
            }
            else
            {
                System.out.println("Something went wrong on Database Connection creation.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //not sure how i can call cm.closeConnection() from here.
            //Basically when error occurs, connection should be called to close..otherwise on db side,it will stay open and if it hits the max limit, you cann't connect to db.
        }
    }
    
	public boolean login(int user_id, String password) {
		// TODO Auto-generated method stub

        // Get the connection --it is already there.
        // Create a Statement -- take user name and password and validate.
        boolean bAuthenticaed = false;
        try {
            System.out.println(LOGINSQL);
            PreparedStatement ps = conn.prepareStatement(LOGINSQL);
            ps.setInt(1,user_id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Application user validated successfully.");
                bAuthenticaed = true;
            } else {
                System.out.println("Something went wrong..Application user validation failed.");
                bAuthenticaed = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Create a Query to check user exists or not
        // Use the execute****() method
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return bAuthenticaed;
    
	}
	
	public boolean addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProfile(Users user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changePassword(int user_id, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean forgotPassword(int user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Users viewProfile(int user_id) {
		// TODO Auto-generated method stub
		Users user = new Users();
        try {
            System.out.println(VIEWPROFILE);
            PreparedStatement ps = conn.prepareStatement(VIEWPROFILE);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setLocation(rs.getString("location"));
                // System.out.println(rs.getString("password") + " ->" + rs.getString("name"));
            } else {
                System.out.println("User_id ->" + user_id + " doesnt exists in db.");
                user = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		if(conn!= null ){
            try{
            conn.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
	}

}
