package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent; 
import Visao.Principal;

public class ControleLogin {

  @FXML
  private TextField cpfTextField;

  @FXML
  private PasswordField passwordTextField;

  @FXML
  void entrarButton(ActionEvent event) {
    //Verificar se já tem cadastro
    //Caso tenha, verificar se já foi selecionado a função dele (ouvinte/organizador)
    //Se sim, mudar para a tela específica, senão:
    Principal.changeScreenLoginSelectYourSide(event);
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
