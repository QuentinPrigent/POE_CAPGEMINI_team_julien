package com.capgemini.capskills.dao;

import java.sql.Connection;

import com.capgemini.capskills.manager.DatabaseManager;

public abstract class AbstractDao {
    protected Connection createConnection() {
        return DatabaseManager.createConnection();
    }
}