package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControleCriarEventos {

  @FXML
  private TextField nomeTextFIeld, diaInicioTextField, mesInicioTextField, anoInicioTextField, horarioTextField;
  @FXML
  private TextField diaTerminoTextField, mesTerminoTextField, anoTerminoTextField, cpfTextField, cargaHorariaTextField;

  @FXML
  void criarButton(ActionEvent event) {
    //Criar o evento no sgbd
    Principal.changeScreenSelectYourSideOrganizador(event);
  }

  @FXML
  void criarImageButton(MouseEvent event) {
    //Criar o evento no sgbd
    Principal.changeScreenSelectYourSideOrganizador(event);
  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenSelectYourSideOrganizador(event);
  }

  @FXML
  void voltarImageButton(MouseEvent event) {
    Principal.changeScreenSelectYourSideOrganizador(event);
  }

}
