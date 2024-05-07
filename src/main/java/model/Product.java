package main.java.model;

import javafx.beans.property.*;

public class Product {
    
    private final StringProperty productName;
    private final IntegerProperty quantity;

    // Constructor
    public Product(String productName, int quantity) {
        this.productName = new SimpleStringProperty(productName);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    // Getter methods
    public String getProductName() {
        return productName.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    // Setter methods
    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    // Property getters
    public StringProperty productNameProperty() {
        return productName;
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }
}
