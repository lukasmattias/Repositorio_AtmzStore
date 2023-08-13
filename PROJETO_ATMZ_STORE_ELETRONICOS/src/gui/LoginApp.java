package gui;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tela de Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Usu�rio:");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Digite seu usu�rio");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Senha:");
        GridPane.setConstraints(passLabel, 0, 1);

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Digite sua senha");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        loginButton.setOnAction(e -> {
            String username = nameInput.getText();
            String password = passInput.getText();
            if (isValidCredentials(username, password)) {
                // Implementar l�gica para exibir pr�xima tela ou realizar a��o de login bem-sucedido
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Credenciais inv�lidas. Tente novamente.");
            }
        });

        Scene scene = new Scene(grid, 720, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // M�todo de exemplo para validar as credenciais (substitua por sua pr�pria l�gica)
    private boolean isValidCredentials(String username, String password) {
        // Aqui voc� pode implementar a l�gica de verifica��o das credenciais
        // Por exemplo, verificar em um banco de dados ou em algum outro sistema
        return username.equals("usuario") && password.equals("senha");
    }
}

