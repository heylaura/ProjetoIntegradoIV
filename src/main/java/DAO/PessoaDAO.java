package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

public class PessoaDAO {
   ConexaoDAO conexao = new ConexaoDAO();
   
   public int inserirPessoa(Pessoa pessoa) {
      int idPessoa = -1; // Valor padrão caso ocorra algum erro
      String sql = "INSERT INTO Pessoa (nome, anoNasc, idade, altura, peso, salario) VALUES (?, ?, ?, ?, ?, ?)";
      try{      
         PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
         {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getAnoNasc());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setDouble(4, pessoa.getAltura());
            stmt.setDouble(5, pessoa.getPeso());
            stmt.setDouble(6, pessoa.getSalario());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
               idPessoa = generatedKeys.getInt(1);
            }
      } 
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return idPessoa;
   }

   public List<Pessoa> listarPessoas() {
      List<Pessoa> pessoas = new ArrayList<>();
      String sql = "SELECT * FROM Pessoa";
      try {
         PreparedStatement stmt = conexao.conectar().prepareStatement(sql);          
         ResultSet rs = stmt.executeQuery(); 
         {
            while (rs.next()) {
               String nome = rs.getString("nome");
               int anoNasc = rs.getInt("anoNasc");
               double peso = rs.getDouble("peso");
               double altura = rs.getDouble("altura");
            
               Pessoa pessoa = new Pessoa(nome, anoNasc, peso, altura);
               pessoas.add(pessoa);
         }
      }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return pessoas;
   }
}
