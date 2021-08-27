package br.ucsal.pooa.finance;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

public class Helloworld {

	public static void main(String[] args) {

		System.out.println("Alô");

		CurrencyUnit usd = Monetary.getCurrency("USD");
		CurrencyUnit eur = Monetary.getCurrency("EUR");

		System.out.println(usd);
		System.out.println(usd.getNumericCode());
		System.out.println(usd.getDefaultFractionDigits());

		MonetaryAmount amount = Monetary.getDefaultAmountFactory().setCurrency(usd).setNumber(200).create();

		Money money = Money.of(12, usd);
		
		Money moneyEur = Money.of(12, eur);

		FastMoney fastMoney = FastMoney.of(2, usd);

	    System.out.println(money);
		System.out.println(fastMoney);
		System.out.println(amount);
		
		System.out.println(moneyEur);

	}
}
