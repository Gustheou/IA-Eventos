package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class ControleCadastroMonitor {

  @FXML
  private TextField cpfTextField, nomeTextFIeld;
  
  @FXML
  private MenuButton eventMenuButton;

  @FXML
  void cadastrarMonitorButton(ActionEvent event) {

  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

  @FXML
  void eventOnActionMenuButton(ActionEvent event) {

  }
}
