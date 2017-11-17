package com.capgemini.capskills.DAO;

import java.sql.Connection;

import com.capgemini.capskills.DatabaseManager;

public abstract class AbstractDao {
    protected Connection createConnection() {
        return DatabaseManager.createConnection();
    }
}