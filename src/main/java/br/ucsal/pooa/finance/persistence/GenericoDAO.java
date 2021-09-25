package br.ucsal.pooa.finance.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;

public class GenericoDAO implements Persistencia {

	private List<Entidade> lista;

	protected Banco banco;
	
	public GenericoDAO() {
		lista = new ArrayList<>();
	}

	public List<Entidade> listar() {
		return lista;
	}

	public void inserir(Entidade lancamento) {
		lista.add(lancamento);
	}

	@Override
	public int count() {
		return lista.size();
	}
}
