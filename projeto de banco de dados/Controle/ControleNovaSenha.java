package Controle;

import Visao.Principal;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ControleNovaSenha {

  @FXML
  private TextField confirmarSenhaTextField;

  @FXML
  private TextField novaSenhaTextField;

  @FXML
  private TextField novaSenhaUsuarioTextField;

  @FXML
  private VBox vboxDados;

  @FXML
  void prosseguirImageButton(MouseEvent event) {
    //Cadastrar e voltar para o login
    Principal.changeScreenLogin(event);
  }

  @FXML
  void prosseguirLabelButton(MouseEvent event) {
    //Cadastrar e voltar para o login
    Principal.changeScreenLogin(event);
  }

  @FXML
  void voltarImageButton(MouseEvent event) {
    Principal.changeScreenLogin(event);
  }

  @FXML
  void voltarLabelButton(MouseEvent event) {
    Principal.changeScreenLogin(event);
  }

}
