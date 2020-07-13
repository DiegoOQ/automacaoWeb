package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import setup.Hooks;
import utils.Framework;

@SuppressWarnings("deprecation")
public class AnunciosPage {

	WebDriver driver = Hooks.getDriver();

	public AnunciosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	String ano = null;
	String km = null;
	String cor = null;
	String cambio = null;
	String preco = null;

	public void validarValores() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='anuncio_container false']"));
		for (int i = 1; i < list.size(); i++) {
//			String xpath = "(//h3[@class='direita preco_anuncio'])[5]";
			driver.findElement(By.xpath("(//h3[@class='direita preco_anuncio'])[" + i + "]")).isDisplayed();

		}
	}

	public void criarArquivoMassa() {

		int i = 1;
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='anuncio_container false']"));
		for (@SuppressWarnings("unused")
		WebElement ee : list) {

			ano = Framework.recuperarAtributo("(//span[text()='Ano']/../p)[" + i + "]");
			km = Framework.recuperarAtributo("(//span[text()='Km']/../p)[" + i + "]");
			cor = Framework.recuperarAtributo("(//span[text()='Cor']/../p)[" + i + "]");
			cambio = Framework.recuperarAtributo("(//span[text()='Câmbio']/../p)[" + i + "]");
			preco = Framework.recuperarAtributo("(//h3[@class='direita preco_anuncio'])[" + i + "]").substring(0, 13);

			JSONObject json = new JSONObject();
			FileWriter writeFile = null;

			// Armazena dados em um Objeto JSON
			json.put("ano", "" + ano + "");
			json.put("km", "" + km + "");
			json.put("cor", "" + cor + "");
			json.put("cambio", "" + cambio + "");
			json.put("preco", "" + preco + "");

			try {
				writeFile = new FileWriter("src/test/resources/massa" + i + ".json");
				// Escreve no arquivo conteudo do Objeto JSON
				writeFile.write(json.toString());
				writeFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Imprimne na Tela o Objeto JSON para vizualização
			System.out.println(json);
			i++;

		}
	}


	public void validarAnuncios() throws IOException {

		int i = 1;
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='anuncio_container false']"));
		for (@SuppressWarnings("unused")
		WebElement ee : list) {

			ano = Framework.recuperarAtributo("(//span[text()='Ano']/../p)[" + i + "]");
			km = Framework.recuperarAtributo("(//span[text()='Km']/../p)[" + i + "]");
			cor = Framework.recuperarAtributo("(//span[text()='Cor']/../p)[" + i + "]");
			cambio = Framework.recuperarAtributo("(//span[text()='Câmbio']/../p)[" + i + "]");
			preco = Framework.recuperarAtributo("(//h3[@class='direita preco_anuncio'])[" + i + "]").substring(0, 13);

			if (ano.equals(Framework.leitorJsonString("massa"+ i +"", "ano"))
					&& km.equals(Framework.leitorJsonString("massa"+ i +"", "km"))
					&& cor.equals(Framework.leitorJsonString("massa"+ i +"", "cor"))
					&& cambio.equals(Framework.leitorJsonString("massa"+ i +"", "cambio"))
					&& preco.equals(Framework.leitorJsonString("massa" +i+ "", "preco"))) {
				Assert.assertTrue(true);

			}else {
				Assert.assertTrue(false);
			}
			
		i++;
		}
	}

}
