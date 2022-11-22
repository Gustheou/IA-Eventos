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
    String senhaDigitada = novaSenhaTextField.getText().toString();
    String senhaConfirmacao = confirmarSenhaTextField.getText().toString();
    if (senhaDigitada.equals(senhaConfirmacao)){
      try {
        //Inserir no bd
        long cpfDigitado = Long.parseLong(cpfTextField.getText().toString());
        String query = "UPDATE iaeventos.usuarios SET password = '"+novaSenhaTextField.getText().toString()+"' WHERE cpf = '"+cpfDigitado+"'";
        ResultSet operacao = cB.conectar().createStatement().executeQuery(query);
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
      cpfTextField.setText("");
      novaSenhaTextField.setText("");
      confirmarSenhaTextField.setText("");  
      Principal.changeScreenLogin(event);
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
        operacao.close();
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
      cpfTextField.setText("");
      novaSenhaTextField.setText("");
      confirmarSenhaTextField.setText("");  
      Principal.changeScreenLogin(event);
    } else {
      novaSenhaTextField.setText("");
      confirmarSenhaTextField.setText("");
      JOptionPane.showMessageDialog(null, "Você digitou senhas diferentes");
    }
  }

  @FXML
  void voltarImageButton(MouseEvent event) {
    cpfTextField.setText("");
    novaSenhaTextField.setText("");
    confirmarSenhaTextField.setText("");  
    Principal.changeScreenLogin(event);
  }

  @FXML
  void voltarLabelButton(MouseEvent event) {
    cpfTextField.setText("");
    novaSenhaTextField.setText("");
    confirmarSenhaTextField.setText(""); 
    Principal.changeScreenLogin(event);
  }
}
