package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDAO {

    public Connection conectar(){
    	try {
    		 Class.forName("com.mysql.cj.jdbc.Driver"); 
    	} catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
            return null;
        }
    	
        try{
            //instanciar a conexão 
            Connection conexao = 
                    DriverManager.getConnection("jdbc:mysql:///bd_cadastro?serverTimezone=America/Sao_Paulo","root","1234"); 
            return conexao;
        } catch(SQLException sqle) {
            System.out.println("SQLException:" + sqle.getMessage()); 
            return null; 
    } 
}}