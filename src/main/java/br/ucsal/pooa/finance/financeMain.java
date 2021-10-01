package br.ucsal.pooa.finance;

import java.io.IOException;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.controller.LancamentoController;
import br.ucsal.pooa.finance.persistence.GenericoDAO;
import br.ucsal.pooa.finance.persistence.Persistencia;
import br.ucsal.pooa.finance.util.Proxy;
import br.ucsal.pooa.finance.util.SocketDolar;
import br.ucsal.pooa.finance.view.JanelaDesktop2;

public class financeMain {

	public static void main(String[] args) {

		try {
			Proxy dolar = new Proxy();
			new Thread(dolar).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Thread(new SocketDolar()).start();
		
		

		// Banco banco;

		// try {
		// banco = new Banco();

		Persistencia dao = new GenericoDAO();
		// Persistencia daoBanco = new LancamentoDAO(banco);
		Controller controller = new LancamentoController(dao);
		// Janela janela = new Janela(controller);
		//JanelaDesktop janelaD = new JanelaDesktop(controller);
		
		//rodando com o socket
		JanelaDesktop2 janela = new JanelaDesktop2(controller);


//		} catch (ErroConexaoBancoDeDados e) {
//			System.out.println(e.getMessage());
//		}

	}
}