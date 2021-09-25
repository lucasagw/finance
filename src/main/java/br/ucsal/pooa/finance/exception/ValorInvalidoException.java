package br.ucsal.pooa.finance.exception;



public class ValorInvalidoException extends RuntimeException { // Exception nao marcada

	public ValorInvalidoException(Throwable t) {
		super("Valor Invalido");
	}
}
