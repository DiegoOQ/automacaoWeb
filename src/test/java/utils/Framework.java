package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import setup.Hooks;

public class Framework {

	static WebDriver driver = Hooks.getDriver();

	public static void preencherCampo(WebElement campo, String valor) {
		campo.sendKeys(valor);
	}

	public static void clicar(WebElement button) {
		button.click();
	}

	public static void elementoExiste(int segundos, String xpath)  {
		WebDriverWait wait = new WebDriverWait(driver, segundos);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public static void screenshot(Scenario scenario) {
		File file = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/" + scenario.getId() + ".jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void select(WebElement elemento, String opcao) {
		try {
			Select select = new Select(elemento);
			select.deselectByVisibleText(opcao);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mudarFoco(WebElement elemento) {
			
			driver.switchTo()
					.frame(elemento);

	}
	
	public static void clicarJS(WebElement elemento) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", elemento);

	}
	
	public static String recuperarAtributo(String xpath) {
		
			return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static String leitorJsonString (String nomeArquivo, String chaveJson) throws IOException {
		
		JSONObject js = null;
//		JSONArray ja = null;
		
		FileReader fr = new FileReader("src/test/resources/"+nomeArquivo+".json");
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String linha;
		
		while((linha = br.readLine()) != null) {
			sb = sb.append(linha);
		}
		
		br.close();
		fr.close();
		
		js = new JSONObject(sb.toString());
		String valor = js.getString(chaveJson);
		
		return valor;
		
	}


}
