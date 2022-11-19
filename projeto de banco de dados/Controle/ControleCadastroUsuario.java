package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControleCadastroUsuario {

  @FXML
  private TextField cpfTextField, emailTextField, nomeTextFIeld, senhaTextField;

  @FXML
  void cadastrarUsuarioButton(ActionEvent event) {
    //Fazer o cadastro e voltar para a tela de login
    Principal.changeScreenLogin(event);
  }

  @FXML
  void cadastrarImageButton(MouseEvent event) {
    //Fazer o cadastro e voltar para a tela de login
    Principal.changeScreenLogin(event);
  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenLogin(event);
  }

  @FXML
  void voltarImageButton(MouseEvent event) {
    Principal.changeScreenLogin(event);
  }
}
