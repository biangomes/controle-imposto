package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Principal {
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double somaTaxas = 0.0;
		List<Contribuintes> lista = new ArrayList<>();
		
		System.out.println("Número de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Físico (f) ou Jurídico (j)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Nome: ");
			//sc.next();
			String nome = sc.next();
			System.out.println("Renda anual? R$ ");
			double rendaAnual = sc.nextDouble();
			
			// Invocando a logica para pessoa física
			if (ch == 'f') {
				System.out.println("Gastos médicos? R$ ");
				double gastosSaude = sc.nextDouble();
				lista.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else {
//				System.out.println("Nome: ");
//				sc.next();
//				String nome = sc.next();
//				System.out.println("Renda anual? R$ ");
//				double rendaAnual = sc.nextDouble();
				System.out.println("Quantidade de funcionários? ");
				int qtdFuncionarios = sc.nextInt();
				lista.add(new PessoaJuridica(nome, rendaAnual, qtdFuncionarios));
			}
		}
		
		System.out.println("TAXAS PAGAS: ");
		for (Contribuintes c : lista) {
			System.out.println(c.getNome() + ": $ " + String.format("%.5f", c.imposto()));
			somaTaxas += c.imposto();
		}
		
		System.out.println("TOTAL ARRECADADO: R$ " + somaTaxas);
		
		sc.close();
	}
}
