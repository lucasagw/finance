package br.ucsal.pooa.finance.controller;

import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;

public interface Controller {

	List<Entidade> lista();

	void add(Entidade lancamento);

}