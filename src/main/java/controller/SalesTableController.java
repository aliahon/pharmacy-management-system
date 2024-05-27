package main.java.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.java.Main;

public class SalesTableController {
	@FXML
	private Button exitButton;
	@FXML
	private Button addVenteButton;
	@FXML
	private Button searchButton;
	@FXML
    private TextField searchBar;
	
	@FXML
    private void versAddVente(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/addSale.fxml");
    }
	
	@FXML
    private void exitPage(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/AdminPage.fxml");
    }
	
	@FXML
    private void search(ActionEvent event) throws IOException{
       
    }
}

