package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.ConectaBanco;
import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControleCriarEventos {

  @FXML
  private TextField nomeTextFIeld, diaInicioTextField, mesInicioTextField, anoInicioTextField, horarioTextField;
  @FXML
  private TextField diaTerminoTextField, mesTerminoTextField, anoTerminoTextField, localTextField, cargaHorariaTextField;

  ConectaBanco cB = new ConectaBanco();

  @FXML
  void criarButton(ActionEvent event) {
    //Criar o evento no sgbd
    String dataInicial = anoInicioTextField.getText().toString()+"-"+mesInicioTextField.getText().toString()+"-"+diaInicioTextField.getText().toString();
    String dataFinal = anoTerminoTextField.getText().toString()+"-"+mesTerminoTextField.getText().toString()+"-"+diaTerminoTextField.getText().toString();
    String nomeDoEvento = nomeTextFIeld.getText().toString();
    String horarioInicio = horarioTextField.getText().toString();
    String local = localTextField.getText().toString();
    int cargaHorariaTotal = Integer.parseInt(cargaHorariaTextField.getText().toString());

    try {
      String query = "INSERT INTO iaeventos.eventos (nome, data_inicial, data_final, hora_inicio, carga_horaria_total, local) VALUES ('"+nomeDoEvento+"', '"+dataInicial+"', '"+dataFinal+"', '"+horarioInicio+"', '"+cargaHorariaTotal+"', '"+local+"')";
      ResultSet operacao;
      operacao = cB.conectar().createStatement().executeQuery(query);
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException Criar evento: " + e.getMessage());
    }
    JOptionPane.showMessageDialog(null,"Evento: " + nomeDoEvento+ "\nCadastrado com sucesso!");

    nomeTextFIeld.setText("");
    diaInicioTextField.setText("");
    mesInicioTextField.setText("");
    anoInicioTextField.setText("");
    diaTerminoTextField.setText("");
    mesTerminoTextField.setText("");
    anoTerminoTextField.setText("");
    localTextField.setText("");
    horarioTextField.setText("");
    cargaHorariaTextField.setText("");

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
