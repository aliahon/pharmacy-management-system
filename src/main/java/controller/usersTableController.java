package main.java.controller;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.Main;
import main.java.model.User;
import main.java.service.UserService;

public class usersTableController {
    @FXML
    private Button exitButton;
    @FXML
    private Button addUserButton;
    @FXML
    private Button deleteUserButton;
    @FXML
    private Button modifyUserButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchBar;
    @FXML
    private TableView<User> userTableView;
    @FXML
    private TableColumn<User, String> nomColumn;
    @FXML
    private TableColumn<User, String> prenomColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> telColumn;
    @FXML
    private TableColumn<User, String> nomUtilisateurColumn;
    @FXML
    private TableColumn<User, String> motDePasseColumn;

    private UserService userService;

    @FXML
    public void initialize() {
        userService = new UserService();

        nomColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
        nomUtilisateurColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        motDePasseColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        userTableView.setItems(userService.getAllUsers());
    }

    @FXML
    private void versAddUser(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("../resources/fxml/addUser.fxml");
    }

    @FXML
    private void exitPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("../resources/fxml/AdminPage.fxml");
    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        String searchText = searchBar.getText().toLowerCase();
        ObservableList<User> filteredUsers = userService.getAllUsers().filtered(user -> 
            user.getFirstName().toLowerCase().contains(searchText) || 
            user.getLastName().toLowerCase().contains(searchText) ||
            user.getEmail().toLowerCase().contains(searchText) ||
            user.getTel().toLowerCase().contains(searchText) ||
            user.getUsername().toLowerCase().contains(searchText)
        );
        userTableView.setItems(filteredUsers);
    }
    
    @FXML
    private void handleDeleteUser() {
        User selectedUser = userTableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            boolean success = userService.deleteUser(selectedUser);
            if (success) {
                userTableView.getItems().remove(selectedUser);
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de supprimer l'utilisateur.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Avertissement", "Veuillez sélectionner un utilisateur à supprimer.");
        }
    }

    @FXML
    private void handleModifyUser(ActionEvent event) throws IOException {
        User selectedUser = userTableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            Main m = new Main();
            m.changeScene("../resources/fxml/modifyUser.fxml", controller -> {
                if (controller instanceof UserController) {
                    ((UserController) controller).setUser(selectedUser);
                }
            });
        } else {
            showAlert(Alert.AlertType.WARNING, "Avertissement", "Veuillez sélectionner un utilisateur à modifier.");
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
