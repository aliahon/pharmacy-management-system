package main.java.service;

import main.java.model.User;
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

    public void addUser(User user) {
        // Add the user to the list of user data
        userData.add(user);
        // Save the user to the database or other storage if needed
    }
}
