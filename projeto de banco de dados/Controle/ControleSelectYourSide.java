package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.ConectaBanco;
import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ControleSelectYourSide {

  ConectaBanco cB = new ConectaBanco();

  @FXML
  private RadioButton organizadorRadioButton, ouvinteRadioButton;

  @FXML
  private ToggleGroup sideRadioButton;

  @FXML
  void prosseguirButton(ActionEvent event) {
    if (organizadorRadioButton.isSelected()){
      //Setar no bd o que foi selecionado
      try {
        //Inserir no bd
        String query = "update iaeventos.usuarios set cargo = 'Organizador' where cpf = '"+Principal.cpf+"'";
        ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
      Principal.changeScreenSelectYourSideOrganizador(event);
    }else if (ouvinteRadioButton.isSelected()){
      //Setar no bd o que foi selecionado
      try {
        //Inserir no bd
        String query = "update iaeventos.usuarios set cargo = 'Ouvinte' where cpf = '"+Principal.cpf+"'";
        ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }

      System.out.println("Numero enviado: "+ Principal.cpf);
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
