package steps;

import cucumber.api.java.pt.Então;
import pages.AnunciosPage;
import setup.Hooks;

public class ValidacaoCanalSteps {
	
	AnunciosPage anuncios = new AnunciosPage(Hooks.getDriver());

	@Então("^Valido informações do canal com arquivo de massa$")
	public void validoInformaçõesDoCanalComArquivoDeMassa() throws Throwable {
		anuncios.validarAnuncios();
	}

	
}
