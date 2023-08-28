package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.CarrinhoDeComprasController;
import negocio.PedidoController;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.PagamentoPix;
import negocio.beans.Pedido;
import negocio.beans.Produto;
import negocio.beans.Status;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


public class ClienteComprasController {

    private Stage stage;
    private Scene scene;
    
    @FXML
    private Button btnVoltarCarrinho;
    @FXML
    private TableView<Pedido> tableViewPedidos;
    @FXML
    private TableColumn<Pedido, Integer> colPedidoID;
    @FXML
    private TableColumn<Pedido, LocalDateTime> colPedidoDataHora;
    @FXML
    private TableColumn<Pedido, Cliente> colPedidoCliente;
    @FXML
    private TableColumn<Pedido, Status> colPedidoStatus;
    @FXML
    private Label totalPedido;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab detItens;
    @FXML
    private Tab detPagamento;
    @FXML
    private Tab detEntrega;
    @FXML
    private TableView<Item> tableViewItens;
    @FXML
    private TableView<Pedido> tableViewPagamento;
    @FXML
    private TableView<Pedido> tableViewEntrega;
    @FXML
    private TableColumn<Item, String> itemColumn;
    @FXML
    private TableColumn<Item, String> subTotalColumn;
    @FXML
    private TableColumn<Pedido, String> pagamentoColumn;
    @FXML
    private  TableColumn<Pedido, String> destinatarioColumn;
    
    
    @FXML
    void VoltarCarrinho(ActionEvent event)  throws IOException {
    	if (SessionController.getInstance().getUsuarioLogado() instanceof Cliente) {
    	Parent root = FXMLLoader.load(getClass().getResource("Carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE");
        stage.setScene(scene);
        stage.show();	
    	}
    	else {
    		Parent root = FXMLLoader.load(getClass().getResource("Adm.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Tela de Inicio do Administrador");
            stage.setScene(scene);
            stage.show();
    	}
    }
    
    @FXML
    void initialize() {
    	totalPedido.setText("R$ 0.00");
    	Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
    	PedidoController.getInstancia().cancelarPedidosNaoPagosDoCliente(c);
    	
    	if (SessionController.getInstance().getUsuarioLogado() instanceof Cliente) {
    	    List<Pedido> pedidosDoCliente = PedidoController.getInstancia().listarPedidosPorCliente(c);
    	    tableViewPedidos.getItems().addAll(pedidosDoCliente);
    	    colPedidoCliente.setVisible(false);
    	} else {
    	    tableViewPedidos.getItems().addAll(PedidoController.getInstancia().listarPedidos());
    	}
        colPedidoID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPedidoDataHora.setCellValueFactory(new PropertyValueFactory<>("data"));
        colPedidoStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colPedidoStatus.setCellFactory(column -> new TableCell<Pedido, Status>() {
            @Override
            protected void updateItem(Status statusDePagamento, boolean empty) {
                super.updateItem(statusDePagamento, empty);
                
                if (statusDePagamento == null || empty) {
                    setText(null);
                } else {
                    setText(statusDePagamento.getDescricao());
                }
            }
        });
        
        colPedidoCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colPedidoCliente.setCellFactory(column -> new TableCell<Pedido, Cliente>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);

                if (empty || cliente == null) {
                    setText(null);
                } else {
                    VBox vbox = new VBox();
                    Label idLabel = new Label("ID: " + cliente.getId());
                    Label nomeLabel = new Label("Nome: " + cliente.getNome());
                    Label emailLabel = new Label("Email: " + cliente.getEmail());
                    vbox.getChildren().addAll(idLabel, nomeLabel, emailLabel);
                    setGraphic(vbox);
                }
            }
        });
 
        tableViewPedidos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Pedido pedidoSelecionado = tableViewPedidos.getSelectionModel().getSelectedItem();
                if (pedidoSelecionado != null) {
                	exibirDetalhesItens(pedidoSelecionado);
                    exibirDetalhesPagamento(pedidoSelecionado);
                    exibirDetalhesEntrega(pedidoSelecionado);
                    totalPedido.setText("R$" + pedidoSelecionado.getValorItens());
                }
            }
        });
        tabPane.getTabs().addAll(detItens, detPagamento, detEntrega); 
    }
    
    private void exibirDetalhesItens(Pedido pedido) {
    	tableViewItens.getItems().clear();
        itemColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
        subTotalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getSubtotal())));
        tableViewItens.getItems().addAll(pedido.getItens());
        detItens.setContent(tableViewItens);
    }
    
    private void exibirDetalhesPagamento(Pedido pedido) {
    	String formaDePagamento = "Pedido cancelado.";
        if (pedido.getPagamento() instanceof CartaoDeCredito) {
            formaDePagamento = "Cartao de Credito";
        } else if (pedido.getPagamento() instanceof PagamentoPix) {
            formaDePagamento = "Pix";
        }
        pagamentoColumn.setText(formaDePagamento);
    	tableViewPagamento.getItems().clear();
    	
    	if (pedido.getPagamento() != null) {
    	pagamentoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPagamento().toString()));
    	}
    	else {
   		 pagamentoColumn.setCellValueFactory(cellData -> new SimpleStringProperty("Pagamento não realizado."));
	
    	}
        tableViewPagamento.getItems().add(pedido);
        detPagamento.setContent(tableViewPagamento);
    }

    private void exibirDetalhesEntrega(Pedido pedido) {
    	tableViewEntrega.getItems().clear();
        destinatarioColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().toString()));
        tableViewEntrega.getItems().add(pedido);
        detEntrega.setContent(tableViewEntrega);
    }
    
    
}

