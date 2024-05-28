package main.java.controller;

import main.java.Main;
import main.java.model.User;
import main.java.service.UserService;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class UserController {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField telTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    
    @FXML
    private Button addUserButton;
    @FXML
    private Button exitAddUser;

    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @FXML
    private void exitPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("../resources/fxml/usersTable.fxml");
    }

    @FXML
    private void handleAddUser() {
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String tel = telTextField.getText().trim();
        String username = usernameTextField.getText().trim();
        String password = passwordPasswordField.getText().trim();

        if (isInputValid(firstName, lastName, email, tel, username, password)) {
            User newUser = new User(firstName, lastName, email, tel, username, password);
            userService.addUser(newUser);
            clearFields();
        }
    }

    private boolean isInputValid(String firstName, String lastName, String email, String tel, String username, String password) {
        StringBuilder errorMessage = new StringBuilder();

        if (firstName.isEmpty()) {
            errorMessage.append("First name is required.\n");
        }
        if (lastName.isEmpty()) {
            errorMessage.append("Last name is required.\n");
        }
        if (email.isEmpty() || !isValidEmail(email)) {
            errorMessage.append("A valid email is required.\n");
        }
        if (tel.isEmpty() || !isValidPhoneNumber(tel)) {
            errorMessage.append("A valid phone number is required.\n");
        }
        if (username.isEmpty()) {
            errorMessage.append("Username is required.\n");
        }
        if (password.isEmpty() || password.length() < 8) {
            errorMessage.append("Password must be at least 8 characters long.\n");
        }

        if (errorMessage.length() > 0) {
            showAlert("Invalid Input", errorMessage.toString());
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String tel) {
        String phoneRegex = "\\d{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(tel);
        return matcher.matches();
    }

    private void clearFields() {
        firstNameTextField.clear();
        lastNameTextField.clear();
        emailTextField.clear();
        telTextField.clear();
        usernameTextField.clear();
        passwordPasswordField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
