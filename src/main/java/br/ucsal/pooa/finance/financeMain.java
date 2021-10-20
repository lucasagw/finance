package br.ucsal.pooa.finance;

import java.math.BigDecimal;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.controller.LancamentoController;
import br.ucsal.pooa.finance.model.Lancamento;
import br.ucsal.pooa.finance.persistence.GenericoDAO;
import br.ucsal.pooa.finance.persistence.Persistencia;
import br.ucsal.pooa.finance.view.Console;
import br.ucsal.pooa.finance.view.Desktop;

public class financeMain {

	public static void main(String[] args) {

//		try {
//			Proxy dolar = new Proxy();
//			new Thread(dolar).start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		new Thread(new SocketDolar()).start();
		
		Persistencia dao = new GenericoDAO();
		//Persistencia daoBanco = new LancamentoDAO(banco);
		Controller controller = new LancamentoController(dao);
		controller.add(new Lancamento("D", BigDecimal.ONE, "DESPESA"));
		Desktop desktop = new Desktop(controller);
		//Console console = new Console(controller);
		
	
	}
}