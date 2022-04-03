package br.ce.wcaquino.service;

import java.time.LocalDate;

import br.ce.wcaquino.entidade.Filme;
import br.ce.wcaquino.entidade.FilmeSemEstoqueException;
import br.ce.wcaquino.entidade.NotaAluguel;
import br.ce.wcaquino.entidade.TipoAluguel;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) throws Exception {
		if(filme.getEstoque() == 0) {
			throw new FilmeSemEstoqueException();
		}
		
		NotaAluguel nota = new NotaAluguel();		
		switch (tipo) {
			case COMUM:
				nota.setPontos(1);
				nota.setPreco(filme.getAluguel());
				nota.setDataEntrega(LocalDate.now().plusDays(1));			
				break;
			case EXTENDIDO:
				nota.setPontos(2);
				nota.setPreco(filme.getAluguel() * 2);
				nota.setDataEntrega(LocalDate.now().plusDays(3));				
				break;				
			case SEMANAL:
				nota.setPontos(3);
				nota.setPreco(filme.getAluguel() * 3);
				nota.setDataEntrega(LocalDate.now().plusDays(7));				
				break;	
			default:
				throw new IllegalAccessException("Tipo de aluguel não esperado");
		}

		filme.decrementarEstoque(1);
		return nota;
	}
}
