package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleMostrarEventos {

  @FXML
  void okButton(ActionEvent event) {
    Principal.changeScreenLogin(event);
  }
}
