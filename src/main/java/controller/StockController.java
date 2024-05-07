package main.java.controller;

import main.java.model.Product;
import main.java.service.StockService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StockController {

    @FXML
    private TableView<Product> stockTableView;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField quantityTextField;

    private StockService stockService;

    private ObservableList<Product> productList;

    public StockController() {
        stockService = new StockService();
        productList = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        // Initialize table columns
        productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        // Populate table with existing products in stock
        productList.addAll(stockService.getAllProducts());
        stockTableView.setItems(productList);
    }

    @FXML
    private void handleAddProduct() {
        String productName = productNameTextField.getText().trim();
        String quantityText = quantityTextField.getText().trim();

        if (!productName.isEmpty() && !quantityText.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityText);
                Product newProduct = new Product(productName, quantity);
                stockService.addProduct(newProduct);
                productList.add(newProduct);
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
