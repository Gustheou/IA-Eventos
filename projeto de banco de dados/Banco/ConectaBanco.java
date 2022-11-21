package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
  public ConectaBanco() {}

  public Connection conectar() {
    Connection conexao = null;
    try {
      Class.forName("org.postgresql.Driver");
      conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Iaeventos", "postgres", "0");//mudar senha e usuario
    } catch (ClassNotFoundException e) {
      System.out.println("Driver do banco de dados não localizado");
    } catch (SQLException e) {
      System.out.println("Ocorreu um erro ao acessar a mensagme: " + e.getMessage());
    }

    return conexao;
  }

  public void desconectar(Connection conn) {
    try {
      if(conn != null && !conn.isClosed()) {
      conn.close();
      System.out.println("Desconectou do banco de dados.");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}