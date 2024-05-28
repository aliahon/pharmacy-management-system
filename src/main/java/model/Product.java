package main.java.model;

public class Product {
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String expirationDate;

    public Product(String name, String description, int quantity, double price, String expirationDate) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", description=" + description + ", quantity=" + quantity + ", price=" + price
                + ", expirationDate=" + expirationDate + "]";
    }
}
