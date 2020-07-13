package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Hooks;
import utils.Framework;

public class PesquisaPage {

	WebDriver driver = Hooks.getDriver();

	public PesquisaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Encontre aqui seu próximo carro')]")
	WebElement msgPesquisa;

	@FindBy(xpath = "//button[text()='Buscar']")
	WebElement btnBuscar;

	@FindBy(xpath = "//button[@title='Marca']")
	WebElement btnMarca;

	@FindBy(xpath = "//span[text()='Chrysler']")
	WebElement opcaoMarca;

	@FindBy(xpath = "//iframe[@style='width:0;height:0;display:block;border:0;']")
	WebElement iFramePesquisa;
	
	@FindBy(xpath = "//button[@title='Modelo']")
	WebElement btnModelo;
	
	@FindBy(xpath = "//span[text()='300C']")
	WebElement opcaoModelo;
		

	public void checkPage() {
		String xpath = "///button[text()='Buscar']";
		Framework.elementoExiste(50, xpath);
	}

	public void selecionarMarca() {
		Framework.clicarJS(btnMarca);
		Framework.clicarJS(opcaoMarca);
	}

	public void selecionarModelo() {
		Framework.clicarJS(btnModelo);
		String xpath = "//span[text()='300C']";
		Framework.elementoExiste(50, xpath);
		Framework.clicarJS(opcaoModelo);
	}

	public void clicarBtnBuscar() {
		Framework.clicarJS(btnBuscar);
	}
	
	

}
