package main.java.controller;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    @FXML
    private void checkLogin()  throws IOException{
        Main m = new Main();
        
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("0000")) {
        	wrongLogin.setText("Success");
        	
        	m.changeScene("../resources/fxml/AdminPage.fxml");
        	
        }else if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
        	wrongLogin.setText("Tous les champs sont obligatoires!");
        }else{
        	wrongLogin.setText("username ou password est incorrecte!");
        }
    }
}

