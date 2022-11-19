package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class ControleCadastroPalestrante {

  @FXML
  private TextField cpfTextField, nomeTextFIeld, senhaTextField;

  @FXML
  private MenuButton eventosMenuButton;

  @FXML
  void cadastrarPalestranteButton(ActionEvent event) {

  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

  @FXML
  void eventosActionMenuButton(ActionEvent event) {
    //Quando clicar no menu button, adicionar como menuitem o nome dos eventos
  }

}
