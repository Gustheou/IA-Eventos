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

public class ControleMostrarAtividades {

  ConectaBanco cB = new ConectaBanco();

  @FXML
  private GridPane nomeDasAtividadesGridPane;

  @FXML
  void mostrarAtividades(ActionEvent event) {
    ArrayList apenasNome = new ArrayList<>();
    ArrayList dados = new ArrayList<>();
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.atividades";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      while (operacao.next()){
  
        apenasNome.add(operacao.getString("tema"));//Usar esse array para exibir tanto no menuButton quanto inserir no bd

        String nomeDasAtividades = operacao.getString("tema");
        String tipo = "Tipo: "; 
        tipo += operacao.getString("atividade");
        String nome_palestrante = "Palestrante: ";
        nome_palestrante += operacao.getString("palestrante");
        String nome_evento = "Evento: ";
        nome_evento += operacao.getString("evento");
        String descricao = "Descrição: ";
        descricao += operacao.getString("descricao");

        String dadosReferenteAoEvento = nomeDasAtividades+"\n"+tipo+"\n"+nome_palestrante+"\n"+nome_evento+"\n"+descricao;
        dados.add(dadosReferenteAoEvento);
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }

    for (int i = 0; i < apenasNome.size(); i++) {
      Label nomeDasAtividadesLabel = new Label();
      nomeDasAtividadesLabel.setText(apenasNome.get(i).toString());
      nomeDasAtividadesGridPane.add(nomeDasAtividadesLabel, 0, i);

      EventHandler<MouseEvent> actionNamesClickable = nc -> {
        nomeDasAtividadesLabel.requestFocus();
        int index = nomeDasAtividadesGridPane.getRowIndex(nomeDasAtividadesLabel);
        JOptionPane.showMessageDialog(null, "Atividades: \n"+dados.get(index));
      };
      nomeDasAtividadesLabel.setOnMouseClicked(actionNamesClickable);
    }
  }

  @FXML
  void okButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

}
