package main.java.controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.Database;
import main.java.Main;

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
    private void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    @FXML
    private void checkLogin() throws IOException {
        Main m = new Main();
        
        String usernameInput = username.getText().trim();
        String passwordInput = password.getText().trim();
        
        if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
            wrongLogin.setText("Tous les champs sont obligatoires!");
            return;
        }
        if (!isValidUsername(usernameInput)) {
        	showAlert(AlertType.ERROR, "Erreur", null, "Le nom d'utilisateur doit être composé uniquement de caractères alphanumériques et doit contenir entre 4 et 20 caractères.");
        	return;
        }

        if (!isValidPassword(passwordInput)) {
            showAlert(AlertType.ERROR, "Erreur", null, "Le mot de passe doit comporter entre 8 et 20 caractères!");
            return;
        }

        

        if (usernameInput.equals("admin") && passwordInput.equals("00000000")) {
            wrongLogin.setText("Success");
            m.changeScene("../resources/fxml/AdminPage.fxml");
            return;
        }

        String sql = "SELECT * FROM user WHERE username = ? and password = ?";
        try (Connection connect = Database.getConnection();
             PreparedStatement prepare = connect.prepareStatement(sql)) {

            prepare.setString(1, usernameInput);
            prepare.setString(2, passwordInput);
            try (ResultSet result = prepare.executeQuery()) {
                if (result.next()) {
                    wrongLogin.setText("Success");
                    m.changeScene("../resources/fxml/pharmacistPage.fxml");
                } else {
                    wrongLogin.setText("Le nom d'utilisateur ou le mot de passe est incorrect!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            wrongLogin.setText("An error occurred. Please try again.");
        }
    }

    private boolean isValidUsername(String username) {
        
        String regex = "^[a-zA-Z0-9]{4,20}$";
        return username.matches(regex);
    }

    private boolean isValidPassword(String password) {
        
        return password.length() >= 8 && password.length() <= 20;
    }
    private void showAlert(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
