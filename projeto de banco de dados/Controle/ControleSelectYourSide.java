package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ControleSelectYourSide {

  @FXML
  private RadioButton organizadorRadioButton;

  @FXML
  private RadioButton ouvinteRadioButton;

  @FXML
  private ToggleGroup sideRadioButton;

  @FXML
  void prosseguirButton(ActionEvent event) {
    if (organizadorRadioButton.isSelected()){
      //Setar no bd o que foi selecionado
      Principal.changeScreenSelectYourSideOrganizador(event);
    }else if (ouvinteRadioButton.isSelected()){
      //Setar no bd o que foi selecionado
      Principal.changeScreenSelectYourSideOuvinte(event);
    }
  }

  @FXML
  void souOrganizadorImage(MouseEvent event) {
    organizadorRadioButton.setSelected(true);
  }

  @FXML
  void souOuvinteImage(MouseEvent event) {
    ouvinteRadioButton.setSelected(true);
  }

}
