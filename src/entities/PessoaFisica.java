package entities;

public class PessoaFisica extends Contribuintes {
	
	private Double gastosSaude;
	
	// TODO: corrigir o cálculo, está pegando o total - arrecado, sendo que o certo é só o arrecadado.
	private static final double taxaMenor = 1 - 15/100;
	private static final double taxaMaior = 1 - 25/100;
	private static final double taxaSaude = 1 - 50/100;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	public Double imposto() {
		if (getRendaAnual() < 20000.00) {
			if (gastosSaude > 0.0) {
				return (getRendaAnual() * taxaMenor) - (gastosSaude * taxaSaude);
				//return (getRendaAnual() * (1 - 15/100)) - (gastosSaude * (1 - 50/100)); 
			} else {
				return getRendaAnual() * taxaMenor;
			}
		} else {
			if (gastosSaude > 0.0) {
				return (getRendaAnual() * taxaMaior) - (gastosSaude * taxaSaude);
			} else {
				return getRendaAnual() * taxaMaior;
			}
		}
	}
}
