package com.algaworks.desconto;

public class SemDesconto extends CalculadoraDeFaixaDescontos {

	public SemDesconto(CalculadoraDeFaixaDescontos proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
