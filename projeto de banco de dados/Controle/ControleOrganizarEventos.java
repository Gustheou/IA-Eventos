package Controle;

import Visao.Principal;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ControleOrganizarEventos {

  @FXML
  private RadioButton cadastrarRadioButton, exibirRadioButton;

  @FXML
  private ToggleGroup choiceGroup;

  @FXML
  void atividadesImage(MouseEvent event) {
    if (cadastrarRadioButton.isSelected()) {
      Principal.changeScreenOrganizarEventosCadastrarAtividades(event);
      cadastrarRadioButton.setSelected(false);
    } else if (exibirRadioButton.isSelected()) {
      // fazer tela para perguntar qual evento e selecionar as tuplas correspondentes
      exibirRadioButton.setSelected(false);
    }
  }

  @FXML
  void monitorImage(MouseEvent event) {
    if (cadastrarRadioButton.isSelected()) {
      Principal.changeScreenOrganizarEventosCadastrarMonitor(event);
      cadastrarRadioButton.setSelected(false);
    } else if (exibirRadioButton.isSelected()) {
      // fazer tela para perguntar qual evento e selecionar as tuplas correspondentes
      exibirRadioButton.setSelected(false);
    }
  }

  @FXML
  void organizadorImage(MouseEvent event) {
    if (cadastrarRadioButton.isSelected()) {
      Principal.changeScreenOrganizarEventosCadastrarOrganizador(event);
      cadastrarRadioButton.setSelected(false);
    } else if (exibirRadioButton.isSelected()) {
      // fazer tela para perguntar qual evento e selecionar as tuplas correspondentes
      exibirRadioButton.setSelected(false);
    }
  }

  @FXML
  void palestranteImage(MouseEvent event) {
    if (cadastrarRadioButton.isSelected()) {
      Principal.changeScreenOrganizarEventosCadastrarPalestrante(event);
      cadastrarRadioButton.setSelected(false);
    } else if (exibirRadioButton.isSelected()) {
      // fazer tela para perguntar qual evento e selecionar as tuplas correspondentes
      exibirRadioButton.setSelected(false);
    }
  }

}
