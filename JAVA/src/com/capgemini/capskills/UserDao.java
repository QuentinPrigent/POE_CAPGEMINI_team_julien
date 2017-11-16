package com.capgemini.capskills;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

public class UserDao extends AbstractDao{
	//SQL Command to select all elements from the table
    private static final String SQL_SELECT_ALL = "SELECT * FROM " + getTableName();
    //SQL Command to insert a user
    private static final String SQL_INSERT_USER = "INSERT INTO " + getTableName()
    + " (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";   
    
    
    
    
    private void tune(PreparedStatement st, User user) throws SQLException {
    	st.setString(1, user.getFirstname());
    	st.setString(2, user.getLastname());
    	st.setString(3, user.getEmail());
    	st.setString(4, user.getPassword());
    }
    
    /**
     * Return the name of the table
     * @return
     */
    
    public static final String getTableName() {
        return "user";
    } 
}
