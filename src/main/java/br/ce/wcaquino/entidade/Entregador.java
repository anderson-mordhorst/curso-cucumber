package br.ce.wcaquino.entidade;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

public class Entregador {
	
	private LocalDate dataEntrega;
	
	public Entregador(LocalDate entrega) {		
		this.dataEntrega = requireNonNull(entrega, "Data de entrega é obrigatório.");
	}
	
	public void atrasarDias(int dias) {
		dataEntrega = dataEntrega.plusDays(dias);
	}
	
	public void atrasarMeses(int meses) {
		dataEntrega = dataEntrega.plusMonths(meses);
	}
	
	
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
}
