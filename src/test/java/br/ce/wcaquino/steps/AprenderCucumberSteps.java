package br.ce.wcaquino.steps;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {
	
	private int contador = 0;

	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {		
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {		
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {		
	}
	
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int valor) throws Throwable {
	    contador = valor;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int valor) throws Throwable {
	    contador = contador + valor;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int valor) throws Throwable {
	    assertThat(valor, equalTo(contador));
	}	
}
