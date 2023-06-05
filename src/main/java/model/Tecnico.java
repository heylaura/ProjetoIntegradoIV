package model;

public class Tecnico extends Pessoa {	
	   private String apelido;
	   private int anosExperiencia;
	   private int tempoContrato;
	   
	   public Tecnico(String nome, int anoNasc, double altura, double peso, String apelido, int anosDeExperiencia, int tempoContrato, int horaExtra, double salarioBase) {
		   		super(nome, anoNasc, peso, altura);
				this.apelido = apelido;
				this.anosExperiencia = anosDeExperiencia;
				this.tempoContrato = tempoContrato;
				calcularSalario(salarioBase, horaExtra);
	   }
	   	   
	   public String getApelido() {
	      return apelido;
	   }

	   public void setApelido(String apelido) {
	      this.apelido = apelido;
	   }

	   public int getAnosExperiencia() {
	      return anosExperiencia;
	   }

	   public void setAnosExperiencia(int anosExperiencia) {
	      this.anosExperiencia = anosExperiencia;
	   }

	   public int getTempoContrato() {
	      return tempoContrato;
	   }

	   public void setTempoContrato(int tempoContrato) {
	      this.tempoContrato = tempoContrato;
	   }

		 public void calcularSalario(double salarioBase, int horaExtra) {
	      double valorHoraTrabalhada = salarioBase / 30;
	      double salarioCalculado = salarioBase + (horaExtra * (valorHoraTrabalhada * 0.5));   
		  setSalario(salarioCalculado);
		}

			public String mostrarDados() {
				String dados = super.mostrarDados() + "\n"
											+ "Apelido: " + apelido + "\n"
											+ "Anos de Experiência: " + anosExperiencia + "\n"
											+ "Tempo de Contrato: " + tempoContrato;
				return dados;
   		}
}