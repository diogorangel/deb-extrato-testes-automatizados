package paginas;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import br.com.bb.ath.ftabb.FTABBContext;
import br.com.bb.ath.ftabb.Pagina;
import br.com.bb.ath.ftabb.anotacoes.MapearElementoWeb;
import br.com.bb.ath.ftabb.elementos.Elemento;
import br.com.bb.ath.ftabb.elementos.ElementoBotao;
import br.com.bb.ath.ftabb.elementos.ElementoCheckbox;
import br.com.bb.ath.ftabb.elementos.ElementoInput;
import br.com.bb.ath.ftabb.elementos.ElementoLink;
import br.com.bb.ath.ftabb.elementos.ElementoTabela;
import br.com.bb.ath.ftabb.elementos.ElementoTexto;
import br.com.bb.ath.ftabb.exceptions.ElementoNaoLocalizadoException;
import br.com.bb.ath.ftabb.gaw.PaginaPlataformaModal;



	public class DEB_Extrato_Page extends Pagina {
		@SuppressWarnings({ "unused" })
		
		private WebDriver driverWeb;
		WebDriver driver=(WebDriver) 
		FTABBContext.getContext().getContextBrowserDriver().getDriver();
		

		public DEB_Extrato_Page(WebDriver driverWeb) {
			this.driverWeb = driverWeb;
			PageFactory.initElements(driverWeb, this);
		}
		
		//Codigo Usuario
		@MapearElementoWeb(id = "idToken1")
		public ElementoInput CodigoUsuario;
		
		//Codigo Usuario
		@MapearElementoWeb(id = "idToken3")
		public ElementoInput senhaUsuario;
		
		//Botao Login
		@MapearElementoWeb(xPath = "loginButton_0")
		public ElementoBotao BotaoLogin;
		
		//Botao Fechar
		@MapearElementoWeb(xPath = "//button[contains(@aria-label, 'Fechar aplicativo')]")
		public ElementoBotao botaoFechar;
		
		//Teste
		@MapearElementoWeb(xPath = "//div[@class='modal__close']")
		public ElementoTabela fecharModalBotao;
		
		//Pop up
		@MapearElementoWeb(xPath = "//header[1]/div[1]/i[1]")
		public ElementoTabela popPesquisaClientes;
		
		//Escrita Conta Corrente
		@MapearElementoWeb(xPath = "//h1[contains(text(),'Extrato de Conta Corrente')]")
		public ElementoTexto tituloContaCorrente;
		
		//Selecionar MCI 
		//@MapearElementoWeb(xPath = "//span[contains(@class, 'tt-title') and contains (., 'MCI: 016963834')]")
		//Campo Justificativa 551/76468 551/145932
		@MapearElementoWeb(xPath = "//span[contains(@class, 'tt-title') and contains (., 'MCI: 226973215')]")
		public Elemento selecionarMCI;
		
		//Textos
		//@MapearElementoWeb(xPath = "//input[contains(@placeholder, 'Digite a justificativa (pelo menos 20 caracteres)...')]")
		@MapearElementoWeb(xPath = "//legend[contains(text(),'Preencha justificativa acesso ao cadastro restrito')]")
		public Elemento textoJustificativaHomolog;
		
		//Campo Cliente Justificativa Homolog 
		@MapearElementoWeb(xPath = "//input[contains(@placeholder, 'Digite a justificativa (pelo menos 20 caracteres)...')]")
		//@MapearElementoWeb(xPath = "//input[1]")
		public ElementoInput clienteJustificativaHomolog;
		
		//Botao Desativado Gravar
		@MapearElementoWeb(xPath="//button[contains(@class, 'btn btn--primary') and contains (@disabled, 'disabled')]")
		public ElementoBotao botaoGravarDesativado;
		
		//Botao Ativado Gravar 
		@MapearElementoWeb(xPath="//button[contains(@class, 'btn btn--primary') and contains (@enabled, 'enabled')]")
		public ElementoBotao botaoGravarAtivado;
		
		//Escolher Conta Corrente
		@MapearElementoWeb(xPath="//td[contains(@class, 'cdk-cell cdk-column-modalidade bb-column-modalidade bb-cell ng-star-inserted') and contains (., 'Conta Corrente')]")
		public ElementoBotao escolherContaCorrente;
		
		//Escolher Conta Salario
		@MapearElementoWeb(xPath="//td[contains(@class, 'cdk-cell cdk-column-modalidade bb-column-modalidade bb-cell ng-star-inserted') and contains (., 'Conta Salário')] | td[contains(@class, 'cdk-cell cdk-column-modalidade bb-column-modalidade bb-cell ng-star-inserted') and contains (., 'Conta Corrente')]")
		public ElementoBotao escolherContaSalario;
		
		//Validar Titular da Conta
		@MapearElementoWeb(xPath="//span[contains(@class, 'bb-label-small content') and contains (., 'DANIEL DE OLIVEIRA SATTO')]")
		public ElementoTexto validarTitularConta;
		
		//Validar Agencia
		@MapearElementoWeb(xPath="//span[contains(@class, 'bb-label-small content') and contains (., '551')]")
		public ElementoTexto validarAgencia;
		
		//Validar Agencia
		@MapearElementoWeb(xPath="//span[contains(@class, 'bb-label-small content') and contains (., '5.001')]")
		public ElementoTexto validarContaCorrente;
		
		//Validar Agencia
		@MapearElementoWeb(xPath="//span[contains(@class, 'bb-label-small content') and contains (., '5.001')]")
		public ElementoTexto validarContaSalario;
		
		//Validar Escrita Conta Salario
		@MapearElementoWeb(xPath = "//span[contains(@class, 'bb-caption-small description ng-star-inserted') and contains (., 'Conta Salário')]")
		public ElementoTexto escritaContaSalario;
		
		//Validar Escrita Conta Corrente
		@MapearElementoWeb(xPath = "//span[contains(@class, 'bb-caption-small description ng-star-inserted') and contains (., 'Conta Corrente')]")
		public ElementoTexto escritaContaCorrente;
		
		//Validar Escrita Agencia
		@MapearElementoWeb(xPath = "//span[contains(@class, 'bb-caption-small description ng-star-inserted') and contains (., 'Agência')]")
		public ElementoTexto escritaAgencia;
		
		//Validar Impressao Extrato
		@MapearElementoWeb(xPath="//bb-card-header[contains(., 'Impressão de Extrato')]")
		public ElementoTexto validarImpressaoExtrato;
		
		//Validar Impressao Extrato
		@MapearElementoWeb(xPath="//button[contains(@class, 'selectButton') and contains (., 'Selecione')]")
		public ElementoBotao clicarPeriodo;
		
		//Validar Impressao Extrato
		@MapearElementoWeb(xPath="//a[contains(@title, 'Maio     /2021')]")
		public Elemento escolherPeriodoMaio2021;
		
		//Validar Impressao Extrato
		@MapearElementoWeb(xPath="//a[contains(@title, ' Janeiro  /2015 ')]")
		public Elemento escolherPeriodoJaneiro2015;
		
		//Validar Impressao Extrato
		//@MapearElementoWeb(xPath="//button[contains(@type, 'button') and contains (., 'Pesquisar')]")
		@MapearElementoWeb(xPath = "//button[contains(text(),'Pesquisar')]")
		public ElementoBotao botaoPesquisar;
		
		//Botao Conta Salario
		@MapearElementoWeb(xPath = "//bb-icon[contains(@pack, 'bbds-ui') and contains (@tabindex, '-1') and contains (@class, 'bbds-ui bbds-ui--checkbox-off ng-star-inserted')]")
		public ElementoCheckbox caixaContaSalario;
		
		//Quantidade de Lancamento Maio 2021 Conta Corrente
		@MapearElementoWeb(xPath =  "//span[contains(text(),'59')]")
		public ElementoTexto quantidadeExtratoMaio2021;
		
		//Quantidade de Lancamento Maio 2021 Conta Salario
		@MapearElementoWeb(xPath =  "//span[contains(text(),'2')]")
		public ElementoTexto quantidadeExtratoSalarioMaio2021;
		
		//Quantidade de Lancamento Janeiro 2015
		@MapearElementoWeb(xPath = "//span[contains(text(),'Quantidade de lançamentos')]")
		public ElementoTexto nomeclaturaQuantidade;
		
		//Tabela
		@MapearElementoWeb(xPath =  "//table[1]")
		public ElementoTabela tabelaExtrato;
		
		//Tabela Data Texto
		@MapearElementoWeb(xPath =  "//td[contains(text(),'03/05/2021')]")
		public ElementoTabela tabelaData;
		
		//Tabela Compra com Cartao Texto
		@MapearElementoWeb(xPath =  "//div[contains(text(),'234-Compra com Cartão')]")
		public ElementoTabela tabelaCompraCartao;
		
		//Tabela Compra com Cartao Texto
		@MapearElementoWeb(xPath =  "//div[contains(text(),'02/05 10:45 POSTO SHOPPING III')]")
		public ElementoTabela tabelaCompraLocal;
		
		//Tabela Documento
		@MapearElementoWeb(xPath =  "//td[contains(text(),'138743')]")
		public ElementoTabela tabelaDocumento;
		
		//Tabela Lote
		@MapearElementoWeb(xPath =  "//td[contains(text(),'138743')]")
		public ElementoTabela tabelaLote;
		
		//Tabela Valor
		@MapearElementoWeb(xPath =  "//div[contains(@class, 'ng-star-inserted') and contains (., ' R$              80,00 D ')]")
		public ElementoTabela tabelaValor;
				
		//Tabela Data Texto
		@MapearElementoWeb(xPath =  "//td[contains(text(),'28/05/2021')]")
		public ElementoTabela tabelaDataSalario;
				
		//Tabela Compra com Cartao Texto
		@MapearElementoWeb(xPath =  "//div[contains(text(),'604-Recebimento de Proventos')]")
		public ElementoTabela tabelaCompraSalarioHistorico;		
			
		//Tabela Documento
		@MapearElementoWeb(xPath =  "//td[contains(text(),'4527')]")
		public ElementoTabela tabelaDocumentoSalario;
				
		//Tabela Lote
		@MapearElementoWeb(xPath =  "//td[contains(text(),'14134')]")
		public ElementoTabela tabelaLoteSalario;
				
		//Tabela Valor
		@MapearElementoWeb(xPath =  "//div[contains(@class, 'ng-star-inserted') and contains (., ' R$           6.107,89 C ')]")
		public ElementoTabela tabelaValorSalario;
		
		//Pesquisa por agência e conta não listada
		@MapearElementoWeb(xPath = "//bb-link-nav[1]/div[1]/div[1]/a[1]")
		public ElementoLink pesquisaAgenciaContaNaoListada;
		
		//Pesquisa por agência e conta não listada
		@MapearElementoWeb(xPath =  "//span[contains(text(),'Pesquisa por agência e conta não listada')]")
		public ElementoTexto textoPopUPAgenciaContaNaoListada;
		
		//Pesquisa por agência e conta não listada
		//@MapearElementoWeb(id = "e840bde3-04e5-45e5-bf92-e6ba68b2cc57")
		@MapearElementoWeb (xPath ="//input[contains(@placeholder,'Informe a Agência') and contains (@tabindex, '0')]")
		public ElementoInput campoAgenciaNaoListada;
		
		//Pesquisa por agência e conta não listada
		//@MapearElementoWeb(id = "e299b2a0-638a-45c6-985b-fd2970d6291e")
		@MapearElementoWeb (xPath ="//input[contains(@placeholder,'Informe a Conta') and contains (@tabindex, '1')]")
		public ElementoInput campoContaNaoListada;
		
		//Pesquisa por agência e conta não listada
		@MapearElementoWeb(xPath = "//span[contains(text(),'Conta Salário')]")
		public ElementoTexto contaSalarioNaoListada;
		
		//Escolher Pesquisa por agência e conta não listada
		@MapearElementoWeb(xPath = "//bb-card-body[1]/div[2]/bb-checkbox-group[1]/div[1]/bb-checkbox[1]/div[1]/div[1]/bb-icon[1]")
		public Elemento boxSalarioNaoListada;
		
		//Botao Cancelar do Pop UP  agência e conta não listada
		@MapearElementoWeb(xPath = "//button[contains(text(),'Cancelar')]")
		public ElementoBotao botaoCancelarNaoListada;
		
		//Botao Pesquisar do Pop  UP  agência e conta não listada
		@MapearElementoWeb(xPath ="//button[contains(text(),'Pesquisar')]")
		public ElementoBotao botaoPesquisarNaoListada;
		
		//Box Lista de Contas
		@MapearElementoWeb(xPath = "//bb-card-body[1]")
		public Elemento reconhecerPopUp;
		
		//Box Lista de Contas
		@MapearElementoWeb(xPath = "//span[contains(., 'Voltar')]")
		public ElementoBotao botaoVoltar;
		
		//Botao Download
		@MapearElementoWeb(xPath = "//bb-card-body[1]/div[1]/div[1]/bb-icon[1]")
		public Elemento botaoDownload;
		
		//botao Cobrar Tarifa
		@MapearElementoWeb(xPath = "//div[contains(@aria-labelledby, 'lbl1') and contains (@aria-disabled, 'false')]")
		public Elemento botaoCobrarTarifa;
		
		//Escolher Tipo Arquivo Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'p-dropdown-trigger-icon ng-tns-c25-71 pi pi-chevron-down')]")
		public Elemento selecionarTipoArquivo;
		
		//Escolher Arquivo Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'ng-tns-c25-71 p-dropdown-label p-inputtext p-placeholder ng-star-inserted') and contains (., 'Arquivo')] ")
		public ElementoBotao SelecionarArquivo;
		
		//Escolher CSV Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'ng-star-inserted') and contains (., 'csv')]")
		public ElementoBotao SelecionarCSV;
		
		//Escolher PDF Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'ng-star-inserted') and contains (., 'pdf')]")
		public ElementoBotao SelecionarPDF;
		
		//Escolher txt Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'ng-star-inserted') and contains (., 'txt')]")
		public ElementoBotao SelecionarTxt;
		
		//Escolher ofx Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'ng-star-inserted') and contains (., 'ofx')]")
		public ElementoBotao SelecionarOfx;
		
		//Escolher bbt Donwload
		@MapearElementoWeb(xPath = "//span[contains(@class, 'ng-star-inserted') and contains (., 'bbt')]")
		public ElementoBotao SelecionarBBT;
		
		//Botao Download
		@MapearElementoWeb(xPath = "//button[contains(text(),'Salvar')]")
		public ElementoBotao BotaoSalvarDownload;
		
		//Arquivo Download
		@MapearElementoWeb(xPath = "Extrato-ag551-cc5001_5-2021.csv")
		public Elemento arquivoDownloadCSV;
		
		//Arquivo Download
		@MapearElementoWeb(xPath = "Extrato-ag551-cc5001_5-2021.pdf")
		public Elemento arquivoDownloadPDF;
		
		//InicioDoLancamento
		@MapearElementoWeb(xPath = "/html/body/deb-app-root/bb-layout/div[1]/div/div/div/div/bb-layout-column/gaw-template-base/div/div/div/deb-extrato/bb-card[1]/bb-card-body/div[2]/bb-card/bb-card-body/div/bb-date-field[1]/bb-text-field/div/input")
		public ElementoInput dataInicioLancamento;
		
		//FimDoLancamento
		@MapearElementoWeb(xPath = "/html/body/deb-app-root/bb-layout/div[1]/div/div/div/div/bb-layout-column/gaw-template-base/div/div/div/deb-extrato/bb-card[1]/bb-card-body/div[2]/bb-card/bb-card-body/div/bb-date-field[2]/bb-text-field/div/input")
		public ElementoInput dataFimLancamento;
		
		//Botao Histórico
		@MapearElementoWeb(xPath = "/html/body/deb-app-root/bb-layout/div[1]/div/div/div/div/bb-layout-column/gaw-template-base/div/div/div/deb-extrato/bb-card[1]/bb-card-body/div[2]/bb-card/bb-card-body/div/bb-select-field[1]/button")
		public ElementoBotao botaoHistorico;
		
		//Botao Tipo Lancamento
		@MapearElementoWeb(xPath = "/html/body/deb-app-root/bb-layout/div[1]/div/div/div/div/bb-layout-column/gaw-template-base/div/div/div/deb-extrato/bb-card[1]/bb-card-body/div[2]/bb-card/bb-card-body/div/bb-select-field[2]/button")
		public ElementoBotao botaoTipoLancamento;
		
		//Botao Filtrar
		@MapearElementoWeb(xPath = "//button[contains(., 'Filtrar') and contains (@class, 'bb-button secondary size-regular')]")
		public ElementoBotao botaoFiltrar; 
		
		//Baixar Lancamentos
		@MapearElementoWeb(xPath = "//bb-icon[contains(@aria-label, 'baixar arquivos')]")
		public Elemento BotaoBaixarArquivos;
		
		//Tipo de Arquivo para download
		@MapearElementoWeb(xPath = "//span[contains(., 'Arquivo')]")
		public Elemento BotaoArquivo;
		
		//Verificar Email
		@MapearElementoWeb(xPath = "//bb-icon[contains(@aria-label, 'mensagem')]")
		public Elemento Email;
		
		//Enviar Por Email
		@MapearElementoWeb(xPath = "//span[contains(., 'Enviar por-email')]")
		public Elemento EnviarEmail;
		
		//EmailDoCliente
		@MapearElementoWeb(xPath = "//span[contains(., 'Email do cliente:')]")
		public ElementoTexto EmailDoCliente;
		
		//Cliente Nao Possui Permissao Para Email
		@MapearElementoWeb(xPath = "//span[contains(., 'Cliente não possui permissão para acessar o serviço.')]")
		public ElementoTexto ClienteNaoPossuiPermissao;		
		
		
			public DEB_Extrato_Page() {
		super();
			}
			
		public void informarAgencia(String tipoAgencia) throws ElementoNaoLocalizadoException {		
		campoAgenciaNaoListada.escrever(tipoAgencia);
		}
					
		public void informarConta(String tipoConta) throws ElementoNaoLocalizadoException {		
		campoContaNaoListada.escrever(tipoConta);
		}
		
		public static class DEB_Extrato_Page_modal extends PaginaPlataformaModal {

		//Campo Cliente Justificativa Homolog
		@MapearElementoWeb(xPath = "//input[contains(@placeholder, 'Digite a justificativa (pelo menos 20 caracteres)...')]")
		public ElementoInput clienteJustificativaHomolog;

		public void informarJustificativa(String tipoJustificativa) throws ElementoNaoLocalizadoException {		
			clienteJustificativaHomolog.escrever(tipoJustificativa);
			}
	
		}
	}