package main.java.service;

import main.java.model.Sale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SalesService {

    private ObservableList<Sale> salesData;

    public SalesService() {
        // Initialize sales data
        this.salesData = FXCollections.observableArrayList();
        // Load sales data from database or other source if needed
    }

    public ObservableList<Sale> getAllSales() {
        return salesData;
    }

    public void recordSale(Sale sale) {
        // Add the sale to the list of sales data
        salesData.add(sale);
        // Save the sale to the database or other storage if needed
    }
}
