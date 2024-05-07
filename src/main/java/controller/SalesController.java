package main.java.controller;

import main.java.model.Sale;
import main.java.service.SalesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SalesController {

    @FXML
    private TableView<Sale> salesTableView;

    @FXML
    private TableColumn<Sale, String> productNameColumn;

    @FXML
    private TableColumn<Sale, Integer> quantityColumn;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField quantityTextField;

    private SalesService salesService;

    private ObservableList<Sale> salesList;

    public SalesController() {
        salesService = new SalesService();
        salesList = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        // Initialize table columns
        productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        // Populate table with existing sales
        salesList.addAll(salesService.getAllSales());
        salesTableView.setItems(salesList);
    }

    @FXML
    private void handleRecordSale() {
        String productName = productNameTextField.getText().trim();
        String quantityText = quantityTextField.getText().trim();

        if (!productName.isEmpty() && !quantityText.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityText);
                Sale newSale = new Sale(productName, quantity);
                salesService.recordSale(newSale);
                salesList.add(newSale);
                clearFields();
            } catch (NumberFormatException e) {
                showAlert("Error", "Please enter a valid quantity.");
            }
        } else {
            showAlert("Error", "Please enter a product name and quantity.");
        }
    }

    private void clearFields() {
        productNameTextField.clear();
        quantityTextField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
