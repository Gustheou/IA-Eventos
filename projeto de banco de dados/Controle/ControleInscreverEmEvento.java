package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControleInscreverEmEvento {

  @FXML
  private TextField cpfTextField, nomeTextFIeld;

  @FXML
  private MenuButton eventMenuBar;

  @FXML
  void eventOnActionMenuBar(ActionEvent event) {

  }

  @FXML
  void inscreverButton(MouseEvent event) {

  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenSelectYourSideOuvinte(event);
  }

}
