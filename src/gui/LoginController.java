package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class LoginController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TextField usuarioInput;
    @FXML
    private PasswordField senhaInput;
    @FXML
    private GridPane TelaLogin;

    @FXML
    public void confirmarLogin(ActionEvent event) throws IOException{
        String username = usuarioInput.getText();
        String password = senhaInput.getText();
        
        if (validarCredenciais(username, password)) {
            Parent root = FXMLLoader.load(getClass().getResource("Produtos.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("ATMZ STORE PRODUTOS");
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Credenciais Invalidas");
            alert.setHeaderText("Credenciais invalidas. Tente novamente!");
            alert.showAndWait();
            
        }
    }

    @FXML
    public void cadastrarAcionado(ActionEvent event) throws IOException {
    	 Parent root = FXMLLoader.load(getClass().getResource("Cadastrar.fxml"));
    	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	 scene = new Scene(root);
    	 stage.setTitle("ATMZ STORE CADASTRAR USUARIO");
    	 stage.setScene(scene);
    	 stage.show();
    }

    private boolean validarCredenciais(String username, String password) {

        return username.equals("usuario") && password.equals("1234");
    }
}
