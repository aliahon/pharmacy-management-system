package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the main FXML file
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/login.fxml"));

        // Set up the primary stage
        primaryStage.setTitle("Pharmacy Management System | Login");
        primaryStage.setScene(new Scene(root, 600,400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
