package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tecnico;

public class TecnicoDAO {  
   ConexaoDAO conexao = new ConexaoDAO();
   public void inserirTecnico(Tecnico tecnico, int idPessoa) {
      String sql = "INSERT INTO Tecnico (id_pessoa, apelido, anosExperiencia, tempoContrato) VALUES (?, ?, ?, ?)";      
      try{      
         PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
         {         
            stmt.setInt(1, idPessoa);
            stmt.setString(2, tecnico.getApelido());
            stmt.setInt(3, tecnico.getAnosExperiencia());
            stmt.setInt(4, tecnico.getTempoContrato());
            stmt.executeUpdate();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Tecnico> listarTecnicos() {
      List<Tecnico> tecnicos = new ArrayList<>();     
      String sql = "SELECT * FROM Tecnico t INNER JOIN Pessoa p ON p.id = t.id_pessoa";
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
               String apelido = rs.getString("apelido");
               int horaExtra = rs.getInt("horaExtra");
               int anosExperiencia = rs.getInt("anosExperiencia");
               int tempoContrato = rs.getInt("tempoContrato");
            
               Tecnico tecnico = new Tecnico(nome, anoNasc, altura, peso, apelido, anosExperiencia, tempoContrato, horaExtra, salario);
               tecnicos.add(tecnico);
            }
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return tecnicos;
   }
}
