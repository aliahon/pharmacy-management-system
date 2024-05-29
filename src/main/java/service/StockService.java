package main.java.service;

import main.java.Database;
import main.java.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class StockService {

    private ObservableList<Product> stockData;

    public StockService() {

    }

    public ObservableList<Product> getAllProducts() {
        return stockData;
    }

    public boolean addProduct(Product product) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO product (name, description, manifacturerName, quantity, price, expirationDate, categorie) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            connection.setAutoCommit(false);

            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setString(3, product.getManufacturerName());
            statement.setInt(4, product.getQuantity());
            statement.setDouble(5, product.getPrice());
            
            LocalDate expirationDate = product.getExpirationDate();
            if (expirationDate != null) {
                statement.setDate(6, java.sql.Date.valueOf(expirationDate));
            } else {
                statement.setNull(6, java.sql.Types.DATE);
            }
            
            statement.setString(7, product.getCategorie());

            int rowsAffected = statement.executeUpdate();
            connection.commit();

            if (rowsAffected > 0) {
                return true;
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur lors de l'ajout du produit à la base de données", "Aucune ligne affectée.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error adding product to the database: " + e.getMessage());
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur de base de données", "Une erreur s'est produite lors de l'ajout du produit à la base de données: " + e.getMessage());
            return false;
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
