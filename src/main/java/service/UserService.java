package main.java.service;

import main.java.Database;
import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserService {

    private ObservableList<User> userData;

    public UserService() {
        // Initialize user data
        this.userData = FXCollections.observableArrayList();
        // Load user data from database or other source if needed
    }

    public ObservableList<User> getAllUsers() {
        return userData;
    }

    public boolean addUser(User user) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO User (first_name, last_name, email, tel, username, password) " +
                             "VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, user.getFirstName().get());
            statement.setString(2, user.getLastName().get());
            statement.setString(3, user.getEmail().get());
            statement.setString(4, user.getTel().get());
            statement.setString(5, user.getUsername().get());
            statement.setString(6, user.getPassword().get());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding user to the database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
