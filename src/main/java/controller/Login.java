package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label wrongLogin;

    @FXML
    private void initialize() {
        // Initialization code, if needed
    }

    @FXML
    private void handleLoginButtonAction() {
        // Handle login button click event
    }
}
