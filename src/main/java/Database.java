package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost:5011/pharmacy_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "10214ailaEL";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            // Attempt to establish a connection to the database
            Connection connection = Database.getConnection();
            
            // If the connection is successful, print a success message
            System.out.println("Connection to the database established successfully!");
            
            // Don't forget to close the connection when you're done using it
            Database.closeConnection(connection);
        } catch (SQLException e) {
            // If there's an error during the connection process, print the error message
            System.err.println("Error connecting to the database: " + e.getMessage());
            // You can also print the stack trace for more details
            e.printStackTrace();
        }
    }
}

