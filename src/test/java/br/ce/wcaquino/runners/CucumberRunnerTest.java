package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"}, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE,
		//features = {"src/test/resources/features/AprenderCucumber.feature", "src/test/resources/features/Desafio.feature"},
		features = {"src/test/resources/features/CadastrarConta.feature"},
		glue = "br.ce.wcaquino.steps",
		tags = {"~@Ignore"},
		dryRun = false
)
public class CucumberRunnerTest {
	
	@BeforeClass
	public static void resetDataBase() {
		System.setProperty("webdriver.chrome.driver", "D:\\Cursos\\worspace\\CursoCucumber\\src\\test\\resources\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com/");
		
		driver.findElement(By.id("email")).sendKeys("anderson.mordhorst@gmail.com");
		driver.findElement(By.id("senha")).sendKeys("AlbertEinstein");
		driver.findElement(By.tagName("button")).click();
		
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
