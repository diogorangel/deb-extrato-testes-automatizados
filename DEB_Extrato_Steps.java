package steps;

import static org.junit.Assert.assertTrue;
import javax.print.attribute.standard.PagesPerMinute;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import utilitarios.*;
import br.com.bb.ath.ftabb.FTABBContext;
import br.com.bb.ath.ftabb.browser.BrowserDriverFactory;
import br.com.bb.ath.ftabb.elementos.ElementActions;
import br.com.bb.ath.ftabb.elementos.Elemento;
import br.com.bb.ath.ftabb.elementos.ElementoTexto;
import br.com.bb.ath.ftabb.exceptions.ElementoNaoLocalizadoException;
import br.com.bb.ath.ftabb.exceptions.FTABBException;
import br.com.bb.ath.ftabb.gaw.PaginaPlataformaMensagensErro;
import br.com.bb.ath.ftabb.gaw.Plataforma;
import br.com.bb.ath.ftabb.utilitarios.FTABBUtils;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import paginas.DEB_Extrato_Page;
import paginas.DEB_Extrato_Page.DEB_Extrato_Page_modal;

@SuppressWarnings({ "unused" })
public class DEB_Extrato_Steps extends FTABBUtils {
	
	public static WebDriver driverWeb;
	
	private DEB_Extrato_Page pgExtrato;
	private DEB_Extrato_Page_modal pgmodal;
	/**
	 * Construtor da Classe
	 */
	public DEB_Extrato_Steps() {
		super();
	}

	@Before
	public static void inicio(){
		Plataforma.abrirPlataforma();
	}
	
	@Given("Realizo o Login na Plataforma e acesso o Negocios")
	public void paginaLoginNegocios() throws Throwable {
		String chave = $("login_plataforma.chaveF.chave");
		String senha = $("login_plataforma.chaveF.senha");
		System.out.println("-"+chave+"-");
		System.out.println("-"+senha+"-");
		//Plataforma.fazerLogin();
		Plataforma.fazerLogin(chave , senha);
		Plataforma.selecionarAreaDeTrabalho("Negócios");
		capturarTela();
	}
	
