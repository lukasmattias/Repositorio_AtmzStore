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

public class CadastrarController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
    private AnchorPane TelaCadastrar;
    @FXML
    private Button btnConfirmarCad;
    @FXML
    private Button btnVoltarTelaLogin;

    @FXML
    public void voltarTelaLogin(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	 	scene = new Scene(root);
   	 	stage.setTitle("ATMZ STORE");
   	 	stage.setScene(scene);
   	 	stage.show();
    }

    @FXML
    public void confirmarCadastro(ActionEvent event) {

    }

    
}
