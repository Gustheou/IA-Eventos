package Controle;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import Visao.Principal;

public class ControlePosLoginOrganizador {

  @FXML
  void criarEventos(MouseEvent event) {
    Principal.changeScreenOrganizadorCriarEventos(event);
  }

  @FXML
  void organizarEventos(MouseEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

}
