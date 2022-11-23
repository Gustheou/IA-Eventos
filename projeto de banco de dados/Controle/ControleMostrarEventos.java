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

public class ControleMostrarEventos {


  @FXML
  private GridPane nomeDosEventosGridPane;

  ConectaBanco cB = new ConectaBanco();

  @FXML
  void mostrarEventos(ActionEvent event) {
    ArrayList apenasNome = new ArrayList<>();
    ArrayList dados = new ArrayList<>();
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.eventos";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      while (operacao.next()){
  
        apenasNome.add(operacao.getString("nome"));//Usar esse array para exibir tanto no menuButton quanto inserir no bd

        String nomeDoEvento = operacao.getString("nome");
        String data_inicial = "Data inicial: ";
        data_inicial += operacao.getString("data_inicial");
        String data_final = "Data final: ";
        data_final += operacao.getString("data_final");
        String hora_inicio = "Início: ";
        hora_inicio += operacao.getString("hora_inicio");
        hora_inicio += "hrs";
        String carga_horaria_total = "Carga horária: ";
        carga_horaria_total += operacao.getString("carga_horaria_total");
        carga_horaria_total += "hrs";
        String local = "Local: ";
        local += operacao.getString("local");

        String dadosReferenteAoEvento = nomeDoEvento+"\n"+data_inicial+"\n"+data_final+"\n"+hora_inicio+"\n"+carga_horaria_total+"\n"+local;
        dados.add(dadosReferenteAoEvento);
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }

    for (int i = 0; i < apenasNome.size(); i++) {
      Label nomeDoEvento = new Label();
      nomeDoEvento.setText(apenasNome.get(i).toString());
      nomeDosEventosGridPane.add(nomeDoEvento, 0, i);

      EventHandler<MouseEvent> actionNamesClickable = nc -> {
        nomeDoEvento.requestFocus();
        int index = nomeDosEventosGridPane.getRowIndex(nomeDoEvento);
        JOptionPane.showMessageDialog(null, "Evento: \n"+dados.get(index));
      };
      nomeDoEvento.setOnMouseClicked(actionNamesClickable);
    }
  }

  @FXML
  void okButton(ActionEvent event) {
    Principal.changeScreenLogin(event);
  }
}
