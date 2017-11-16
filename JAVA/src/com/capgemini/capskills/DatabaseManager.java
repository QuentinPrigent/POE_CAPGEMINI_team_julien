package com.capgemini.capskills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    protected static final String DRIVER      = "jdbc";
    protected static final String SGBDR       = "mysql";
    protected static final String HOSTNAME    = "localhost";
    protected static final short  PORT        = 3306;
    protected static final String DB_NAME     = "capskills_db";
    protected static final String USER        = "root";
    protected static final String PASSWD      = "";

    /*
     * Constant definition for SQL requests for User
     */
    
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + UserDao.getTableName() + "("
            + "        user_id        		BIGINT NOT NULL AUTO_INCREMENT,"
            + "        user_firstname   	VARCHAR (50) NOT NULL,"
            + "        user_lastname 		VARCHAR(50) NOT NULL,"
            + "        email     			VARCHAR (50) NOT NULL,"
            + "		   password				VARCHAR (50), NOT NULL,"
            + "		   user_creation_date	DATETIME (50), NOT NULL,"
            + "		   user_id_1			INT,"
            + "        PRIMARY KEY (id ),"
            + "		   UNIQUE (user_creation_date)"
            + ")ENGINE=InnoDB;";
    

    private static final String SQL_DROP_DB = "DROP DATABASE IF EXISTS " + DB_NAME;
    private static final String SQL_CREATE_DB = "CREATE DATABASE " + DB_NAME;

    /**
     * Creates the connection to database.
     *
     * @see DatabaseManager::DB_NAME
     * @return
     */
    public static Connection createConnection() {
        return createConnection(DB_NAME);
    }

    /**
     * Creates the connection to database.
     *
     * @return
     */
    public static Connection createConnection(String dbName) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            System.exit(0);
        }

        try {
            String connectionString = (dbName == null
                    ? String.format("%s:%s://%s:%d", DRIVER, SGBDR, HOSTNAME, PORT)
                    : String.format("%s:%s://%s:%d/%s", DRIVER, SGBDR, HOSTNAME, PORT, dbName));
            connection = DriverManager.getConnection(connectionString, USER, PASSWD);
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
            System.exit(0);
        }

        return connection;
    }

    public boolean rebuildDatabaseSchema() {
        boolean success = true;

        try (Connection connection = createConnection(null)) {
            connection.prepareStatement(SQL_DROP_DB).execute();
            connection.prepareStatement(SQL_CREATE_DB).execute();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        try (
            Connection connection = createConnection(DB_NAME);
            PreparedStatement statementSchema = connection.prepareStatement(SQL_CREATE_TABLE);
        ) {
            statementSchema.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}
