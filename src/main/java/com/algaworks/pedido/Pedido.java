package com.algaworks.pedido;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.desconto.CalculadoraDeFaixaDescontos;
public class Pedido {
	
	private ItemPedido itemPedido;
	
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	private CalculadoraDeFaixaDescontos calculadoraDeFaixas;
	
	public Pedido(CalculadoraDeFaixaDescontos calculadoraDeFaixa) {
		this.calculadoraDeFaixas = calculadoraDeFaixa;
	}

	public void AdicionaItem(ItemPedido itemPedido ) {
		itens.add(itemPedido);
	}

	public double getValorTotal() {
		 return itens.stream().mapToDouble(i-> i.getValor_unitario() * i.getQuantidade()).sum();
	}

	public ResumoPedido resumo() {
		
		 double valorTotal = getValorTotal();
		 double valorDesconto = calculadoraDeFaixas.desconto(valorTotal);
		return new ResumoPedido(valorTotal, valorDesconto);
	}

	
}
 