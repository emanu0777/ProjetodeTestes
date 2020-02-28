package com.algaworks.pedido;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PedidoTest {

	private Pedido pedido;
	
	@Before
	public void setup() {
		pedido = new Pedido();
	}
	
	public void assertResumoPedido(double valorTotal, double valorDesconto) {
		assertEquals(valorTotal, pedido.resumo().getValorTotal(), 0.0001);
		assertEquals(valorDesconto, pedido.resumo().getValorDesconto(), 0.0001);
	}
	
	@Test
	public void devePermitirAdicionarUmNovoItem() throws Exception {
		pedido.AdicionaItem(new ItemPedido("Papel Higienico", 4.80, 2));
	}
	
	@Test
	public void deveCalcularPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.AdicionaItem(new ItemPedido("Papel Higienico", 5.0, 2));
		assertResumoPedido(10.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaVariosItens() throws Exception {
		pedido.AdicionaItem(new ItemPedido("Papel Higienico", 5.0, 2));
		pedido.AdicionaItem(new ItemPedido("Papel Toalha", 5.0, 2));
		assertResumoPedido(20.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNaPrimeiraFaixa() throws Exception {
		pedido.AdicionaItem(new ItemPedido("Fraldas", 15.0, 20));
		pedido.AdicionaItem(new ItemPedido("Leite Ninho", 10.0 , 3));
		
		assertResumoPedido(330.0, 13.2);
	}
	
	@Test
	public void deveAplicarDescontoNaSengundaFaixa() throws Exception {
		pedido.AdicionaItem(new ItemPedido("Saco de Cimento Poty", 40.0, 21));
		
		assertResumoPedido(840.0,50.4);
			
	}
	
	@Test
	public void deveAplicarDescontoNaTerceiraFaixa() throws Exception {
		pedido.AdicionaItem(new ItemPedido("Saco de Cimento Poty", 40.0, 21));
		pedido.AdicionaItem(new ItemPedido("Fraldas", 15.0, 20));
		pedido.AdicionaItem(new ItemPedido("Leite Ninho", 10.0 , 3));
				
		assertResumoPedido(1170, 93.6);
		
	}
	
	
}
