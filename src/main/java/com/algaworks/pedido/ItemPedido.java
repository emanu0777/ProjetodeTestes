package com.algaworks.pedido;

public class ItemPedido {

	private String descricao;
	
	private double valor_unitario;
	
	private int quantidade;
	
	public ItemPedido(String descricao, double valor_unitario, int quantidade) {
	
		this.descricao = descricao;
		this.valor_unitario = valor_unitario;
		this.quantidade = quantidade;

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
