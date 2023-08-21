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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdmClienteController {
	private Stage stage;
	private Scene scene;
	
	@FXML
    private Button btnVoltarLogin;

    @FXML
    private Button btnAdmClienteAlterar;

    @FXML
    private Button btnAdmClienteRemover;

    @FXML
    private Label lblAlmClienteCep;

    @FXML
    private Label lblAlmClienteCidade;

    @FXML
    private Label lblAlmClienteEmail;

    @FXML
    private Label lblAlmClienteEstado;

    @FXML
    private Label lblAlmClienteID;

    @FXML
    private Label lblAlmClienteNome;

    @FXML
    private Label lblAlmClienteNumero;

    @FXML
    private Label lblAlmClienteRua;

    
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
