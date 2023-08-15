package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    public void loginButtonClicked(MouseEvent mouseEvent) {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        
        if (isValidCredentials(username, password)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
        }
    }

    // Método de exemplo para validar as credenciais (substitua por sua própria lógica)
    private boolean isValidCredentials(String username, String password) {
        return username.equals("usuario") && password.equals("senha");
    }
}
