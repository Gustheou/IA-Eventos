package Controle;

import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class ControleCadastroAtividades {

  @FXML
  private MenuButton activityMenuBar;

  @FXML
  private TextField cpfTextField, emailTextField, nomeTextFIeld, senhaTextField;

  @FXML
  void activityOnActionMenuBar(ActionEvent event) {

  }

  @FXML
  void cadastrarButton(ActionEvent event) {

  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
    activityMenuBar.setText("Tipo de atividade");
  }

  @FXML
  void minicursoMenuItem(ActionEvent event) {
    activityMenuBar.setText("Minicurso");
  }

  @FXML
  void palestraMenuItem(ActionEvent event) {
    activityMenuBar.setText("Palestra");
  }
}
