package gui;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.ProdutoController;
import negocio.UsuarioController;
import negocio.beans.Cliente;
import negocio.beans.Produto;

public class AdmProdutoController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TableView<Produto> TabelaProdutos;

    @FXML
    private TableColumn<Produto, Integer> AdmProdutosID;

    @FXML
    private TableColumn<Produto, String> AdmProdutosNome;

    @FXML
    private Button btnVoltarLogin;

    @FXML
    private Button btnAdmProdutoAdicionar;

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

    public void initialize() {
        AdmProdutosID.setCellValueFactory(new PropertyValueFactory<>("id"));
        AdmProdutosNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TabelaProdutos.getItems().addAll(ProdutoController.getInstancia().listarProdutos());

        TabelaProdutos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Produto produtoSelecionado = TabelaProdutos.getSelectionModel().getSelectedItem();
                if (produtoSelecionado != null) {
                    lblAdmProdutoID.setText(String.valueOf(produtoSelecionado.getId()));
                    lblAdmProdutoNome.setText(produtoSelecionado.getNome());
                    lblAdmProdutoDescricao.setText(produtoSelecionado.getDescricao());

                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                    String precoFormatado = decimalFormat.format(produtoSelecionado.getPreco());
                    lblAdmProdutoPreco.setText(precoFormatado);

                    lblAdmProdutoEstoque.setText(String.valueOf(produtoSelecionado.getEstoque()));

                    if (produtoSelecionado.getCategoria() != null) {
                        lblAdmProdutoCategoria.setText(produtoSelecionado.getCategoria().getNome());
                    } else {
                        lblAdmProdutoCategoria.setText("");
                    }
                } else {
                    lblAdmProdutoID.setText("");
                    lblAdmProdutoNome.setText("");
                    lblAdmProdutoDescricao.setText("");
                    lblAdmProdutoPreco.setText("");
                    lblAdmProdutoEstoque.setText("");
                    lblAdmProdutoCategoria.setText("");
                }

            }
        });
    }

    @FXML
    public void VoltarLogin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE ");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void AbrirTelaAdicionarProduto(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdmProdutoAdicionar.fxml")));
        Stage newStage = new Stage();
        Scene newScene = new Scene(root);
        newStage.setTitle("ADICIONAR PRODUTO");
        newStage.setScene(newScene);
        newStage.showAndWait();
    }

    @FXML
    void removerProduto(ActionEvent event) {
        if(!lblAdmProdutoID.getText().isBlank()) {
            ProdutoController.getInstancia().removerProduto(ProdutoController.getInstancia().buscarProdutoPorId(Integer.parseInt(lblAdmProdutoID.getText())));
            if( ProdutoController.getInstancia().buscarProdutoPorId(Integer.parseInt(lblAdmProdutoID.getText())) == null) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Remoção Produto");
                alert.setHeaderText("Produto removido com sucesso");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Remoção Produto");
                alert.setHeaderText("Falha na remoção do Produto!");
                alert.showAndWait();
            }
        }

    }


}
