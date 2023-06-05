package model;

public class Jogador extends Pessoa{
	 private String nomeCamisa;
    private String posicaoJoga;
    private int numGolCarreira;
     
	   public Jogador(String nome, int anoNasc, double altura, double peso, double salarioBase, double bonus, String nomeCamisa, String posicaoJoga, int numGolCarreira) {
         super(nome, anoNasc, peso, altura);
         this.nomeCamisa = nomeCamisa;
         this.posicaoJoga = posicaoJoga;
         this.numGolCarreira = numGolCarreira;
         calcularSalario(bonus, salarioBase);
	   }
 
    public String getNomeCamisa() {
       return nomeCamisa;
    }
 
    public void setNomeCamisa(String nomeCamisa) {
       this.nomeCamisa = nomeCamisa;
    }
 
    public String getPosicaoJoga() {
       return posicaoJoga;
    }
 
    public void setPosicaoJoga(String posicaoJoga) {
       this.posicaoJoga = posicaoJoga;
    }
 
    public int getNumGolCarreira() {
       return numGolCarreira;
    }
 
   public void setNumGolCarreira(int numGolCarreira) {
       this.numGolCarreira = numGolCarreira;
    }

   public void calcularSalario(double salarioBase, double bonus) {      
     double salarioCalculado = salarioBase + bonus;   
     setSalario(salarioCalculado);
  }

   public String mostrarDados() {
      String dados = super.mostrarDados() + "\n"
                           + "Nome Camisa: " + nomeCamisa + "\n"
                           + "Posição que joga: " + posicaoJoga + "\n"
                           + "Número de gols na carreira: " + numGolCarreira;
      return dados;
   }
}