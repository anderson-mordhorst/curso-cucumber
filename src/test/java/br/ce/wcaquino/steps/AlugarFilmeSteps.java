package br.ce.wcaquino.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.Map;

import br.ce.wcaquino.entidade.Filme;
import br.ce.wcaquino.entidade.FilmeSemEstoqueException;
import br.ce.wcaquino.entidade.NotaAluguel;
import br.ce.wcaquino.entidade.TipoAluguel;
import br.ce.wcaquino.service.AluguelService;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService service = new AluguelService();
	private NotaAluguel nota;
	private FilmeSemEstoqueException exception;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;
	
	
	@Dado("^um filme$")
	public void umFilme(DataTable dt) throws Throwable {
		Map<String, String> m = dt.asMap(String.class, String.class);
		
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(m.get("estoque")));
	    filme.setAluguel(Integer.parseInt(m.get("aluguel")));
	    tipoAluguel = TipoAluguel.of(m.get("tipo"));
	}	
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int quantidade) throws Throwable {
		filme = new Filme();
		filme.setEstoque(quantidade);
	}

	@Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDoAluguelSejaR$(int valor) throws Throwable {
	    filme.setAluguel(valor);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			nota = service.alugar(filme, tipoAluguel);	
		}
		catch(FilmeSemEstoqueException e) {
			exception = e;
		}	    
	}

	@Então("^o preço do aluguel será R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráR$(int valor) throws Throwable {
	    assertThat(nota.getPreco(), is(valor));
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int quantidade) throws Throwable {
	    assertThat(filme.getEstoque(), is(quantidade));
	}
	
	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
	    assertThat(exception, is(notNullValue()));
	}

	@Dado("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
		tipoAluguel = TipoAluguel.of(tipo);
	}

	@Então("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int dias) throws Throwable {
	    LocalDate entregaEsperada = LocalDate.now().plusDays(dias);	    
	    assertThat(nota.getDataEntrega(), is(entregaEsperada));		
	}

	@Então("^a pontuação será de (\\d+) pontos$")
	public void aPontuaçãoSeráDePontos(int pontos) throws Throwable {
		assertThat(nota.getPontos(), is(pontos));
	}	
}
