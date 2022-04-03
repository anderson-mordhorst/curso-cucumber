package br.ce.wcaquino.entidade;

import java.time.LocalDate;

public class NotaAluguel {
	
	private int preco;
	private LocalDate dataEntrega;
	public Integer pontos;

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate entrega) {
		this.dataEntrega = entrega;
	}
	
	public Integer getPontos() {
		return pontos;
	}
	
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
}
