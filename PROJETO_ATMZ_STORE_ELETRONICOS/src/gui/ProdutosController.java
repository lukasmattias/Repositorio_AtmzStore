package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ProdutosController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	 @FXML
	    private Button btnAbrirCarrinho;
	 @FXML
	    private Button btnSmartphones;
	 @FXML
	    private Button btnEletrDomesticos;
	 @FXML
	    private Button btnGadgets;
	 @FXML
	    private Button btnFotoeVideo;
	 @FXML
	    private Button btnComputadores;
	 @FXML
	    private Button btnVoltarParaLogin;
	 
	 @FXML
	    public void VoltarParaLogin(ActionEvent event) throws IOException{
	    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 	scene = new Scene(root);
	   	 	stage.setTitle("ATMZ STORE ");
	   	 	stage.setScene(scene);
	   	 	stage.show();
	    }

	 @FXML
	    public void abrirCarrinhoAcionado(ActionEvent event) throws IOException{
	    	Parent root = FXMLLoader.load(getClass().getResource("Carrinho.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 	scene = new Scene(root);
	   	 	stage.setTitle("ATMZ STORE CARRINHO");
	   	 	stage.setScene(scene);
	   	 	stage.show();
	    }

	    @FXML
	    public void selecionadoSmartphones(ActionEvent event) {

	    }

	    @FXML
	    public void selecionadoEletrDomesticos(ActionEvent event) {

	    }

	    @FXML
	    public void selecionadoGadgets(ActionEvent event) {

	    }

	    @FXML
	    public void selecionadoFotoeVideo(ActionEvent event) {

	    }

	    @FXML
	    public void selecionadoComputadores(ActionEvent event) {

	    }

	
	
	
}
