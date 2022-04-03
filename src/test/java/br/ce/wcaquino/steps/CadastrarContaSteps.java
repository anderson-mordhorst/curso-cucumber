package br.ce.wcaquino.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarContaSteps {
	
	private WebDriver driver;
	
	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Cursos\\worspace\\CursoCucumber\\src\\test\\resources\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com/");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String usuario) throws Throwable {
	    driver.findElement(By.id("email")).sendKeys(usuario);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String senha) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(senha);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
	    String bemVindo = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    assertThat(bemVindo, is("Bem vindo, anderson!"));
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
	    driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String nome) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(nome);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Então("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
	    String sucesso = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    assertThat(sucesso, is("Conta adicionada com sucesso!"));
	}
	
	@Então("^sou notificado que o nome da conta é obrigatório$")
	public void souNotificadoQueONomeDaContaÉObrigatório() throws Throwable {
	    String erro = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    assertThat(erro, is("Informe o nome da conta"));		
	}
	
	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
	    String erro = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    assertThat(erro, is("Já existe uma conta com esse nome"));
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
