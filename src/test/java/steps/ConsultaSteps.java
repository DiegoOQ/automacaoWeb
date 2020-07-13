package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.AnunciosPage;
import pages.PesquisaPage;
import setup.Hooks;

public class ConsultaSteps  {
	
	PesquisaPage home = new PesquisaPage(Hooks.getDriver());
	AnunciosPage anuncios = new AnunciosPage(Hooks.getDriver());
	
	
	
	@Dado("^que estou logado na aplicação$")
	public void queEstouLogadoNaAplicação() throws Throwable {
       home.checkPage();
	}

	@Quando("^preencho dados da pesquisa$")
	public void consultoListaDeCarros() throws Throwable {
		  home.selecionarMarca();
		    home.selecionarModelo();
		    home.clicarBtnBuscar();
	}

	@Então("^valido valor à vista dos anuncios$")
	public void validoValorValorÀVista() throws Throwable {
		anuncios.validarValores();
	}

	@Então("^Crio um arquivo de dados contendo marca, modelo, ano, km, cor, câmbio e valor à vista de cada veiculo retornado$")
	public void riarUmArquivoDeDadosContendoMarcaModeloAnoKmCorCâmbioEValorÀVistaDeCadaVeiculoRetornado() throws Throwable {
		anuncios.criarArquivoMassa();
	}


		
	

}
