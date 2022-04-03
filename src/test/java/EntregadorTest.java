import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidade.Entregador;
import br.ce.wcaquino.transforms.LocalDateTranform;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;


public class EntregadorTest {

	@Rule
	public ExpectedException e = ExpectedException.none();
	
	private Entregador entregador;
	
	@Test
	public void testEntregadorDataNull() {
		e.expectMessage("Data de entrega é obrigatório.");
		entregador = new Entregador(null);
	}

	@Dado("^que a entrega é dia (.*)$")
	public void queAEntregaEhDia(@Transform(LocalDateTranform.class) LocalDate data) throws Throwable {
		entregador = new Entregador(data);
	}

	@Quando("^a entrega atrasar em (\\d+) (dias|meses)$")
	public void aEntregaAtrasarEm(int dias, String tempo) throws Throwable {
		if("dias".equalsIgnoreCase(tempo)) {
			entregador.atrasarDias(dias);
		}
		
		if("meses".equalsIgnoreCase(tempo)) {
			entregador.atrasarMeses(dias);			
		}
	}

	@Então("^a entrega será efetuada em (\\d+)/(\\d+)/(\\d+)$")
	public void aEntregaSeraEfetuadaEm(int dia, int mes, int ano) throws Throwable {
		LocalDate esperado = LocalDate.of(ano, mes, dia);
		assertThat(esperado, equalTo(entregador.getDataEntrega()));
	}	
}
