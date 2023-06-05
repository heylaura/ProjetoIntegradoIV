package model;
import java.util.Calendar;

public class Pessoa {
   private String nome;
   private int anoNasc;
   private double altura;
   private double peso;
   private int idade;
   protected double salario;

   //construtor
   public Pessoa(String nome, int anoNasc, double peso, double altura) {
      this.nome = nome;
      this.anoNasc = anoNasc;
      this.idade = calcularIdade();
      this.peso = peso;
      this.altura = altura;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public int getAnoNasc() {
      return anoNasc;
   }

   public void setAnoNasc(int anoNasc) {
      this.anoNasc = anoNasc;
   }

   public int getIdade() {
      idade = calcularIdade();
      return idade;
   }
   
   public void setIdade(int idade) {
	      this.idade = idade;
   }  

   public double getPeso() {
      return peso;
   }

   public void setPeso(double peso) {
      this.peso = peso;
   }  

   public double getAltura() {
      return altura;
   }

   public void setAltura(double altura) {
      this.altura = altura;
   }  
   
   public double getSalario() {
       return salario;
   }

   public void setSalario(double salario) {
      this.salario = salario;
   }  

   public int calcularIdade() {
      // Obtém o ano atual
      int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
      int idadeCalculada = anoAtual - getAnoNasc();
      return idadeCalculada;
   }   

   public String mostrarDados() {
      String dados = "Nome: " + nome + "\n"
                           + "Ano de Nascimento: " + anoNasc + "\n"
                           + "Idade: " + idade + "\n"
                           + "Peso: " + peso + "\n"
                           + "Altura: " + altura + "\n"
                           + "Salário: " + salario;
      return dados;
   }
}

