package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class Main extends Application {
	
	private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
    	stg = primaryStage;
    	primaryStage.setResizable(false);
        // Load the main FXML file
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/login.fxml"));

        // Set up the primary stage
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.setScene(new Scene(root, 729,402));
        primaryStage.show();
    }
    
    public void changeScene(String fxml) throws IOException {
    	Parent pane= FXMLLoader.load(getClass().getResource(fxml));
    	stg.getScene().setRoot(pane);
    }
    
    public void changeScene(String fxml, Consumer<Object> controllerInitializer) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        
        // If an initializer is provided, use it to initialize the controller
        if (controllerInitializer != null) {
            controllerInitializer.accept(loader.getController());
        }

        stg.getScene().setRoot(root);
    }
    

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
