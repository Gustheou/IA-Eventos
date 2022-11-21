package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.ConectaBanco;
import Visao.Principal;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ControleNovaSenha {

  @FXML
  private TextField confirmarSenhaTextField;

  @FXML
  private TextField novaSenhaTextField;

  @FXML
  private TextField cpfTextField;

  @FXML
  private VBox vboxDados;

  ConectaBanco cB = new ConectaBanco();

  @FXML
  void prosseguirImageButton(MouseEvent event) {
    //Cadastrar e voltar para o login
    // String senhaDigitada = novaSenhaTextField.getText().toString();
    // String senhaConfirmacao = confirmarSenhaTextField.getText().toString();
    // if (senhaDigitada.equals(senhaConfirmacao)){
    //   if (verificacao()){
    //     Principal.changeScreenLogin(event);
    //   }
    // } else {
    //   confirmarSenhaTextField.setText("");
    //   confirmarSenhaTextField.setPromptText("Senha não condizente");
    // }
    String senhaDigitada = novaSenhaTextField.getText().toString();
    String senhaConfirmacao = confirmarSenhaTextField.getText().toString();
    if (senhaDigitada.equals(senhaConfirmacao)){
      try {
        //Inserir no bd
        long cpfDigitado = Long.parseLong(cpfTextField.getText().toString());
        String query = "UPDATE iaeventos.usuarios SET password = '"+novaSenhaTextField.getText().toString()+"' WHERE cpf = '"+cpfDigitado+"'";
        ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
        if (operacao.next()){
          JOptionPane.showMessageDialog(null, "Senha modificada com sucesso");
          Principal.changeScreenLoginSelectYourSide(event);
        } else {
          cpfTextField.setText("");
          novaSenhaTextField.setText("");
          confirmarSenhaTextField.setText(""); 
          JOptionPane.showMessageDialog(null,"Usuário não encontrado.");
        }
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
    } else {
      novaSenhaTextField.setText("");
      confirmarSenhaTextField.setText("");
      JOptionPane.showMessageDialog(null, "Você digitou senhas diferentes");
    }
  }

  @FXML
  void prosseguirLabelButton(MouseEvent event) {
    String senhaDigitada = novaSenhaTextField.getText().toString();
    String senhaConfirmacao = confirmarSenhaTextField.getText().toString();
    if (senhaDigitada.equals(senhaConfirmacao)){
      try {
        //Inserir no bd
        long cpfDigitado = Long.parseLong(cpfTextField.getText().toString());
        String query = "UPDATE iaeventos.usuarios SET password = '"+novaSenhaTextField.getText().toString()+"' WHERE cpf = '"+cpfDigitado+"'";
        ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
        if (operacao.next()){
          JOptionPane.showMessageDialog(null, "Senha modificada com sucesso");
          Principal.changeScreenLoginSelectYourSide(event);
        } 
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
    } else {
      novaSenhaTextField.setText("");
      confirmarSenhaTextField.setText("");
      JOptionPane.showMessageDialog(null, "Você digitou senhas diferentes");
    }
  }

  @FXML
  void voltarImageButton(MouseEvent event) {
    Principal.changeScreenLogin(event);
  }

  @FXML
  void voltarLabelButton(MouseEvent event) {
    Principal.changeScreenLogin(event);
  }

  public boolean verificacao(){
    
    return false;
  }
}
