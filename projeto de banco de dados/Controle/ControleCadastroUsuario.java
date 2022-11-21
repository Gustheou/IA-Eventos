package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.ConectaBanco;

public class ControleCadastroUsuario {

  @FXML
  private TextField cpfTextField, emailTextField, nomeTextFIeld, senhaTextField;

  ConectaBanco cB = new ConectaBanco();

  @FXML
  void cadastrarUsuarioButton(ActionEvent event) {
    try {
      String nome = nomeTextFIeld.getText().toString();
      String email = emailTextField.getText().toString();
      String senha = senhaTextField.getText().toString();
      long cpf = Long.parseLong(cpfTextField.getText().toString());
  
      if (nome.equals("") || String.valueOf(cpf).equals("") || (String.valueOf(cpf).length() != 11) || String.valueOf(email).equals("") || senha.equals("")){
        JOptionPane.showMessageDialog(null, "          Error Code: 604\n\nCadastro não foi efetuado. (′⌒`)\nMotivo: Informações incompletas.");
      } else {
        try {
          //Inserir no bd
          String query = "INSERT INTO iaeventos.usuarios (nome, cpf, password, email, cargo) VALUES ('"+nome+"', '"+cpf+"', '"+senha+"', '"+email+"', '"+null+"')";
          ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
          operacao.close();
        } catch (SQLException e) {
          System.out.println("SQLException: " + e.getMessage());
        }
        nomeTextFIeld.setText("");
        emailTextField.setText("");
        senhaTextField.setText("");
        cpfTextField.setText("");
        Principal.changeScreenLogin(event);
      }
    } catch (NumberFormatException  nFE) {
      cpfTextField.setText("");
      cpfTextField.setPromptText("Digite somente números");
    }
  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenLogin(event);
  }
}
