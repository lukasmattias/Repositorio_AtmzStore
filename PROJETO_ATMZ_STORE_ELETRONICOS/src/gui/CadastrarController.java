package gui;

import java.io.IOException;

import exception.OperacaoInvalidaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import negocio.UsuarioController;
import negocio.beans.Cliente;
import negocio.beans.Endereco;


public class CadastrarController {
	private Stage stage;
	private Scene scene;

	@FXML
    private AnchorPane TelaCadastrar;
    @FXML
    private Button btnConfirmarCad;
    @FXML
    private Button btnVoltarTelaLogin;
    
    @FXML
    private TextField nomeInput, emailInput, estadoInput, cidadeInput, ruaInput, numeroDaCasaInput, cepInput;
    @FXML
    private PasswordField senhaInput;
    @FXML
    private GridPane TelaLogin;
    
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
    public void confirmarCadastro(ActionEvent event) throws IOException {
    	String nome = nomeInput.getText();
        String password = senhaInput.getText();
        String email = emailInput.getText();
        String estado = estadoInput.getText();
        String cidade = cidadeInput.getText();
        String rua = ruaInput.getText();
        String numero = numeroDaCasaInput.getText();
        String cep = cepInput.getText();
        
        try {
        	UsuarioController.getInstancia().cadastrarUsuario(new Cliente(nome, email, password, new Endereco(rua, numero, cidade, estado, cep)));	
        	Alert alert = new Alert(AlertType.CONFIRMATION);
    	    alert.setTitle("Cadastro Concluído");
    	    alert.setHeaderText("Cadastro realizado com sucesso!");
    	    alert.showAndWait();
    	}
    	catch (OperacaoInvalidaException e) {	
    		Alert alert = new Alert(AlertType.ERROR);
    	    alert.setTitle("Erro de Cadastro");
    	    alert.setHeaderText("Ocorreu um erro durante o cadastro:");
    	    alert.setContentText(e.getMessage());
    	    alert.showAndWait();
    	}
        
        finally{
        	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       	 	scene = new Scene(root);
       	 	stage.setTitle("ATMZ STORE");
       	 	stage.setScene(scene);
       	 	stage.show();
        }
       
    }

    @FXML
    public void confirmarCadastroEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {

            String nome = nomeInput.getText();
            String password = senhaInput.getText();
            String email = emailInput.getText();
            String estado = estadoInput.getText();
            String cidade = cidadeInput.getText();
            String rua = ruaInput.getText();
            String numero = numeroDaCasaInput.getText();
            String cep = cepInput.getText();

            try {
                UsuarioController.getInstancia().cadastrarUsuario(new Cliente(nome, email, password, new Endereco(rua, numero, cidade, estado, cep)));
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Cadastro Concluído");
                alert.setHeaderText("Cadastro realizado com sucesso!");
                alert.showAndWait();
            }
            catch (OperacaoInvalidaException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro de Cadastro");
                alert.setHeaderText("Ocorreu um erro durante o cadastro:");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

            finally {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("ATMZ STORE");
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @FXML
    public void initialize() {
    	permitirApenasNumeros(numeroDaCasaInput);
    	permitirApenasNumeros(cepInput);
    }

    private void permitirApenasNumeros(TextField textField) {
        textField.textProperty().addListener((observable, valorAntigo, valorNovo) -> {
            if (!valorNovo.matches("\\d*")) {
                textField.setText(valorNovo.replaceAll("[^\\d]", ""));
            }
        });
    }




    
}