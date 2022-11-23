package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Banco.ConectaBanco;
import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ControleMostrarMonitor {

  ConectaBanco cB = new ConectaBanco();

  @FXML
  private GridPane nomeDosMonitoresGridPane;

  @FXML
  void mostrarMonitores(ActionEvent event) {
    ArrayList apenasNome = new ArrayList<>();
    ArrayList dados = new ArrayList<>();
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.monitor";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      while (operacao.next()){
  
        apenasNome.add(operacao.getString("nome"));//Usar esse array para exibir tanto no menuButton quanto inserir no bd

        String nomeDoMonitor = operacao.getString("nome");
        String cpf = "CPF: "; 
        cpf += operacao.getString("cpf");
        String nome_evento = "Evento: ";
        nome_evento += operacao.getString("nome_evento");

        String dadosReferenteAoEvento = nomeDoMonitor+"\n"+cpf+"\n"+nome_evento;
        dados.add(dadosReferenteAoEvento);
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }

    for (int i = 0; i < apenasNome.size(); i++) {
      Label nomeDoMonitorLabel = new Label();
      nomeDoMonitorLabel.setText(apenasNome.get(i).toString());
      nomeDosMonitoresGridPane.add(nomeDoMonitorLabel, 0, i);

      EventHandler<MouseEvent> actionNamesClickable = nc -> {
        nomeDoMonitorLabel.requestFocus();
        int index = nomeDosMonitoresGridPane.getRowIndex(nomeDoMonitorLabel);
        JOptionPane.showMessageDialog(null, "Monitor: \n"+dados.get(index));
      };
      nomeDoMonitorLabel.setOnMouseClicked(actionNamesClickable);
    }
  }

  @FXML
  void okButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

}
