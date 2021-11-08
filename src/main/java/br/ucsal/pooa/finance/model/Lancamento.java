package br.ucsal.pooa.finance.model;

import java.math.BigDecimal;

/**
 * Model Anemico
 *
 * @author lucas
 */

public class Lancamento implements Entidade {

	public static final String DESPESA = "DESPESA";
	public static final String RECEITA = "RECEITA";

	@Validacao(descricao = "getTipo")
	private String tipo;
    
	@ValidacaoBigDecimal(minValue = 1)
	private BigDecimal valor;

	@Validacao(descricao = "getDescricao")
	private String descricao;

	public Lancamento(String tipo, BigDecimal valor, String descricao) {
		this.tipo = tipo;
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lancamento [");
		if (tipo != null) {
			builder.append("tipo=");
			builder.append(tipo);
			builder.append(", ");
		}
		if (valor != null) {
			builder.append("valor=");
			builder.append(valor);
			builder.append(", ");
		}
		if (descricao != null) {
			builder.append("descricao=");
			builder.append(descricao);
		}
		builder.append("]");
		return builder.toString();
	}
}
