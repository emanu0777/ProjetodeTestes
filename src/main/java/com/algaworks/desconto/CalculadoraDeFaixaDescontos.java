package com.algaworks.desconto;

public abstract class CalculadoraDeFaixaDescontos {

	private CalculadoraDeFaixaDescontos proximo;
	
	
	public CalculadoraDeFaixaDescontos(CalculadoraDeFaixaDescontos proximo) {
		this.proximo = proximo;
	}

	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		if(desconto == -1)
			return this.proximo.desconto(valorTotal);
		
		return desconto;
	}
	
	//Assinatura
	protected abstract double calcular(double valorTotal);

}
