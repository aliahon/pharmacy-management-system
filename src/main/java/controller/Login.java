package main.java.controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
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
    
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    
    private void initializeDbConnection() {
        try {
            connect = Database.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    @FXML
    private void checkLogin()  throws IOException{
    	initializeDbConnection();
    	
        Main m = new Main();
        
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("0000")) {
        	wrongLogin.setText("Success");
        	
        	m.changeScene("../resources/fxml/AdminPage.fxml");
        	
        }else if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
        	wrongLogin.setText("Tous les champs sont obligatoires!");
        }else{
        	try {
                String sql = "SELECT * FROM User WHERE username = ? and password = ?";
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, username.getText().toString());
                prepare.setString(2, password.getText().toString());
                result = prepare.executeQuery();
                
                if (result.next()) {
                    wrongLogin.setText("Success");
                    m.changeScene("../resources/fxml/pharmacistPage.fxml");
                } else {
                    wrongLogin.setText("username ou password est incorrecte!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                wrongLogin.setText("An error occurred. Please try again.");
            } finally {
                try {
                    if (result != null) result.close();
                    if (prepare != null) prepare.close();
                    if (connect != null) connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

