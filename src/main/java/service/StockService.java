package main.java.service;

import main.java.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockService {

    private ObservableList<Product> stockData;

    public StockService() {
        // Initialize stock data
        this.stockData = FXCollections.observableArrayList();
        // Load stock data from database or other source if needed
    }

    public ObservableList<Product> getAllProducts() {
        return stockData;
    }

    public void addProduct(Product product) {
        // Add the product to the list of stock data
        stockData.add(product);
        // Save the product to the database or other storage if needed
    }
}
