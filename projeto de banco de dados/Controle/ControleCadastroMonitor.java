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

public class ControleCadastroMonitor {

  ConectaBanco cB = new ConectaBanco();
  private int eventoEscolhido;

  @FXML
  private TextField cpfTextField, nomeTextFIeld;
  
  @FXML
  private MenuButton eventMenuButton;

  @FXML
  void cadastrarMonitorButton(ActionEvent event) {
    try{
      String nome = nomeTextFIeld.getText().toString();
      long cpf = Long.parseLong(cpfTextField.getText().toString());
      String nomeDoEvento = eventMenuButton.getText().toString();

      if (nome.equals("") || String.valueOf(cpf).equals("") || (String.valueOf(cpf).length() != 11)){
        JOptionPane.showMessageDialog(null, "          Error Code: 604\n\nCadastro não foi efetuado. (′⌒`)\nMotivo: Informações incompletas.");
      } else {
        try {
          //Inserir no bd
          String query = "INSERT INTO iaeventos.monitor (nome, cpf, nome_evento) VALUES ('"+nome+"', '"+cpf+"', '"+nomeDoEvento+"')";
          ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
          operacao.close();
        } catch (SQLException e) {
          System.out.println("SQLException: " + e.getMessage());
        }
        nomeTextFIeld.setText("");
        cpfTextField.setText("");
        eventMenuButton.setText("Selecionar Evento");
        Principal.changeScreenOrganizadorOrganizarEventos(event);
      }
    } catch (NumberFormatException  nFE) {
      cpfTextField.setText("");
      cpfTextField.setPromptText("Digite somente números");
    }
  }

  @FXML
  void voltarButton(ActionEvent event) {
    nomeTextFIeld.setText("");
    cpfTextField.setText("");
    eventMenuButton.setText("Selecionar Evento");
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

  @FXML
  void eventOnActionMenuButton(MouseEvent event) {
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
          eventMenuButton.setText(apenasNome.get(eventoEscolhido).toString());
        } else {
          eventMenuButton.setText("Selecionar Evento");
        }
      } catch (Exception e) {
        System.out.println("Exception no cadastro monitor: " + e.getMessage());
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }
  }
}
