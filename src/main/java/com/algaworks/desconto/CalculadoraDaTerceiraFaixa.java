package com.algaworks.desconto;

public class CalculadoraDaTerceiraFaixa extends CalculadoraDeFaixaDescontos{

	public CalculadoraDaTerceiraFaixa(CalculadoraDeFaixaDescontos proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		 if(valorTotal > 1000) 
			 return  valorTotal * 0.08;
		
		return -1;
	}

	
}
