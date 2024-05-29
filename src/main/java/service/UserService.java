package main.java.service;

import main.java.Database;
import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

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
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
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
        }
    }

    public boolean addUser(User user) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO user (firstName, lastName, email, tel, username, password) VALUES (?, ?, ?, ?, ?, ?)")) {

            connection.setAutoCommit(false);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getTel());
            statement.setString(5, user.getUsername());
            statement.setString(6, user.getPassword());

            int rowsAffected = statement.executeUpdate();

            connection.commit();

            if (rowsAffected > 0) {
                userData.add(user);
                return true;
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur lors de l'ajout de l'utilisateur à la base de données : ", "Aucune ligne affectée.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error adding user to the database: " + e.getMessage());
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while adding the user to the database: " + e.getMessage());
            return false;
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
