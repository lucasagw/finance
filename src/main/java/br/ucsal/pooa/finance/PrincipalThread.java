package br.ucsal.pooa.finance;

import br.ucsal.pooa.finance.util.Consumidor;
import br.ucsal.pooa.finance.util.Pilha;
import br.ucsal.pooa.finance.util.Produtor;
import br.ucsal.pooa.finance.util.Trabalhador;
import br.ucsal.pooa.finance.util.TrabalhadorRun;

public class PrincipalThread {

	public static void main(String[] args) {
		System.out.println("INICIO DO MAIN");
		Pilha pilha = new Pilha();
		//Trabalhador t = new Trabalhador();
		//TrabalhadorRun t = new TrabalhadorRun();
		//Thread thread = new Thread(t);
		
		Thread thread = new Thread(new Produtor(pilha));
		Thread c1 = new Thread(new Consumidor(pilha));
		Thread c2 = new Thread(new Consumidor(pilha));
		
		thread.start();
		c1.start();
		c2.start();
		System.out.println("FIM DO MAIN");
		
		
	}
}
