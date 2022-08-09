package entities;

public class PessoaJuridica extends Contribuintes {
	
	private Integer numeroDeFuncionarios;
	
	// TODO: corrigir o cálculo, está pegando o total - arrecado, sendo que o certo é só o arrecadado.
	private static final double taxaMaior = 16/100;
	private static final double taxaMenor = 14/100;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	public Double imposto() {
		if (numeroDeFuncionarios > 10) {
			return getRendaAnual() - taxaMenor;
		} else {
			return getRendaAnual() - taxaMaior;
		}
	}
}
