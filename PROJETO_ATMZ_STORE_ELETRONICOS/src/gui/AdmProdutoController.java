package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdmProdutoController {
	private Stage stage;
	private Scene scene;

	@FXML
    private Button btnVoltarLogin;
	
    @FXML
    private Button btnAdmProdutoAdicionar;

    @FXML
    private Button btnAdmProdutoAlterar;

    @FXML
    private Button btnAdmProdutoRemover;

    @FXML
    private Label lblAdmProdutoCategoria;

    @FXML
    private Label lblAdmProdutoDescricao;

    @FXML
    private Label lblAdmProdutoEstoque;

    @FXML
    private Label lblAdmProdutoID;

    @FXML
    private Label lblAdmProdutoNome;

    @FXML
    private Label lblAdmProdutoPreco;

    @FXML
    public void VoltarLogin(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	 	scene = new Scene(root);
   	 	stage.setTitle("ATMZ STORE ");
   	 	stage.setScene(scene);
   	 	stage.show();
    }
    
}
