package br.ucsal.pooa.finance;

import br.ucsal.pooa.finance.persistence.LancamentoDAO;
import br.ucsal.pooa.finance.view.Janela;

public class financeMain {

	public static void main(String[] args) {

		LancamentoDAO dao = new LancamentoDAO();
		Janela janela = new Janela(dao.listar());

	}
}