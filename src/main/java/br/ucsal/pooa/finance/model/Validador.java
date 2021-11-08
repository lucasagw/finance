package br.ucsal.pooa.finance.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.pooa.finance.exception.ValorInvalidoException;

public class Validador {

	private Object object;

	public Validador(Object object) {
		this.object = object;
	}

//	public List<String> validar() {  manual
//		List<String> erros = new ArrayList<>();
//		if (lancamento.getTipo() == null || lancamento.getTipo().isEmpty()) {
//			erros.add("Preencha Tipo");
//		}
//		if (lancamento.getDescricao() == null || lancamento.getDescricao().isEmpty()) {
//			erros.add("Preencha Descricao");
//		}
//		if (lancamento.getValor() == null || lancamento.getValor().equals(BigDecimal.ZERO)) {
//			erros.add("Preencha Valor");
//		}
//
//		return erros;
//	}

	// dinâmico sem anotação
//	public List<String> validar() {
//		List<String> erros = new ArrayList<>();
//		Class<?> classe = object.getClass();
//		Field[] atributos = classe.getDeclaredFields(); // getFields() só pega public
//		for (Field atributo : atributos) {
//			atributo.setAccessible(true);
//			Object valor = null;
//			try {
//				valor = atributo.get(object);
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			if (valor == null || valor.toString().isEmpty()) {
//				erros.add("Preencha " + atributo.getName());
//			}
//		}
//		return erros;
//	}

	// dinâmico com anotação
	public List<String> validar() {
		List<String> erros = new ArrayList<>();
		Class<?> classe = object.getClass();
		Field[] atributos = classe.getDeclaredFields(); // getFields() só pega public
		for (Field atributo : atributos) {
			atributo.setAccessible(true);
			if (atributo.isAnnotationPresent(Validacao.class)) {
				Validacao validacao = atributo.getAnnotation(Validacao.class);
				Object valor = null;
				try {
					valor = atributo.get(object);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}

				if (valor == null || valor.toString().isEmpty()) {
					erros.add("Preencha " + validacao.descricao());
				} // else {
//					   erros.add("Preencha " + atributo.getName());
//				}
			}
		}
		return erros;
	}
	
	// dinâmico com anotação
		public List<String> validarBigDecimal() {
			List<String> erros = new ArrayList<>();
			Class<?> classe = object.getClass();
			Field[] atributos = classe.getDeclaredFields(); // getFields() só pega public
			for (Field atributo : atributos) {
				atributo.setAccessible(true);
				if (atributo.isAnnotationPresent(ValidacaoBigDecimal.class)) {
					ValidacaoBigDecimal validacao = atributo.getAnnotation(ValidacaoBigDecimal.class);
					Object valor = null;
					try {
						valor = atributo.get(object);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					BigDecimal valorBig = (BigDecimal) valor;
					
					if (valorBig == null || valorBig.equals(BigDecimal.ZERO)) {
						erros.add("Preencha no mínimo: " + validacao.minValue());
					} 
				}
			}
			return erros;
		}

	// dinâmico com anotação e usando o getMethod
//	public List<String> validar() {
//		List<String> erros = new ArrayList<>();
//		Class<?> classe = object.getClass();
//		Field[] atributos = classe.getDeclaredFields(); // getFields() só pega public
//		for (Field atributo : atributos) {
//			if (atributo.isAnnotationPresent(Validacao.class)) {
//				Validacao validacao = atributo.getAnnotation(Validacao.class);
//				Object valor = null;
//				try {        
//					valor = classe.getMethod(validacao.descricao(), null).invoke(object, null);
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (NoSuchMethodException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SecurityException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				if (valor == null || valor.toString().isEmpty()) {
//					   erros.add("Preencha " + validacao.descricao());
//				} // else {
//					   erros.add("Preencha " + atributo.getName());
//				}
//			}
//		}
//		return erros;
//	}
}
