package main.java.controller;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.java.Main;


public class Pharmacist {
	@FXML
	private Button logOut;
	@FXML
	private Button profilButton;
	@FXML
	private Button produitButton;
	@FXML
	private Button achatButton;
	@FXML
	private Button venteButton;
	@FXML
	private Button categoryButton;
	@FXML
	private Button fournisseurButton;
	
	@FXML
    private void userLogOut(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/login.fxml");
    }
	
	@FXML
    private void versProfil(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/profile.fxml");
    }
	
	@FXML
    private void versProduit(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/productsTable.fxml");
    }
	
	@FXML
    private void versVente(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/SalesTable(Pharm).fxml");
    }
	
	
	@FXML
    private void versAchat(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/Table_Achat_phar.fxml");
    }
	
	
	@FXML
    private void versCategory(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/Categories.fxml");
    }
	@FXML
    private void versFournisseur(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("../resources/fxml/SuppliersTable(phar).fxml");
    }

}


