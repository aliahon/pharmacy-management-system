package main.java.controller;

import main.java.model.Supplier;
import main.java.service.SupplierService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SupplierController {

    @FXML
    private TableView<Supplier> supplierTableView;

    @FXML
    private TableColumn<Supplier, String> nameColumn;

    @FXML
    private TableColumn<Supplier, String> contactColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField contactTextField;

    private SupplierService supplierService;

    private ObservableList<Supplier> supplierList;

    public SupplierController() {
        supplierService = new SupplierService();
        supplierList = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        // Initialize table columns
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        contactColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty());

        // Populate table with existing suppliers
        supplierList.addAll(supplierService.getAllSuppliers());
        supplierTableView.setItems(supplierList);
    }

    @FXML
    private void handleAddSupplier() {
        String name = nameTextField.getText().trim();
        String contact = contactTextField.getText().trim();

        if (!name.isEmpty() && !contact.isEmpty()) {
            Supplier newSupplier = new Supplier(name, contact);
            supplierService.addSupplier(newSupplier);
            supplierList.add(newSupplier);
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