	@When("Entro em Extrato de Conta Corrente")
	public void extratoContaCorrente() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		Plataforma.abrirMenu("Contas","Consultas","Extrato de Conta Corrente");
		capturarTela();
	}
	
	@When("Entro em Conta Corrente Meses Anteriores")
	public void extratoContaCorrenteMesesAnteriores() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		Plataforma.abrirMenu("Contas","Consultas","Extrato de Conta Corrente - Meses Anteriores");
		capturarTela();
	}
	
	@Then("Fecho o pop up de Pesquisar Clientes")
	public void fecharPopupPesquisa() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		assertTrue(pgExtrato.fecharModalBotao.elementoExiste());
		//pgExtrato.fecharModalBotao.clicarComJS();
		assertTrue(pgExtrato.tituloContaCorrente.elementoExiste());
		pgExtrato.fecharModalBotao.clicarComJS ();
		capturarTela();
		sleep(1);
		} 
	
	@And("Escolho Cliente por MCI com Justificativa \"([^\"]*)\"$")
	public void escolherClienteMCIJustificativa(String arg1) throws Throwable {
		pgmodal = new DEB_Extrato_Page_modal();
		pgExtrato = new DEB_Extrato_Page();
		Plataforma.pesquisarModalClientePorMci("016963834");
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.clienteJustificativaHomolog);
		pgExtrato.aguardarElemento(pgExtrato.textoJustificativaHomolog);
		pgmodal.informarJustificativa(arg1);
		capturarTela();
		assertTrue(pgExtrato.botaoGravarAtivado.elementoExiste());
		pgExtrato.botaoGravarAtivado.clicarComJS ();
		pgExtrato.aguardarElemento(pgExtrato.tituloContaCorrente);
		assertTrue(pgExtrato.tituloContaCorrente.elementoExiste());
		capturarTela();	
		}
	
	@And("Escolher Cliente por MCI")
	public void escolherClienteMCI() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		Plataforma.pesquisarModalClientePorMci("226973215");
		capturarTela();
		Plataforma.abrirMenuSecundario("Extrato De Conta Corrente" , "Extrato - Meses Anteriores");
		capturarTela();
		sleep(2);
		//Plataforma.pesquisarModalClientePorMci("226973215");
		capturarTela();
		}
	
	@And("Escolher Cliente por Agencia e Conta")
	public void escolherClienteAgenciaConta() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		Plataforma.pesquisarModalClientePorAgenciaConta("551" ,"5001");
		capturarTela();
		Plataforma.abrirMenuSecundario("Extrato De Conta Corrente" , "Extrato - Meses Anteriores");
		capturarTela();
		sleep(2);
		//Plataforma.pesquisarModalClientePorAgenciaConta("551" ,"5001");
		//Campo Justificativa//Plataforma.pesquisarModalClientePorAgenciaConta("551" ,"76468");
		//Campo Justificativa//Plataforma.pesquisarModalClientePorAgenciaConta("551" ,"145932");
		capturarTela();
		}
	
	@And("Escolher Cliente por MCI Meses Anteriores")
	public void escolherClienteMCIMesesAnteriores() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		Plataforma.abrirMenuSecundario("Extrato De Conta Corrente" , "Extrato - Meses Anteriores");
		capturarTela();
		sleep(2);
		Plataforma.pesquisarModalClientePorMci("226973215");
		capturarTela();
		}
	
	@And("Escolher Cliente por Agencia e Conta Meses Anteriores")
	public void escolherClienteAgenciaContaMesesAnteriores() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		Plataforma.abrirMenuSecundario("Extrato De Conta Corrente" , "Extrato - Meses Anteriores");
		capturarTela();
		sleep(2);
		Plataforma.pesquisarModalClientePorAgenciaConta("551" ,"5001");
		capturarTela();
		}
	
	@And("Escolher Conta Corrente")
	public void escolherContaCorrente() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherContaCorrente);
		assertTrue(pgExtrato.escolherContaCorrente.elementoExiste());
		pgExtrato.escolherContaCorrente.clicarComJS ();
		capturarTela();
		}
	
	@And("Escolher Conta Salario")
	public void escolherContaSalario() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherContaSalario);
		assertTrue(pgExtrato.escolherContaSalario.elementoExiste());
		pgExtrato.escolherContaSalario.clicarComJS ();
		capturarTela();
		}
	
	@And("Escolher Pesquisa por agencia e conta nao listada")
	public void pesquisaAgenciaContaNaoListada() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherContaSalario);
		pgExtrato.aguardarElemento(pgExtrato.escolherContaCorrente);
		pgExtrato.aguardarElemento(pgExtrato.pesquisaAgenciaContaNaoListada);
		assertTrue(pgExtrato.escolherContaCorrente.elementoExiste());
		assertTrue(pgExtrato.escolherContaSalario.elementoExiste());
		assertTrue(pgExtrato.pesquisaAgenciaContaNaoListada.elementoExiste());
		pgExtrato.pesquisaAgenciaContaNaoListada.clicarComJS ();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.pesquisaAgenciaContaNaoListada);
		pgExtrato.aguardarElemento(pgExtrato.textoPopUPAgenciaContaNaoListada);
		pgExtrato.aguardarElemento(pgExtrato.campoAgenciaNaoListada);
		pgExtrato.aguardarElemento(pgExtrato.campoContaNaoListada);
		pgExtrato.aguardarElemento(pgExtrato.contaSalarioNaoListada);
		pgExtrato.aguardarElemento(pgExtrato.botaoCancelarNaoListada);
		pgExtrato.aguardarElemento(pgExtrato.botaoPesquisarNaoListada);
		assertTrue(pgExtrato.pesquisaAgenciaContaNaoListada.elementoExiste());
		assertTrue(pgExtrato.textoPopUPAgenciaContaNaoListada.elementoExiste());
		assertTrue(pgExtrato.campoAgenciaNaoListada.elementoExiste());
		assertTrue(pgExtrato.campoContaNaoListada.elementoExiste());
		assertTrue(pgExtrato.contaSalarioNaoListada.elementoExiste());
		assertTrue(pgExtrato.botaoCancelarNaoListada.elementoExiste());
		assertTrue(pgExtrato.botaoPesquisarNaoListada.elementoExiste());
		}
	
	@And("Pesquisar por agencia e conta corrente nao listada \\\"([^\\\"]*)\\\" \\\"([^\\\"]*)\\\"$")
	public void PesquisarAgenciaContaCorrenteNaoListada(String arg1, String arg2) throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.botaoPesquisarNaoListada);
		assertTrue(pgExtrato.botaoPesquisarNaoListada.elementoExiste());
		pgExtrato.informarAgencia(arg1);
		pgExtrato.informarConta(arg2);
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.botaoPesquisarNaoListada);
		pgExtrato.botaoPesquisarNaoListada.clicarComJS ();
		capturarTela();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.validarTitularConta);
		pgExtrato.aguardarElemento(pgExtrato.validarAgencia);
		pgExtrato.aguardarElemento(pgExtrato.validarContaSalario);
		pgExtrato.aguardarElemento(pgExtrato.validarImpressaoExtrato);
		assertTrue(pgExtrato.validarTitularConta.elementoExiste());
		assertTrue(pgExtrato.validarAgencia.elementoExiste());
		assertTrue(pgExtrato.validarContaSalario.elementoExiste());
		assertTrue(pgExtrato.validarImpressaoExtrato.elementoExiste());
		capturarTela();
		
	}
	@And("Pesquisar por agencia e conta salario nao listada \\\"([^\\\"]*)\\\" \\\"([^\\\"]*)\\\"$")
	public void PesquisarAgenciaContaSalarioNaoListada(String arg1, String arg2) throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.botaoPesquisarNaoListada);
		assertTrue(pgExtrato.botaoPesquisarNaoListada.elementoExiste());
		pgExtrato.informarAgencia(arg1);
		pgExtrato.informarConta(arg2);
		capturarTela();
		pgExtrato.caixaContaSalario.clicarComJS ();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.botaoPesquisarNaoListada);
		pgExtrato.botaoPesquisarNaoListada.clicarComJS ();
		capturarTela();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.validarTitularConta);
		pgExtrato.aguardarElemento(pgExtrato.validarAgencia);
		pgExtrato.aguardarElemento(pgExtrato.validarContaSalario);
		pgExtrato.aguardarElemento(pgExtrato.validarImpressaoExtrato);
		assertTrue(pgExtrato.validarTitularConta.elementoExiste());
		assertTrue(pgExtrato.validarAgencia.elementoExiste());
		assertTrue(pgExtrato.validarContaSalario.elementoExiste());
		assertTrue(pgExtrato.validarImpressaoExtrato.elementoExiste());
		capturarTela();
		
	}
	
	@And("Cancelar Pesquisa por agencia e conta nao listada")
	public void CancelarPesquisaAgenciaContaNaoListada() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.botaoCancelarNaoListada);
		assertTrue(pgExtrato.botaoCancelarNaoListada.elementoExiste());
		pgExtrato.botaoCancelarNaoListada.clicarComJS ();
		pgExtrato.aguardarElemento(pgExtrato.reconhecerPopUp);
		assertTrue(pgExtrato.reconhecerPopUp.elementoExiste());
	}
	
	@And("Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021")
	public void escolherTitularAgenciaContaExtratoMaio2021() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.validarTitularConta);
		pgExtrato.aguardarElemento(pgExtrato.validarAgencia);
		pgExtrato.aguardarElemento(pgExtrato.validarContaCorrente);
		pgExtrato.aguardarElemento(pgExtrato.validarImpressaoExtrato);
		assertTrue(pgExtrato.validarTitularConta.elementoExiste());
		assertTrue(pgExtrato.validarAgencia.elementoExiste());
		assertTrue(pgExtrato.validarContaCorrente.elementoExiste());
		assertTrue(pgExtrato.validarImpressaoExtrato.elementoExiste());
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.clicarPeriodo);
		pgExtrato.clicarPeriodo.clicarComJS ();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherPeriodoMaio2021);
		pgExtrato.escolherPeriodoMaio2021.posicionarMouseEClicar();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.quantidadeExtratoMaio2021);
		pgExtrato.aguardarElemento(pgExtrato.nomeclaturaQuantidade);
		assertTrue(pgExtrato.quantidadeExtratoMaio2021.elementoExiste());
		assertTrue(pgExtrato.nomeclaturaQuantidade.elementoExiste());
		capturarTela();
		pgExtrato.botaoPesquisar.clicarComJS();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.quantidadeExtratoMaio2021);
		pgExtrato.aguardarElemento(pgExtrato.nomeclaturaQuantidade);
		pgExtrato.aguardarElemento(pgExtrato.tabelaExtrato);
		pgExtrato.aguardarElemento(pgExtrato.tabelaData);
		pgExtrato.aguardarElemento(pgExtrato.tabelaCompraCartao);
		pgExtrato.aguardarElemento(pgExtrato.tabelaCompraLocal);
		pgExtrato.aguardarElemento(pgExtrato.tabelaDocumento);
		pgExtrato.aguardarElemento(pgExtrato.tabelaLote);
		pgExtrato.aguardarElemento(pgExtrato.tabelaValor);
		capturarTela();
		assertTrue(pgExtrato.quantidadeExtratoMaio2021.elementoExiste());
		assertTrue(pgExtrato.nomeclaturaQuantidade.elementoExiste());
		assertTrue(pgExtrato.tabelaExtrato.elementoExiste());
		assertTrue(pgExtrato.tabelaData.elementoExiste());
		assertTrue(pgExtrato.tabelaCompraCartao.elementoExiste());
		assertTrue(pgExtrato.tabelaCompraLocal.elementoExiste());
		assertTrue(pgExtrato.tabelaDocumento.elementoExiste());
		assertTrue(pgExtrato.tabelaLote.elementoExiste());
		assertTrue(pgExtrato.tabelaValor.elementoExiste());
		capturarTela();
		}
	
	@And("Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021")
	public void escolherTitularAgenciaContaSalarioMaio2021() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.validarTitularConta);
		pgExtrato.aguardarElemento(pgExtrato.validarAgencia);
		pgExtrato.aguardarElemento(pgExtrato.escritaAgencia);
		pgExtrato.aguardarElemento(pgExtrato.validarContaSalario);
		pgExtrato.aguardarElemento(pgExtrato.validarImpressaoExtrato);
		pgExtrato.aguardarElemento(pgExtrato.escritaContaSalario);
		assertTrue(pgExtrato.validarTitularConta.elementoExiste());
		assertTrue(pgExtrato.escritaAgencia.elementoExiste());
		assertTrue(pgExtrato.validarAgencia.elementoExiste());
		assertTrue(pgExtrato.validarContaSalario.elementoExiste());
		assertTrue(pgExtrato.validarImpressaoExtrato.elementoExiste());
		assertTrue(pgExtrato.escritaContaSalario.elementoExiste());
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.clicarPeriodo);
		pgExtrato.clicarPeriodo.clicarComJS ();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherPeriodoMaio2021);
		pgExtrato.escolherPeriodoMaio2021.posicionarMouseEClicar();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.quantidadeExtratoSalarioMaio2021);
		pgExtrato.aguardarElemento(pgExtrato.nomeclaturaQuantidade);
		assertTrue(pgExtrato.quantidadeExtratoSalarioMaio2021.elementoExiste());
		assertTrue(pgExtrato.nomeclaturaQuantidade.elementoExiste());
		capturarTela();
		pgExtrato.botaoPesquisar.clicarComJS();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.quantidadeExtratoSalarioMaio2021);
		pgExtrato.aguardarElemento(pgExtrato.nomeclaturaQuantidade);
		pgExtrato.aguardarElemento(pgExtrato.tabelaExtrato);
		pgExtrato.aguardarElemento(pgExtrato.tabelaDataSalario);
		pgExtrato.aguardarElemento(pgExtrato.tabelaCompraSalarioHistorico);
		pgExtrato.aguardarElemento(pgExtrato.tabelaDocumentoSalario);
		pgExtrato.aguardarElemento(pgExtrato.tabelaLoteSalario);
		pgExtrato.aguardarElemento(pgExtrato.tabelaValorSalario);
		assertTrue(pgExtrato.quantidadeExtratoSalarioMaio2021.elementoExiste());
		assertTrue(pgExtrato.nomeclaturaQuantidade.elementoExiste());
		assertTrue(pgExtrato.tabelaExtrato.elementoExiste());
		assertTrue(pgExtrato.tabelaDataSalario.elementoExiste());
		assertTrue(pgExtrato.tabelaCompraSalarioHistorico.elementoExiste());
		assertTrue(pgExtrato.tabelaDocumentoSalario.elementoExiste());
		assertTrue(pgExtrato.tabelaLoteSalario.elementoExiste());
		assertTrue(pgExtrato.tabelaValorSalario.elementoExiste());
		capturarTela();
		}
	
	@And("Validar Titular e Agencia e Conta Corrente na Tela Extrato Janeiro 2015")
	public void escolherTitularAgenciaContaExtratoJaneiro2015() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.validarTitularConta);
		pgExtrato.aguardarElemento(pgExtrato.validarAgencia);
		pgExtrato.aguardarElemento(pgExtrato.validarContaCorrente);
		pgExtrato.aguardarElemento(pgExtrato.validarImpressaoExtrato);
		pgExtrato.aguardarElemento(pgExtrato.escritaContaCorrente);
		pgExtrato.aguardarElemento(pgExtrato.escritaAgencia);
		assertTrue(pgExtrato.validarTitularConta.elementoExiste());
		assertTrue(pgExtrato.validarAgencia.elementoExiste());
		assertTrue(pgExtrato.validarContaCorrente.elementoExiste());
		assertTrue(pgExtrato.validarImpressaoExtrato.elementoExiste());
		assertTrue(pgExtrato.escritaContaCorrente.elementoExiste());
		assertTrue(pgExtrato.escritaAgencia.elementoExiste());
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.clicarPeriodo);
		pgExtrato.clicarPeriodo.clicarComJS ();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherPeriodoJaneiro2015);
		pgExtrato.escolherPeriodoJaneiro2015.posicionarMouseEClicar();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.botaoPesquisar);
		pgExtrato.botaoPesquisar.clicarComJS ();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.escolherPeriodoJaneiro2015);
		assertTrue(pgExtrato.escolherPeriodoJaneiro2015.elementoExiste());
		}
	
	@And("Clico no botao Voltar")
	public void clicoBotaoVoltar() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		if (pgExtrato.botaoVoltar.elementoExiste() == true) {
			pgExtrato.botaoVoltar.clicarComJS();
			pgExtrato.aguardarElemento(pgExtrato.escolherContaCorrente);
			pgExtrato.aguardarElemento(pgExtrato.escolherContaSalario);
			assertTrue(pgExtrato.escolherContaCorrente.elementoExiste());
			assertTrue(pgExtrato.escolherContaSalario.elementoExiste());
			capturarTela();
		 }
		else {
			System.out.println("Erro Cenário");
			assertTrue(!pgExtrato.escolherContaCorrente.elementoExiste());
			assertTrue(!pgExtrato.escolherContaSalario.elementoExiste());
			}
		}
		
	@And("Realizo e valido o download do Extrato sem tarifa")
	public void ValidoDownload() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		capturarTela();
	}
	
	@And("Conta salario realizo e valido o download do Extrato sem tarifa")
	public void ValidoDownloadSalarioDownload() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		capturarTela();
	}
	
	@And("Realizo e valido o download do Extrato com tarifa")
	public void ValidoDownloadTarifa() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.botaoCobrarTarifa.clicarComJS();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
	}
	
	@And("Valido o download CSV do Extrato")
	public void downloadCSV() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarCSV.elementoExiste());
			pgExtrato.SelecionarCSV.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc5001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarCSV.elementoExiste());
			}
		}
	
	
	@And("Realizo e valido o download PDF do Extrato")
	public void downloadPDF() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarPDF.elementoExiste());
			pgExtrato.SelecionarPDF.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.clicarComJS();
			sleep(2);
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc5001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarCSV.elementoExiste());
			}
		}
	
	@And("Valido Conta Salario o download PDF do Extrato")
	public void downloadContaSalarioPDF() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarPDF.elementoExiste());
			pgExtrato.SelecionarPDF.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.clicarComJS();
			sleep(2);
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc4500005001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarPDF.elementoExiste());
			}
		}
	
	@And("Seleciono Conta Salario o download CSV do Extrato")
	public void downloadContaSalarioCSV() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarCSV.elementoExiste());
			pgExtrato.SelecionarCSV.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.clicarComJS();
			sleep(2);
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc4500005001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarCSV.elementoExiste());
			}
		}
	
	@And("Realizo e Valido o download TXT do Extrato")
	public void downloadTXT() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarTxt.elementoExiste());
			pgExtrato.SelecionarTxt.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc5001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarTxt.elementoExiste());
			}
		}

	
	@And("Seleciono Conta Salario o download TXT do Extrato")
	public void downloadContaSalarioTXT() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarTxt.elementoExiste());
			pgExtrato.SelecionarTxt.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.clicarComJS();
			sleep(2);
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc4500005001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarTxt.elementoExiste());
			}
		}
		
		
	@And("Realizo e Valido o download OFX do Extrato")
	public void downloadOFX() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarOfx.elementoExiste());
			pgExtrato.SelecionarOfx.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc5001_5-2021.csv");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarOfx.elementoExiste());
			}
		}
	

	
	@And("Seleciono Conta Salario o download OFX do Extrato")
	public void downloadContaSalarioOFX() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarOfx.elementoExiste());
			pgExtrato.SelecionarOfx.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.clicarComJS();
			sleep(2);
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc4500005001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarOfx.elementoExiste());
			}
		}
		
		
	@And("Realizo e Valido o download BBT do Extrato")
	public void downloadBBT() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarBBT.elementoExiste());
			pgExtrato.SelecionarBBT.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc5001_5-2021.csv");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarBBT.elementoExiste());
			}
		}
	
	
	@And("Seleciono Conta Salario o download BBT do Extrato")
	public void downloadContaSalarioBBT() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		if (pgExtrato.selecionarTipoArquivo.elementoExiste() == true) {
			pgExtrato.selecionarTipoArquivo.clicarComJS();
			capturarTela();
			assertTrue(pgExtrato.SelecionarBBT.elementoExiste());
			pgExtrato.SelecionarBBT.clicarComJS();
			capturarTela();
			pgExtrato.BotaoSalvarDownload.clicarComJS();
			sleep(2);
			pgExtrato.BotaoSalvarDownload.confirmarDownload("Extrato-ag551-cc4500005001_5-2021");
			capturarTela();
		 	}
		
		else {
			System.out.println("Erro Cenário");
			assertTrue(pgExtrato.botaoDownload.elementoExiste());
			assertTrue(pgExtrato.SelecionarOfx.elementoExiste());
			}
		}
	@And("Conta salario realizo e valido o download sem poder ativar a tarifa")
	public void ValidoDownloadTarifaProibidaContaSalario() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		assertTrue(pgExtrato.botaoDownload.elementoExiste());
		pgExtrato.botaoDownload.clicarComJS();
		capturarTela();
		assertTrue(!pgExtrato.botaoCobrarTarifa.elementoExiste());
		capturarTela();
		pgExtrato.BotaoSalvarDownload.clicarComJS();
		capturarTela();
		sleep(2);
		pgExtrato.botaoDownload.confirmarDownload("Extrato-ag551-cc4500005001_5-2021");
		capturarTela();
	}
	
	@And("Validar os filtros da tela Extrato de Meses Anteriores")
	public void validofiltrosExtratoMesesAnteriores() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.dataInicioLancamento);
		pgExtrato.aguardarElemento(pgExtrato.dataFimLancamento);
		pgExtrato.aguardarElemento(pgExtrato.botaoHistorico);
		pgExtrato.aguardarElemento(pgExtrato.botaoTipoLancamento);
		pgExtrato.aguardarElemento(pgExtrato.botaoFiltrar);
		pgExtrato.aguardarElemento(pgExtrato.BotaoBaixarArquivos);
		assertTrue(pgExtrato.dataInicioLancamento.elementoExiste());
		assertTrue(pgExtrato.dataFimLancamento.elementoExiste());
		assertTrue(pgExtrato.botaoHistorico.elementoExiste());
		assertTrue(pgExtrato.botaoTipoLancamento.elementoExiste());
		assertTrue(pgExtrato.botaoFiltrar.elementoExiste());
		assertTrue(pgExtrato.BotaoBaixarArquivos.elementoExiste());
		capturarTela();
	}
	
	@And("Valido a exibicao do painel de baixar arquivos e Email")
	public void validopainelbaixararquivos() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.BotaoBaixarArquivos.clicarComJS();
		pgExtrato.aguardarElemento(pgExtrato.BotaoArquivo);
		pgExtrato.aguardarElemento(pgExtrato.Email);
		pgExtrato.aguardarElemento(pgExtrato.EnviarEmail);
		pgExtrato.aguardarElemento(pgExtrato.ClienteNaoPossuiPermissao);
		assertTrue(pgExtrato.BotaoArquivo.elementoExiste());
		assertTrue(pgExtrato.Email.elementoExiste());
		assertTrue(pgExtrato.EnviarEmail.elementoExiste());
		assertTrue(pgExtrato.ClienteNaoPossuiPermissao.elementoExiste());
	}
	
	@And("Valido Cliente sem servico de Email")
	public void ValidoClienteSemServicoEmail() throws Throwable {
		pgExtrato = new DEB_Extrato_Page();
		capturarTela();
		pgExtrato.aguardarElemento(pgExtrato.ClienteNaoPossuiPermissao);
		pgExtrato.aguardarElemento(pgExtrato.EmailDoCliente);
		assertTrue(pgExtrato.ClienteNaoPossuiPermissao.elementoExiste());
		assertTrue(pgExtrato.EmailDoCliente.elementoExiste());
	}
	
	@And("Valido envio do arquivo lancamentos no SMPT")
	public void validarEmail() throws Throwable {
		FTABBContext.getContext().getContextBrowserDriver().getDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://correioweb.hm.bb.com.br");
		System.out.println("Loading URL one by one ........");
		System.out.println("-----------------------------------------------------------------------"); 
		System.out.println("E-mail enviado para homologação"); 
		System.out.println("e-mail de origem.: homologa.smtp@hm.bb.com.br"); 
		System.out.println("e-mail de origem.: testehm@bb.com.br"); 
		System.out.println("Servidor.........: https://correioweb.hm.bb.com.br"); 
		System.out.println("Usuário..........: Conexao SMTP"); 
		System.out.println("Senha.............: conexaohom"); 
		System.out.println("------------------------------------------------------------------------");
		//verificar a situação da conta: deb -> 01 -> 01 ag/cc -> 09
	}
	
	@And("Fecho Pagina Atual")
	public void fecharAplicativo() throws Throwable {
		Plataforma.fecharPaginaAtual();
	}
		
	@And("Encerro a navegacao pela plataforma")
	public void encerrarnavegacaoPlataforma() throws Throwable {
		Plataforma.fecharPlataforma();
		}
	}
