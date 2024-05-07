package main.java.service;

import main.java.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SupplierService {

    private ObservableList<Supplier> supplierData;

    public SupplierService() {
        // Initialize supplier data
        this.supplierData = FXCollections.observableArrayList();
        // Load supplier data from database or other source if needed
    }

    public ObservableList<Supplier> getAllSuppliers() {
        return supplierData;
    }

    public void addSupplier(Supplier supplier) {
        // Add the supplier to the list of supplier data
        supplierData.add(supplier);
        // Save the supplier to the database or other storage if needed
    }
}
