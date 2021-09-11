package br.ucsal.pooa.finance.persistence;

import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;


public interface Persistencia {

	public List<Entidade> listar(); 
        
	public void inserir(Entidade lancamento);
	
	public int count();
		
	
}
