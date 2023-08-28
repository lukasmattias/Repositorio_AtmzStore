package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import negocio.UsuarioController;
import negocio.beans.Cliente;
import negocio.beans.Usuario;

public class AdmClienteController {
	private Stage stage;
	private Scene scene;

	@FXML
	private Button btnVoltarLogin;

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
	private TableView<Cliente> tabelaCliente;

	@FXML
	private TableColumn<Cliente, Integer> AdmClienteID;

	@FXML
	private TableColumn<Cliente, String> AdmClienteNome;

	public void initialize() {
		AdmClienteID.setCellValueFactory(new PropertyValueFactory<>("id"));
		AdmClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabelaCliente.getItems().addAll(UsuarioController.getInstancia().listarClientes());

		tabelaCliente.setOnMouseClicked(event -> {
			if (event.getClickCount() == 1) {
				Cliente clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
				if (clienteSelecionado != null) {
					lblAlmClienteID.setText(String.valueOf(clienteSelecionado.getId()));
					lblAlmClienteNome.setText(clienteSelecionado.getNome());
					lblAlmClienteEmail.setText(clienteSelecionado.getEmail());
					lblAlmClienteRua.setText(clienteSelecionado.getEndereco().getRua());
					lblAlmClienteEstado.setText(clienteSelecionado.getEndereco().getEstado());
					lblAlmClienteCidade.setText(clienteSelecionado.getEndereco().getCidade());
					lblAlmClienteNumero.setText(String.valueOf(clienteSelecionado.getEndereco().getNumero()));
					lblAlmClienteCep.setText(String.valueOf(clienteSelecionado.getEndereco().getCEP()));
				}
			}
		});
	}

	@FXML
	public void VoltarLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("ATMZ STORE ");
		stage.setScene(scene);
		stage.show();
	}
	
	  @FXML
	    void admClienteRemover(ActionEvent event) {
		  if(!lblAlmClienteEmail.getText().isBlank()) {
			 UsuarioController.getInstancia().removerUsuario(UsuarioController.getInstancia().buscarUsuarioPorEmail(lblAlmClienteEmail.getText()));
			 if(UsuarioController.getInstancia().buscarUsuarioPorEmail(lblAlmClienteEmail.getText()) == null) {
				 Alert alert = new Alert(AlertType.CONFIRMATION);
	             alert.setTitle("Remoção cliente");
	             alert.setHeaderText("Cliente removido com sucesso");
	             alert.showAndWait();
			 }
			 else {
				 Alert alert = new Alert(AlertType.CONFIRMATION);
	             alert.setTitle("Remoção cliente");
	             alert.setHeaderText("Falha na remoção do Cliente!");
	             alert.showAndWait();
			 }
		  }
	    }
	  
}
