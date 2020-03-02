package com.algaworks.desconto;

public class CalculadoraDaPrimeiraFaixa extends CalculadoraDeFaixaDescontos {

	public CalculadoraDaPrimeiraFaixa(CalculadoraDeFaixaDescontos proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		 if(valorTotal > 300 && valorTotal <=800) 
			 return  valorTotal * 0.04;
		
		return -1;
	}

}
