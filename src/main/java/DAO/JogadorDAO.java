package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Jogador;

public class JogadorDAO {
   ConexaoDAO conexao = new ConexaoDAO();
   public void inserirJogador(Jogador jogador, int idPessoa) {      
      String sql = "INSERT INTO Jogador (id_pessoa, nomeCamisa, posicaoJoga, numGolCarreira) VALUES (?, ?, ?, ?)";
      try{      
         PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
         {
         stmt.setInt(1, idPessoa);
         stmt.setString(2, jogador.getNomeCamisa());
         stmt.setString(3, jogador.getPosicaoJoga());
         stmt.setInt(4, jogador.getNumGolCarreira());         
         stmt.executeUpdate();
         } 
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Jogador> listarJogadores() {
      List<Jogador> jogadores = new ArrayList<>();
      String sql = "SELECT * FROM Jogador j INNER JOIN Pessoa p ON p.id = j.id_pessoa";

      try {
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);          
            ResultSet rs = stmt.executeQuery(); 
            {
               while (rs.next()) {
                  String nome = rs.getString("nome");
                  int anoNasc = rs.getInt("anoNasc");
                  double altura = rs.getDouble("altura");
                  double peso = rs.getDouble("peso");
                  double salario = rs.getDouble("salario");
                  String nomeCamisa = rs.getString("nomeCamisa");
                  String posicaoJoga = rs.getString("posicaoJoga");
                  double bonus = rs.getDouble("bonus");
                  int numGolCarreira = rs.getInt("numGolCarreira");
               
                  Jogador jogador = new Jogador(nome, anoNasc, altura, peso, salario, bonus, nomeCamisa, posicaoJoga, numGolCarreira);
                  jogadores.add(jogador);
               }
               
         } 
      }catch (SQLException e) {
         e.printStackTrace();
      }
      return jogadores;
   }
}