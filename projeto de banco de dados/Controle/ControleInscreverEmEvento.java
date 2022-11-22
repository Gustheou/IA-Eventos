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

public class ControleInscreverEmEvento {

  @FXML
  private TextField cpfTextField, nomeTextFIeld;

  @FXML
  private MenuButton eventMenuBar;

  ConectaBanco cB = new ConectaBanco();
  private int eventoEscolhido;

  ArrayList nomeDosEventos = new ArrayList<>();
  ArrayList apenasNome = new ArrayList<>();

  @FXML
  void eventOnActionMenuBar(MouseEvent event) {
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.eventos";
      ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
      int i = 0;
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
          eventMenuBar.setText(apenasNome.get(eventoEscolhido).toString());
        } else {
          eventMenuBar.setText("Selecionar Evento");
        }
      } catch (Exception e) {
        System.out.println("Exception no cadastro palestrante: " + e.getMessage());
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }
  }

  @FXML
  void inscreverButton(MouseEvent event) {
    try {
      String nome = nomeTextFIeld.getText().toString();
      String nomeDoEvento = apenasNome.get(eventoEscolhido).toString();
      long cpf = Long.parseLong(cpfTextField.getText().toString());
  
      if (nome.equals("") || String.valueOf(cpf).equals("") || (String.valueOf(cpf).length() != 11) || nomeDoEvento.equals("Selecionar Evento")){
        JOptionPane.showMessageDialog(null, "          Error Code: 604\n\nCadastro não foi efetuado. (′⌒`)\nMotivo: Informações incompletas.");
      } else {
        try {
          //Inserir no bd
          String query = "INSERT INTO iaeventos.inscrevernoevento (nome, cpf, nome_evento) VALUES ('"+nome+"', '"+cpf+"', '"+nomeDoEvento+"')";
          ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
          operacao.close();
        } catch (SQLException e) {
          System.out.println("SQLException: " + e.getMessage());
        }
        nomeTextFIeld.setText("");
        cpfTextField.setText("");
        eventMenuBar.setText("Selecionar Evento");
        Principal.changeScreenSelectYourSideOuvinte(event);
      }
    } catch (NumberFormatException  nFE) {
      cpfTextField.setText("");
      cpfTextField.setPromptText("Digite somente números");
    }
  }

  @FXML
  void voltarButton(ActionEvent event) {
    Principal.changeScreenSelectYourSideOuvinte(event);
  }

}
