package com.epm.dao;

public interface Sqls {
	public static final String LOGINSQL        ="select * from users where user_id=? and password=?";
    public static final String VIEWPROFILE     ="select * from users where user_id=?" ;
    public static final String UPDATEPROFILE1  ="update users set name=? , location=? where user_id=?";
    public static final String CHANGEPASSWORD  ="update users set password=? where user_id=?" ;
    public static final String DEFAULTPASSWORD ="Password";
    public static final String ADDUSER         ="insert into users(user_id,password,name,location) values (?,?,?,?) "  ;
    public static final String USEREXISTS     ="select * from users where user_id=?" ;
    //++++++++++
    public static final String SEARCH1_EXPENSETYPE ="select * from expensetype where expense_type=? and expense_subtype=?";
    public static final String SEARCH2_EXPENSETYPE ="select * from expensetype where expense_id=? ";
    //for oracle
    public static final String INSERT1_EXPENSETYPE ="insert into expensetype (expense_id,expense_type,expense_subtype) values (seq_expense.nextval,?,?) ";
    //for mysql
    public static final String INSERT2_EXPENSETYPE ="insert into expensetype (expense_type,expense_subtype) values (?,?) ";
    //Add for update / delete later.
    
    //10 items for oracle
    public static final String INSERT1_PURCHASING="insert into purchasing (purchase_id ,user_id,card_4_digit_info ,card_type  , bank_name , cash_used ,purchase_amount,purchase_date ,purchase_desc ,expense_type_id) values (seq_purchase_id.nextval,?,?,?,?,?,?,?,?,?)"; 
    //9 items for mysql
    public static final String INSERT2_PURCHASING="insert into purchasing (user_id ,card_4_digit_info ,card_type  , bank_name , cash_used ,purchase_amount,purchase_date ,purchase_desc ,expense_type_id) values (?,?,?,?,?,?,?,?,?)"; 
    
    public static final String FIND_PURCHASE_BYID ="select * from purchasing where purchase_id= ?";
    public static final String FIND_ALL_PURCHASES ="select * from purchasing where user_id= ? order by purchase_id desc";
    public static final String DELETE_PURCHASE = "delete from  purchasing where purchase_id= ?";
    public static final String UPDATE_PURCHASE ="update purchasing set card_4_digit_info =? , card_type=? , bank_name=? , cash_used=? ,purchase_amount=? ,purchase_date=? , purchase_desc=? ,expense_type_id=? where purchase_id=? and user_id=?";
    
    
    //Add for update.
    //Add for delete later.

}
