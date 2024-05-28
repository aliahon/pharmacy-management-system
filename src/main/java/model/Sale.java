package main.java.model;

import java.util.Date;

public class Sale {
    private Product product;
    private int quantity;
    private double totalPrice;
    private Date saleDate;

    public Sale(Product product, int quantity, double totalPrice, Date saleDate) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.saleDate = saleDate;
    }

    // Getters and setters for each field
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sale [product=" + product + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", saleDate="
                + saleDate + "]";
    }
}
