package main.java.controller;

import main.java.model.User;
import main.java.service.UserService;
//import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class UserController {

    @FXML
    private TableView<User> userTableView; //hada howa id li t3ty l tableaux dylk

    @FXML
    private TableColumn<User, String> usernameColumn;


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
    
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }
    
/*  MARYAM HNA ADIRI L CODE DYL DIK LISTES DES UTILISATEURS
    @FXML
    private void initialize() {
        // Initialize table columns
        usernameColumn.setCellValueFactory(cellData -
        > cellData.getValue().usernameProperty());
        // Populate table with existing users
        userTableView.setItems(userService.getAllUsers());
    }*/
    

    @FXML
    private void handleAddUser() {
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String tel = telTextField.getText().trim();
        String username = usernameTextField.getText().trim();
        String password = passwordPasswordField.getText().trim();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !tel.isEmpty() && !username.isEmpty() && !password.isEmpty() ) {
            User newUser = new User(firstName,lastName, email, tel,username,password);
            userService.addUser(newUser);
            userTableView.getItems().add(newUser);
            clearFields();
        } else {
            showAlert("Error", "Please enter a username and a role.");
        }
    }

    private void clearFields() {
        usernameTextField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
