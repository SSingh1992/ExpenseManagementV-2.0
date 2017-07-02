package com.epm.dao;
import com.epm.dto.Users;
public interface UsersDAO {
	public boolean login(int user_id,String password);
    public boolean addUser(Users user) throws Exception;
    public boolean updateProfile(Users user) throws Exception;
    public boolean changePassword(int user_id, String newPassword);
    public boolean forgotPassword(int user_id);
    public Users   viewProfile(int user_id);
    //++
    public void    closeConnection();  

}
