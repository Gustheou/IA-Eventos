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

public class ControleMostrarOrganizador {

  ConectaBanco cB = new ConectaBanco();

  @FXML
  private GridPane nomeDosOrganizadoresGridPane;

  @FXML
  void mostrarMonitores(ActionEvent event) {
    ArrayList apenasNome = new ArrayList<>();
    ArrayList dados = new ArrayList<>();
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.organizador";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      while (operacao.next()){
  
        apenasNome.add(operacao.getString("nome"));//Usar esse array para exibir tanto no menuButton quanto inserir no bd

        String nomeDoOrganizador = operacao.getString("nome");
        String cpf = "CPF: "; 
        cpf += operacao.getString("cpf");
        String nome_evento = "Evento: ";
        nome_evento += operacao.getString("nome_evento");

        String dadosReferenteAoEvento = nomeDoOrganizador+"\n"+cpf+"\n"+nome_evento;
        dados.add(dadosReferenteAoEvento);
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }

    for (int i = 0; i < apenasNome.size(); i++) {
      Label nomeDoOrganizadorLabel = new Label();
      nomeDoOrganizadorLabel.setText(apenasNome.get(i).toString());
      nomeDosOrganizadoresGridPane.add(nomeDoOrganizadorLabel, 0, i);

      EventHandler<MouseEvent> actionNamesClickable = nc -> {
        nomeDoOrganizadorLabel.requestFocus();
        int index = nomeDosOrganizadoresGridPane.getRowIndex(nomeDoOrganizadorLabel);
        JOptionPane.showMessageDialog(null, "Organizador: \n"+dados.get(index));
      };
      nomeDoOrganizadorLabel.setOnMouseClicked(actionNamesClickable);
    }
  }

  @FXML
  void okButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

}
