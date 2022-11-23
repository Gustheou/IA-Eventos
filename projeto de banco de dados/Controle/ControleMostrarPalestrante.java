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

public class ControleMostrarPalestrante {

  ConectaBanco cB = new ConectaBanco();

  @FXML
  private GridPane nomeDosPalestrantesGridPane;

  @FXML
  void mostrarPalestrante(ActionEvent event) {
    ArrayList apenasNome = new ArrayList<>();
    ArrayList dados = new ArrayList<>();
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.palestrante";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      while (operacao.next()){
  
        apenasNome.add(operacao.getString("nome"));//Usar esse array para exibir tanto no menuButton quanto inserir no bd

        String nomeDoPalestrante = operacao.getString("nome");
        String cpf = "CPF: "; 
        cpf += operacao.getString("cpf");
        String nome_evento = "Evento: ";
        nome_evento += operacao.getString("nome_evento");
        String tema = "Tema: ";
        tema += operacao.getString("tema");

        String dadosReferenteAoEvento = nomeDoPalestrante+"\n"+cpf+"\n"+nome_evento+"\n"+tema;
        dados.add(dadosReferenteAoEvento);
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }

    for (int i = 0; i < apenasNome.size(); i++) {
      Label nomeDoPalestranteLabel = new Label();
      nomeDoPalestranteLabel.setText(apenasNome.get(i).toString());
      nomeDosPalestrantesGridPane.add(nomeDoPalestranteLabel, 0, i);

      EventHandler<MouseEvent> actionNamesClickable = nc -> {
        nomeDoPalestranteLabel.requestFocus();
        int index = nomeDosPalestrantesGridPane.getRowIndex(nomeDoPalestranteLabel);
        JOptionPane.showMessageDialog(null, "Palestrante: \n"+dados.get(index));
      };
      nomeDoPalestranteLabel.setOnMouseClicked(actionNamesClickable);
    }
  }

  @FXML
  void okButton(ActionEvent event) {
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

}
