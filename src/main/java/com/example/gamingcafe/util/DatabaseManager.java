package com.example.gamingcafe.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static final String PROPERTIES_FILE = "database.properties";

    private static volatile DatabaseManager instance;
    private Connection connection;
    private boolean isConnected = false;

    /* ------------------------------ CONSTRUCTOR ------------------------------ */

    private DatabaseManager() {
        try {
            Properties props = loadProperties();

            // Get db connection properties
            String dbUrl = props.getProperty("db.url");
            String dbUser = props.getProperty("db.user");
            String dbPassword = props.getProperty("db.password");

            // Connection initialization
            this.connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            this.isConnected = true;

            System.out.println("Connected to database.");

        } catch (IOException | SQLException e) {
            throw new RuntimeException("Unable to connect to database: " + e.getMessage() );
        }
    }

    /* ------------------------------ SINGLETON ------------------------------ */

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    /* ------------------------------ METHODS ------------------------------ */

    /**
     * Check connection status and reconnect if necessary
     */
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed() || !connection.isValid(2)) {
                reconnect();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to validate connection: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Check if db is connected
     */
    public boolean isConnected() {
        return isConnected;
    }

    /**
     * Close database connection
     */
    public boolean disconnect() {
        if (connection == null) {
            System.out.println("Already disconnected.");
            return true;
        }

        try {
            connection.close();
            isConnected = false;
            System.out.println("Disconnected from database.");
            return true;
        } catch (SQLException e) {
            System.err.println("Unable to disconnect from database: " + e.getMessage());
            return false;
        }
    }

    /* ------------------------------ PRIVATE HELPERS ------------------------------ */

    private Properties loadProperties() throws IOException {
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get(PROPERTIES_FILE)));
        return props;
    }

    private void reconnect() {
        try {
            Properties props = loadProperties();

            this.connection = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password")
            );
            this.isConnected = true;

            System.out.println("Reconnected to database.");

        } catch (IOException | SQLException e) {
            this.isConnected = false;
            throw new RuntimeException("Unable to connect to database: " + e.getMessage());
        }
    }

    // TODO: Add necessary CRUD methods
}
