package main.java.service;

import main.java.Database;
import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserService {

    private ObservableList<User> userData;

    public UserService() {
        // Initialize user data
        this.userData = FXCollections.observableArrayList();
        // Load user data from database
        loadAllUsers();
    }

    public ObservableList<User> getAllUsers() {
        return userData;
    }

    private void loadAllUsers() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = Database.getConnection();
            String sql = "SELECT * FROM User";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                
                User user = new User(firstName, lastName, email, tel, username, password);
                userData.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error loading users from the database: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Database.closeConnection(connection);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Database.getConnection();
            connection.setAutoCommit(false); // Start transaction

            String sql = "INSERT INTO User (first_name, last_name, email, tel, username, password) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, user.getFirstName().get());
            statement.setString(2, user.getLastName().get());
            statement.setString(3, user.getEmail().get());
            statement.setString(4, user.getTel().get());
            statement.setString(5, user.getUsername().get());
            statement.setString(6, user.getPassword().get());

            int rowsAffected = statement.executeUpdate();
            
            connection.commit(); 
            
            if (rowsAffected > 0) {
                userData.add(user); 
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); 
                } catch (SQLException rollbackEx) {
                    System.err.println("Error rolling back transaction: " + rollbackEx.getMessage());
                }
            }
            System.err.println("Error adding user to the database: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            Database.closeConnection(connection); // Ensure connection is closed
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
