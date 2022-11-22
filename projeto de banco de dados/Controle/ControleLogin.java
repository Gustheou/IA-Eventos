package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.ConectaBanco;
import Visao.Principal;

public class ControleLogin {

  @FXML
  private TextField cpfTextField;

  @FXML
  private PasswordField passwordTextField;

  ConectaBanco cB = new ConectaBanco();

  @FXML
  void entrarButton(ActionEvent event) {
    Long cpfDigitado = Long.parseLong(cpfTextField.getText().toString());
    String passwordDigitada = passwordTextField.getText().toString();
    try {
      //Inserir no bd
      String query = "SELECT nome FROM iaeventos.usuarios where cpf = '"+cpfDigitado+"' AND password = '"+passwordDigitada+"'";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      if (operacao.next()){
        JOptionPane.showMessageDialog(null, "Seja bem vindo: "+ operacao.getString("nome"));
        ControleSelectYourSide csY = new ControleSelectYourSide(10);
        csY.setCpf(10);
        Principal.changeScreenLoginSelectYourSide(event);
      } else {
        JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }
    //Verificar se já tem cadastro
    //Caso tenha, verificar se já foi selecionado a função dele (ouvinte/organizador)
    //Se sim, mudar para a tela específica, senão:
  }

  @FXML
  void esqueciSenhaButton(MouseEvent event) {
    Principal.changeScreenLoginEsqueceuSenha(event);
  }

  @FXML
  void eventosImageButton(MouseEvent event) {

  }

  @FXML
  void mostrarEventosButton(ActionEvent event) {
    Principal.changeScreenLoginMostrarEventos(event);
  }

  @FXML
  void novoUsuarioButton(MouseEvent event) {
    Principal.changeScreenLoginCadastroUsuario(event);
  }

}
