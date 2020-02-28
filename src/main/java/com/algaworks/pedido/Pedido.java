package com.algaworks.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Pedido {
	
	private ItemPedido itemPedido;
	
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	public void AdicionaItem(ItemPedido itemPedido ) {
		itens.add(itemPedido);
	}

	public double getValorTotal() {
		 return itens.stream().mapToDouble(i-> i.getValor_unitario() * i.getQuantidade()).sum();
	}

	public ResumoPedido resumo() {
		
		 double valorTotal = getValorTotal();
		 double valorDesconto = 0;
		
		if(getValorTotal() > 300 && getValorTotal() <= 800) {
			valorDesconto = getValorTotal() * 0.04;
			
		}else if(getValorTotal()> 800 && getValorTotal() <=1000) {	
			
			valorDesconto = getValorTotal() * 0.06;	
		
		}else if(getValorTotal() > 1000) {
			valorDesconto = getValorTotal() * 0.08;
		}
		
		return new ResumoPedido(valorTotal, valorDesconto);
	}

	
}
 