package main.java.controller;

import main.java.Main;
import main.java.model.Product;
import main.java.service.StockService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StockController {


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField manufacturerNameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField expirationDateTextField;
    @FXML
    private TextField categorieTextField;
    @FXML
    private Button exitAddProduct;
    @FXML
    private Button addProductButton;

    private StockService stockService;


    public StockController() {
        stockService = new StockService();
    }
    @FXML
    private void exitPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("../resources/fxml/productsTable.fxml");
    }

    @FXML
    private void handleAddProduct() {
        String name = nameTextField.getText().trim();
        String description = descriptionTextField.getText().trim();
        String manufacturerName = manufacturerNameTextField.getText().trim();
        String quantityText = quantityTextField.getText().trim();
        String priceText = priceTextField.getText().trim();
        String expirationDateText = expirationDateTextField.getText().trim();
        String categorie = categorieTextField.getText().trim();

        if (!name.isEmpty() && !description.isEmpty() && !manufacturerName.isEmpty() && !priceText.isEmpty() && !expirationDateText.isEmpty() && !categorie.isEmpty() && !quantityText.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityText);
                double price = Double.parseDouble(priceText);
                LocalDate expirationDate = LocalDate.parse(expirationDateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                Product newProduct = new Product(name, description, manufacturerName, quantity, price, expirationDate, categorie);
                stockService.addProduct(newProduct);
                clearFields();
            } catch (NumberFormatException e) {
                showAlert("Error", "Please enter valid quantity and price.");
            } catch (DateTimeParseException e) {
                showAlert("Error", "Please enter a valid expiration date in the format yyyy-MM-dd.");
            }
        } else {
            showAlert("Error", "Please fill in all required fields.");
        }
    }
    private void clearFields() {
       nameTextField.clear();
       descriptionTextField.clear();
        manufacturerNameTextField.clear();
        quantityTextField.clear();
         priceTextField.clear();
        expirationDateTextField.clear();
        categorieTextField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
