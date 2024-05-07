package main.java.model;

import javafx.beans.property.*;

public class User {

    private final StringProperty username;
    private final StringProperty role;

    // Constructor
    public User(String username, String role) {
        this.username = new SimpleStringProperty(username);
        this.role = new SimpleStringProperty(role);
    }

    // Getter methods
    public String getUsername() {
        return username.get();
    }

    public String getRole() {
        return role.get();
    }

    // Setter methods
    public void setUsername(String username) {
        this.username.set(username);
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    // Property getters
    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty roleProperty() {
        return role;
    }
}
