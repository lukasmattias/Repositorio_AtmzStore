package gui;

import java.io.IOException;
import java.util.List;

import exception.AtributosNulosException;
import exception.OperacaoInvalidaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.CarrinhoDeComprasController;
import negocio.PedidoController;
import negocio.ProdutoController;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Produto;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarrinhoController {
    private Stage stage;
    private Scene scene;


    @FXML
    private Label CarrinhoSubTotal;

    @FXML
    private Button btnCarrinhoVolta;

    @FXML
    private Button btnRealizarPedido;

    @FXML
    private Button btnHistoricoCompras;
    
    @FXML
	 private TableView<Item> tableView;
	@FXML
	private TableColumn<Item, Void> colAcao;
	@FXML
	private TableColumn<Item, Produto> colProduto;
	@FXML
	private TableColumn<Item, Integer> colQuantidade;
	@FXML
	private Label carrinhoSubTotal;
	
    @FXML
    void IrParaTelaPagamento(ActionEvent event) throws IOException{  
        try {
    		Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
    		PedidoController.getInstancia().criarPedido(c);
    		c.getCarrinho().getItens().clear();
    		Parent root = FXMLLoader.load(getClass().getResource("Pagamento.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("ATMZ STORE PAGAMENTO");
            stage.setScene(scene);
            
            stage.show();
    	}
    	catch (OperacaoInvalidaException e ) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pedido nao realizado");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
    	}
        catch (AtributosNulosException a) {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pedido nao realizado");
            alert.setHeaderText(a.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    void VoltarProdutos(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Produtos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE PRODUTOS");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void IrHistoricoCompras (ActionEvent event) throws IOException{
    	
        Parent root = FXMLLoader.load(getClass().getResource("ClienteHistoricoCompras.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE COMPRAS");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void initialize() {
    	
        colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colProduto.setCellFactory(column -> new TableCell<Item, Produto>() {
            @Override
            protected void updateItem(Produto produto, boolean empty) {
                super.updateItem(produto, empty);
                
                if (empty || produto == null) {
                    setText(null);
                } else {
                	VBox vbox = new VBox();
                	Label idLabel = new Label("ID: " + produto.getId());
                    Label nomeLabel = new Label("Nome: " + produto.getNome());
                    Label descricaoLabel = new Label("Descricao: " + produto.getDescricao());
                    Label precoLabel = new Label("Preco: " + produto.getPreco());
                    vbox.getChildren().addAll(idLabel, nomeLabel, descricaoLabel, precoLabel);
                    Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
                    carrinhoSubTotal.setText("R$" + CarrinhoDeComprasController.getInstancia().calcularTotal(c.getCarrinho()));
                    setGraphic(vbox);
                }
            }
        });
        colAcao.setCellFactory(column -> new TableCell<Item, Void>() {
        	final Button button1 = new Button("+");
            Spinner<Integer> spinner = new Spinner<>(1, 500, 0);
            
            final Button button = new Button("-");
            Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
            
            {
               button1.setOnAction(event -> {
            	Produto p = getTableView().getItems().get(getIndex()).getProduto();
            	try {
            	CarrinhoDeComprasController.getInstancia().adicionarProdutoNoCarrinho(c.getCarrinho(), p, spinner.getValue());
            	}
               	catch (OperacaoInvalidaException e) {
               		Alert alert = new Alert(Alert.AlertType.ERROR);
    	            alert.setTitle("Operacao Invalida");
    	            alert.setHeaderText(e.getMessage());
    	            alert.showAndWait();
               	}
                   
                   tableView.refresh();
               });  
            	
            	spinner.valueProperty().addListener((observable, valorAnterior, novoValor) -> {
                    if (!isEmpty()) {
                        Item itemProduto = getTableView().getItems().get(getIndex());
                        if (novoValor > itemProduto.getQuantidade()) {
                            spinner.getValueFactory().setValue(itemProduto.getQuantidade());
                        }
                    }
                });
                button.setOnAction(event -> {
                	
                	Produto p = getTableView().getItems().get(getIndex()).getProduto();
                	CarrinhoDeComprasController.getInstancia().removerProdutoDoCarrinho(c.getCarrinho(), p, spinner.getValue());
                    if (!c.getCarrinho().getItens().contains(getTableView().getItems().get(getIndex()))) {
                		tableView.getItems().remove(getTableView().getItems().get(getIndex()));
                		carrinhoSubTotal.setText("R$" + CarrinhoDeComprasController.getInstancia().calcularTotal(c.getCarrinho()));
                	}
                    tableView.refresh();
                });      
            }

            @Override
            protected void updateItem(Void item, boolean vazio) {
                super.updateItem(item, vazio);
                if (vazio) {
                    setGraphic(null);
                } else {
                    HBox spcombotao = new HBox(button1, spinner, button);
                    spcombotao.setSpacing(3);
                    setGraphic(spcombotao);
                }
            }
        });
        
        Cliente c = (Cliente)SessionController.getInstance().getUsuarioLogado();
        tableView.getItems().addAll(c.getCarrinho().getItens());
    }
}