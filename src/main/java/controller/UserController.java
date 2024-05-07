package main.java.controller;

import main.java.model.User;
import main.java.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserController {

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField roleTextField;

    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @FXML
    private void initialize() {
        // Initialize table columns
        usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        roleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());

        // Populate table with existing users
        userTableView.setItems(userService.getAllUsers());
    }

    @FXML
    private void handleAddUser() {
        String username = usernameTextField.getText().trim();
        String role = roleTextField.getText().trim();

        if (!username.isEmpty() && !role.isEmpty()) {
            User newUser = new User(username, role);
            userService.addUser(newUser);
            userTableView.getItems().add(newUser);
            clearFields();
        } else {
            showAlert("Error", "Please enter a username and a role.");
        }
    }

    private void clearFields() {
        usernameTextField.clear();
        roleTextField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
