package br.ucsal.pooa.finance.controller;

import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;
import br.ucsal.pooa.finance.persistence.Persistencia;

public class LancamentoController implements Controller {

	private Persistencia dao;

	public LancamentoController(Persistencia dao) {
		this.dao = dao;
	}

	@Override
	public List<Entidade> lista() {
		return dao.listar();

	}

	@Override
	public void add(Entidade lancamento) {
		dao.inserir(lancamento);

	}

}
