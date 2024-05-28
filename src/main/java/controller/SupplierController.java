package main.java.controller;

import main.java.model.Supplier;
import main.java.service.SupplierService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SupplierController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField contactTextField;

    private SupplierService supplierService;

    public SupplierController() {
        supplierService = new SupplierService();
    }

    @FXML
    private void initialize() {
        
    }

    @FXML
    private void handleAddSupplier() {
        String name = nameTextField.getText().trim();
        String contact = contactTextField.getText().trim();

        if (!name.isEmpty() && !contact.isEmpty()) {
            Supplier newSupplier = new Supplier(name, contact);
            supplierService.addSupplier(newSupplier);
            clearFields();
        } else {
            showAlert("Error", "Please enter supplier name and contact information.");
        }
    }

    private void clearFields() {
        nameTextField.clear();
        contactTextField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
