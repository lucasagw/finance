package br.ucsal.pooa.finance;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.controller.LancamentoController;
import br.ucsal.pooa.finance.exception.ErroConexaoBancoDeDados;
import br.ucsal.pooa.finance.persistence.Banco;
import br.ucsal.pooa.finance.persistence.GenericoDAO;
import br.ucsal.pooa.finance.persistence.LancamentoDAO;
import br.ucsal.pooa.finance.persistence.Persistencia;
import br.ucsal.pooa.finance.view.Janela;
import br.ucsal.pooa.finance.view.JanelaDesktop;

public class financeMain {

	public static void main(String[] args) {

		//Banco banco;
		
		//try {
			 //banco = new Banco();
			Persistencia dao = new GenericoDAO();
			//Persistencia daoBanco = new LancamentoDAO(banco);
			Controller controller = new LancamentoController(dao);
			//Janela janela = new Janela(controller);
			JanelaDesktop janelaD = new JanelaDesktop(controller);
			
		
//		} catch (ErroConexaoBancoDeDados e) {
//			System.out.println(e.getMessage());
//		}
		
	}
}