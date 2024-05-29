package main.java.model;

import java.time.LocalDate;

import javafx.beans.property.*;

public class Product {
    private StringProperty name;
    private StringProperty description;
    private StringProperty manufacturerName;
    private IntegerProperty quantity;
    private DoubleProperty price;
    private ObjectProperty<LocalDate> expirationDate; 
    private StringProperty categorie;

    // Constructor
    public Product(String name, String description, String manufacturerName, int quantity, double price, LocalDate expirationDate, String categorie) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.manufacturerName = new SimpleStringProperty(manufacturerName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleDoubleProperty(price);
        this.expirationDate = new SimpleObjectProperty<>(expirationDate);
        this.categorie = new SimpleStringProperty(categorie);
    }

    // Getters and setters for each property
    public StringProperty nameProperty() {
        if (name == null) {
            name = new SimpleStringProperty(this, "name");
        }
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    public String getName() {
        return nameProperty().get();
    }

    public StringProperty descriptionProperty() {
        if (description == null) {
            description = new SimpleStringProperty(this, "description");
        }
        return description;
    }

    public void setDescription(String description) {
        descriptionProperty().set(description);
    }

    public String getDescription() {
        return descriptionProperty().get();
    }

    public StringProperty manufacturerNameProperty() {
        if (manufacturerName == null) {
            manufacturerName = new SimpleStringProperty(this, "manufacturerName");
        }
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        manufacturerNameProperty().set(manufacturerName);
    }

    public String getManufacturerName() {
        return manufacturerNameProperty().get();
    }

    public IntegerProperty quantityProperty() {
        if (quantity == null) {
            quantity = new SimpleIntegerProperty(this, "quantity");
        }
        return quantity;
    }

    public void setQuantity(int quantity) {
        quantityProperty().set(quantity);
    }

    public int getQuantity() {
        return quantityProperty().get();
    }

    public DoubleProperty priceProperty() {
        if (price == null) {
            price = new SimpleDoubleProperty(this, "price");
        }
        return price;
    }

    public void setPrice(double price) {
        priceProperty().set(price);
    }

    public double getPrice() {
        return priceProperty().get();
    }

    public ObjectProperty<LocalDate> expirationDateProperty() { // Change return type to ObjectProperty<LocalDate>
        if (expirationDate == null) {
            expirationDate = new SimpleObjectProperty<>(this, "expirationDate");
        }
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        expirationDateProperty().set(expirationDate);
    }

    public LocalDate getExpirationDate() {
        return expirationDateProperty().get();
    }

    public StringProperty categorieProperty() {
        if (categorie == null) {
            categorie = new SimpleStringProperty(this, "categorie");
        }
        return categorie;
    }

    public void setCategorie(String categorie) {
        categorieProperty().set(categorie);
    }

    public String getCategorie() {
        return categorieProperty().get();
    }
}
