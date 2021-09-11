package br.ucsal.pooa.finance;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.controller.LancamentoController;
import br.ucsal.pooa.finance.persistence.Banco;
import br.ucsal.pooa.finance.persistence.GenericoDAO;
import br.ucsal.pooa.finance.persistence.Persistencia;
import br.ucsal.pooa.finance.view.Janela;

public class financeMain {

	public static void main(String[] args) {

		Banco banco = new Banco();
		
		Persistencia dao = new GenericoDAO();
		
		Controller controller = new LancamentoController(dao);
		
		Janela janela = new Janela(controller);

	}
}