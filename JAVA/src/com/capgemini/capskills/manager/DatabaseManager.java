package com.capgemini.capskills.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    /** URL to create/drop database. */
    private static final String SGBD_URL = "jdbc:mysql://localhost:3306";
    /** Name of used database. */
    private static final String DATABASE_NAME = "capskills_db"; 
    /** Connection URL to database to use (need it's created). */
    private static final String DATABASE_URL = SGBD_URL + "/" + DATABASE_NAME;
    
    /** User use for the database connection (should be in separated file). */
    private static final String USER = "root";  
    /** User password use for the database connection (should be in separated file). */
    private static final String PASSWORD = "";   
	
    /** The SQL request to drop the database. */
    private static final String SQL_DROP_DB = "DROP DATABASE IF EXISTS " + DATABASE_NAME;
    /** The SQL request to create the database. */
    private static final String SQL_CREATE_DB = "CREATE DATABASE " + DATABASE_NAME;
    
    private static final String SQL_CREATE_USER = "CREATE TABLE " + DATABASE_NAME + ".user ("
            + "user_id 				BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,"
            + "user_firstname 		VARCHAR(255),"
            + "user_lastname 		VARCHAR(255),"
            + "email 				VARCHAR(255) NOT NULL,"
            + "user_password() 		VARCHAR(100),"
            + "user_creation_date	DATETIME NOT NULL,"
            + "user_id_1			INT,"
            + "UNIQUE (user_creation_date)"
            + ")ENGINE=innoDB";  
    
//    CREATE TABLE User(
//            user_id            int (11) Auto_increment  NOT NULL ,
//            user_firstname     Varchar (255) ,
//            user_lastname      Varchar (255) ,
//            email              Varchar (25) NOT NULL ,
//            user_password      Varchar (100) ,
//            user_creation_date Datetime NOT NULL ,
//            user_id_1          Int ,
//            PRIMARY KEY (user_id ) ,
//            UNIQUE (user_creation_date )
//    )ENGINE=InnoDB;  
//  
}
