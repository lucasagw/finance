package br.ucsal.pooa.finance.exception;

public class ErroConexaoBancoDeDados extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ErroConexaoBancoDeDados(Throwable t) {
        super("Ocorreu um Erro ao tentar acessar o Banco de Dados", t);
	
	}
}
