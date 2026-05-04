package com.example.gamingcafe.util;

import java.sql.Connection;

public class DatabaseManager {
    private static final String PROPERTIES_FILE = "database.properties";
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    private static DatabaseManager instance;
    private Connection connection;
    private boolean isConnected = false;

    // TODO: Finish this database manager class

    private static void loadDatabaseProperties() {

    }
}
