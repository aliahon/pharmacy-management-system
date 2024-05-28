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
            
            Connection connection = Database.getConnection();
            
            
            System.out.println("Connection to the database established successfully!");
            
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
           
            System.err.println("Error connecting to the database: " + e.getMessage());
            
            e.printStackTrace();
        }
    }
}

