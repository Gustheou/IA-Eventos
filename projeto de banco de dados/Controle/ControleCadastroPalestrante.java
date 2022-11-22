package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Banco.ConectaBanco;
import Visao.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControleCadastroPalestrante {

  ConectaBanco cB = new ConectaBanco();

  @FXML
  private TextField cpfTextField, nomeTextFIeld, temaTextFIeld;

  @FXML
  private MenuButton eventosMenuButton;

  private int eventoEscolhido;

  @FXML
  void cadastrarPalestranteButton(ActionEvent event) {
    String nome = nomeTextFIeld.getText().toString();
    //Vai ser uma nova tabela?
  }

  @FXML
  void voltarButton(ActionEvent event) {
    cpfTextField.setText("");
    nomeTextFIeld.setText("");
    temaTextFIeld.setText("");
    eventosMenuButton.setText("Selecionar Evento");
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

  @FXML
  void eventosActionMenuButton(MouseEvent event) {
    //Plano A: Quando clicar no menu button, adicionar como menuitem o nome dos eventos
    //Segue o plano B, pois não ocorreu êxito com os menuitem
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.eventos";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      int i = 0;
      ArrayList nomeDosEventos = new ArrayList<>();
      ArrayList apenasNome = new ArrayList<>();
      String nome;
      while (operacao.next()){
        nome = "[" + (i+1) +"] - "; 
        nome += operacao.getString("nome");
        nomeDosEventos.add(nome);
        apenasNome.add(operacao.getString("nome"));//Usar esse array para exibir tanto no menuButton quanto inserir no bd
        i++;
      }
      String escolha = "";
      for (int z = 0; z < nomeDosEventos.size(); z++){
        escolha += nomeDosEventos.get(z).toString();
        escolha += "\n";
      }
      try {
        eventoEscolhido = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um evento:: \n" + escolha));
        eventoEscolhido -=1;
        if (eventoEscolhido >= 0 && eventoEscolhido < nomeDosEventos.size()){
          eventosMenuButton.setText(apenasNome.get(eventoEscolhido).toString());
        } else {
          eventosMenuButton.setText("Selecionar Evento");
        }
      } catch (Exception e) {
        System.out.println("Exception no cadastro palestrante: " + e.getMessage());
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }
  }
}
