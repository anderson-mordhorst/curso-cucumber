import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class DesafioTest {
	
	@Dado("^que o ticket (especial é|é) (AF|AB)(\\d+)$")
	public void queOTicket(String tipo, String sigla, String numero) throws Throwable {		
		String ticket = sigla.concat(numero);
		System.out.println("Ticket: ".concat(ticket));
	}

	@Dado("^que o valor da passagem é R\\$ (^[\\d]+,\\d{2}$)$")
	public void queOValorDaPassagem(int precision, int scale) throws Throwable {
		String valor = String.valueOf(precision).concat(",".concat(String.valueOf(scale)));
		System.out.println("Valor: ".concat(valor));
	}

	@Dado("^que o nome do passageiro é \"([^\"]*)\"$")
	public void queONomeDoPassageiro(String arg1) throws Throwable {

	}

	@Dado("^que o telefone do passageiro é (\\d+)-(\\d+)$")
	public void queOTelefoneDoPassageiro(int arg1, int arg2) throws Throwable {

	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}		
}
