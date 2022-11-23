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

public class ControleCadastroAtividades {

  @FXML
  private TextField descricaoTextField, temaTextField;

  @FXML
  private MenuButton activityMenuBar, palestranteMenuButton, eventoMenuButton;

  private int eventoEscolhido, palestranteEscolhido;
  
  ConectaBanco cB = new ConectaBanco();


  @FXML
  void cadastrarButton(ActionEvent event) {
    String tipoDeAtividade = activityMenuBar.getText().toString();
    String nomeDoPalestrante = palestranteMenuButton.getText().toString();
    String nomeDoEvento = eventoMenuButton.getText().toString();
    String tema = temaTextField.getText();
    String descricao = descricaoTextField.getText();

    if (tema.equals("") || descricao.equals("") || tipoDeAtividade.equals("Tipo de Atividade") || nomeDoPalestrante.equals("Selecionar Palestrante") || nomeDoEvento.equals("Selecionar Evento")){
      JOptionPane.showMessageDialog(null, "          Error Code: 604\n\nCadastro não foi efetuado. (′⌒`)\nMotivo: Informações incompletas.");
    } else {
      try {
        //Inserir no bd
        String query = "INSERT INTO iaeventos.atividades (atividade, tema, palestrante, evento, descricao) VALUES ('"+tipoDeAtividade+"', '"+tema+"', '"+nomeDoPalestrante+"', '"+nomeDoEvento+"', '"+descricao+"')";
        ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
        JOptionPane.showMessageDialog(null, "Atividade cadastrada.");
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
      activityMenuBar.setText("Tipo de Atividade");
      palestranteMenuButton.setText("Selecionar Palestrante");
      eventoMenuButton.setText("Selecionar Evento");
      temaTextField.setText("");
      descricaoTextField.setText("");
      Principal.changeScreenOrganizadorOrganizarEventos(event);
    }
  }

  @FXML
  void minicursoMenuItem(ActionEvent event) {
    activityMenuBar.setText("Minicurso");
  }

  @FXML
  void palestraMenuItem(ActionEvent event) {
    activityMenuBar.setText("Palestra");
  }

  @FXML
  void selecionarEventoOnClicked(MouseEvent event) {
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
          eventoMenuButton.setText(apenasNome.get(eventoEscolhido).toString());
        } else {
          eventoMenuButton.setText("Selecionar Evento");
        }
      } catch (Exception e) {
        System.out.println("Exception no cadastro atividades: " + e.getMessage());
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }
  }

  @FXML
  void selecionarPalestranteOnClicked(MouseEvent event) {
    try {
      //Inserir no bd
      String query = "SELECT * FROM iaeventos.palestrante";
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
        palestranteEscolhido = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um evento:: \n" + escolha));
        palestranteEscolhido -=1;
        if (palestranteEscolhido >= 0 && palestranteEscolhido < nomeDosEventos.size()){
          palestranteMenuButton.setText(apenasNome.get(palestranteEscolhido).toString());
        } else {
          palestranteMenuButton.setText("Selecionar Palestrante");
        }
      } catch (Exception e) {
        System.out.println("Exception no cadastro atividades: " + e.getMessage());
      }
      operacao.close();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    }
  }

  @FXML
  void voltarButton(ActionEvent event) {
    activityMenuBar.setText("Tipo de Atividade");
    palestranteMenuButton.setText("Selecionar Palestrante");
    eventoMenuButton.setText("Selecionar Evento");
    temaTextField.setText("");
    descricaoTextField.setText("");
    Principal.changeScreenOrganizadorOrganizarEventos(event);
  }

}
