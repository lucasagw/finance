package br.ucsal.pooa.finance.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

import br.ucsal.pooa.finance.exception.ValorInvalidoException;

public class Console {

	/**
	 * Leio uma string e converto para BigDecimal Se for um numero invalido retorno
	 * um BigDecimal 0
	 * 
	 * @param scanner
	 * @return
	 */

	public static BigDecimal getValor(String rotulo, Scanner scanner) throws ValorInvalidoException{
		System.out.println(rotulo);
		String valor = scanner.nextLine();
		NumberFormat nf = NumberFormat.getInstance();
		BigDecimal resultado;
		try {
			nf.parse(valor);
			resultado = new BigDecimal(valor);
		} catch (ParseException e) {
			resultado = BigDecimal.ZERO;
			throw new ValorInvalidoException(e);

		}
		return resultado;
	}
}