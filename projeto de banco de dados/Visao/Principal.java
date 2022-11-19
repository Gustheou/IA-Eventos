package Visao;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Principal extends Application{
  private static Stage stage;
  private static Scene telaLogin;

  private static Scene telaCadastroUsuario;
  private static Scene telaCadastroMonitor;
  private static Scene telaCadastroPalestrante;
  private static Scene telaCadastroOrganizador;

  private static Scene telaCadastrarAtividades;

  private static Scene telaInscreverEmEventos;
  private static Scene telaMostrarEventos;
  private static Scene telaCriarEventos;
  private static Scene telaOrganizarEvento;


  private static Scene telaNovaSenha;
  private static Scene telaPosLoginOrganizador;
  private static Scene telaPosLoginOuvinte;

  private static Scene telaSelectYourSide;


  public static void main (String [] args) {
    launch (args);
  }//Fim do metodo main

  @Override
  public void start (Stage cenario) throws IOException {
    
    stage = cenario;
    cenario.setTitle("IA-Eventos");
    Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("Login.fxml"));
    telaLogin = new Scene (fxmlTelaInicial);

    Parent fxmlTelaCadastroUsuario = FXMLLoader.load(getClass().getResource("CadastrarUsuario.fxml"));
    telaCadastroUsuario = new Scene (fxmlTelaCadastroUsuario);
    Parent fxmlTelaCadastroMonitor = FXMLLoader.load(getClass().getResource("CadastrarMonitor.fxml"));
    telaCadastroMonitor = new Scene (fxmlTelaCadastroMonitor);
    Parent fxmlTelaCadastroPalestrante = FXMLLoader.load(getClass().getResource("CadastrarPalestrante.fxml"));
    telaCadastroPalestrante = new Scene (fxmlTelaCadastroPalestrante);
    Parent fxmlTelaCadastroOrganizador = FXMLLoader.load(getClass().getResource("CadastrarOrganizador.fxml"));
    telaCadastroOrganizador = new Scene (fxmlTelaCadastroOrganizador);

    Parent fxmltelaCadastrarAtividades = FXMLLoader.load(getClass().getResource("CadastrarAtividades.fxml"));
    telaCadastrarAtividades = new Scene (fxmltelaCadastrarAtividades);

    Parent fxmlTelaInscreverEmEventos= FXMLLoader.load(getClass().getResource("seInscreverEmEvento.fxml"));
    telaInscreverEmEventos = new Scene (fxmlTelaInscreverEmEventos);
    Parent fxmltelaMostrarEventos = FXMLLoader.load(getClass().getResource("MostrarEventos.fxml"));
    telaMostrarEventos = new Scene (fxmltelaMostrarEventos);
    Parent fxmltelaCriarEventos = FXMLLoader.load(getClass().getResource("CriarEvento.fxml"));
    telaCriarEventos = new Scene (fxmltelaCriarEventos);
    Parent fxmltelaOrganizarEvento = FXMLLoader.load(getClass().getResource("OrganizarEvento.fxml"));
    telaOrganizarEvento = new Scene (fxmltelaOrganizarEvento);

    Parent fxmltelaNovaSenha = FXMLLoader.load(getClass().getResource("EsqueciSenha.fxml"));
    telaNovaSenha = new Scene (fxmltelaNovaSenha);
    Parent fxmltelaPosLoginOrganizador = FXMLLoader.load(getClass().getResource("PosLoginOrganizador.fxml")); 
    telaPosLoginOrganizador = new Scene (fxmltelaPosLoginOrganizador);
    Parent fxmltelaPosLoginOuvinte = FXMLLoader.load(getClass().getResource("PosLoginOuvinte.fxml"));
    telaPosLoginOuvinte = new Scene (fxmltelaPosLoginOuvinte);
    Parent fxmltelaSelectYourSide = FXMLLoader.load(getClass().getResource("SelectYourSide.fxml"));
    telaSelectYourSide = new Scene (fxmltelaSelectYourSide);
    
    cenario.setResizable(false);
    cenario.setScene(telaLogin);
    cenario.show();
  }//Fim do metodo start

  public static void changeScreenLoginEsqueceuSenha (MouseEvent event) {
    stage.setScene(telaNovaSenha);
  }

  public static void changeScreenLogin (MouseEvent event) {
    stage.setScene(telaLogin);
  }
  
  public static void changeScreenLogin (ActionEvent event) {
    stage.setScene(telaLogin);
  }
  
  public static void changeScreenLoginCadastroUsuario (MouseEvent event) {
    stage.setScene(telaCadastroUsuario);
  }

  public static void changeScreenLoginMostrarEventos(ActionEvent event) {
    stage.setScene(telaMostrarEventos);
  }

  public static void changeScreenLoginSelectYourSide(ActionEvent event) {
    stage.setScene(telaSelectYourSide);
  }

  public static void changeScreenSelectYourSideOuvinte(ActionEvent event) {
    stage.setScene(telaPosLoginOuvinte);
  }

  public static void changeScreenSelectYourSideOrganizador (ActionEvent event) {
    stage.setScene(telaPosLoginOrganizador);
  }

  public static void changeScreenSelectYourSideOrganizador (MouseEvent event) {
    stage.setScene(telaPosLoginOrganizador);
  }

  public static void changeScreenOuvinteMostrarEventos(ActionEvent event) {
    stage.setScene(telaMostrarEventos);
  }

  public static void changeScreenOuvinteInscreverEmEventos(ActionEvent event) {
    stage.setScene(telaInscreverEmEventos);
  }

  public static void changeScreenOrganizadorCriarEventos (MouseEvent event) {
    stage.setScene(telaCriarEventos);
  }

  public static void changeScreenOrganizadorOrganizarEventos (MouseEvent event) {
    stage.setScene(telaOrganizarEvento);
  }

  public static void changeScreenOrganizadorOrganizarEventos (ActionEvent event) {
    stage.setScene(telaOrganizarEvento);
  }

  public static void changeScreenOrganizarEventosCadastrarAtividades (MouseEvent event) {
    stage.setScene(telaCadastrarAtividades);
  }

  public static void changeScreenOrganizarEventosCadastrarOrganizador (MouseEvent event) {
    stage.setScene(telaCadastroOrganizador);
  }

  public static void changeScreenOrganizarEventosCadastrarMonitor (MouseEvent event) {
    stage.setScene(telaCadastroMonitor);
  }

  public static void changeScreenOrganizarEventosCadastrarPalestrante (MouseEvent event) {
    stage.setScene(telaCadastroPalestrante);
  }
}

