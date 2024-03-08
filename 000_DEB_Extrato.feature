#encoding: iso-8859-1
#Author : Diogo Rangel (minsait/Indra)#####
####language: pt########
# encoding: UTF-8


@000_DEB_Extrato_TesteCompleto
Feature: DEB Extrato Testes Cenarios

				
		@001_DEB_Extrato_ContaCorrente_AcessoExtratoContaCorrente
		Scenario: Acesso Extrato de Conta Corrente
		    Given Realizo o Login na Plataforma e acesso o Negocios
				When Entro em Extrato de Conta Corrente
				Then Fecho Pagina Atual
				
		@002_DEB_Extrato_ContaCorrente_AcessoExtratoContaCorrentesMesAnterior
		Scenario: Acesso o link de Extrato de Conta Corrente Meses Anteriores
		    Given Realizo o Login na Plataforma e acesso o Negocios
				When Entro em Conta Corrente Meses Anteriores
				Then Fecho Pagina Atual
				
		@003_DEB_Extrato_ContaCorrente_EscolherMCIJustificativa
		Scenario: Acesso Extrato de Conta Corrente e busco um MCI com Justificativa
		    Given Realizo o Login na Plataforma e acesso o Negocios
				When Entro em Extrato de Conta Corrente
				And Escolho Cliente por MCI com Justificativa "Validar teste preecher campo justificativa com ate 21 caracteres"
				And Entro em Conta Corrente Meses Anteriores
				And Escolho Cliente por MCI com Justificativa "Validar teste preecher campo justificativa com ate 21 caracteres"
				Then Fecho Pagina Atual
		
		@004_DEB_Extrato_ContaCorrente_EscolherMCIExtratoMesesAnteriores
		Scenario: Acesso Extrato de Conta Corrente Meses Anteriores com MCI Justificativa
				Given Realizo o Login na Plataforma e acesso o Negocios
				When Entro em Conta Corrente Meses Anteriores
				And Escolho Cliente por MCI com Justificativa "Validar teste preecher campo justificativa com ate 21 caracteres"
				Then Fecho Pagina Atual
				
		@005_DEB_Extrato_ContaCorrente_EscolherMCI
		Scenario: Acesso Extrato de Conta Corrente e busco um MCI
		    Given Realizo o Login na Plataforma e acesso o Negocios
				When Entro em Extrato de Conta Corrente
				And Escolher Cliente por MCI
				And Entro em Conta Corrente Meses Anteriores
				Then Fecho Pagina Atual
				
		@006_DEB_Extrato_ContaCorrente_EscolherAgenciaConta
		Scenario: Acesso Extrato de Conta Corrente e busco Agencia e Conta
		    Given Realizo o Login na Plataforma e acesso o Negocios
				When Entro em Extrato de Conta Corrente
				And Escolher Cliente por Agencia e Conta
				Then Fecho Pagina Atual
				
		#@007_DEB_Extrato_ContaCorrente_EscolherMCIMesesAnteiores
		#Scenario: Acesso Extrato de Conta Corrente e busco um MCI em Meses Anteriores
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
				#When Escolher Cliente por MCI Meses Anteriores
				#Then Fecho Pagina Atual
				
		#@008_DEB_Extrato_ContaCorrente_EscolherAgenciaContaMesesAnteriores
		#Scenario: Acesso Extrato de Conta Corrente e busco Agencia e Conta Meses Anteriores
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por MCI Meses Anteriores
				#Then Fecho Pagina Atual
				
		@009_DEB_Extrato_ContaCorrente_EscolherContaSalarioAgenciaConta
		Scenario: Acesso Extrato de Conta Corrente Escolher Conta Salario Via Agencia e Conta
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				Then Fecho Pagina Atual
				
		@010_DEB_Extrato_ContaCorrente_EscolherContaCorrenteAgenciaConta
		Scenario: Acesso Extrato de Conta Corrente Meses Anteriores Escolher Conta Corrente Via Agencia e Conta
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				Then Fecho Pagina Atual
				
		@011_DEB_Extrato_ContaCorrente_EscolherContaSalarioMCI
		Scenario: Acesso Extrato de Conta Corrente Escolher Conta Salario Via MCI
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				Then Fecho Pagina Atual
				
		@012_DEB_Extrato_ContaCorrente_EscolherContaCorrenteMCI
		Scenario: Acesso Extrato de Conta Corrente Meses Anteriores Escolher Conta Corrente Via MCI
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por MCI
				And Escolher Conta Salario
				Then Fecho Pagina Atual
				
		@013_DEB_Extrato_ContaCorrente_ValidarExtratoMaio2021
		Scenario: Validar Extrato Anterior Maio 2021
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				#Then Fecho Pagina Atual
				
		#@014_DEB_Extrato_ContaCorrente_ValidarExtratoMaio2021ViaMCI
		#Scenario: Validar Extrato Anterior Maio 2021 Via MCI
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por MCI
				#And Escolher Conta Corrente
				#And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				#Then Fecho Pagina Atual
				
		#@015_DEB_Extrato_ContaCorrente_ContaSalarioValidarExtratoMaio2021
		#Scenario: Validar Extrato Anterior Maio 2021 Conta Salario
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#Then Fecho Pagina Atual
				
		#@016_DEB_Extrato_ContaCorrente_ContaSalarioValidarExtratoMaio2021ViaMCI
		#Scenario: Validar Extrato Anterior Maio 2021 Via MCI
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por MCI
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#Then Fecho Pagina Atual
		
		@017_DEB_Extrato_ContaCorrente_CancelarPesquisaAgenciaContaNaoListada
		Scenario: Validar Cancelamento de Pesquisa de Agencia e conta Nao Listada
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Pesquisa por agencia e conta nao listada
				And Cancelar Pesquisa por agencia e conta nao listada
				Then Fecho Pagina Atual
				
		@018_DEB_Extrato_ContaCorrente_PesquisarAgenciaContaNaoListada
		Scenario: Validar Pesquisar Agencia e conta Nao Listada
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Pesquisa por agencia e conta nao listada
				And Pesquisar por agencia e conta corrente nao listada "551" "5001"
				Then Fecho Pagina Atual
				
		@019_DEB_Extrato_ContaCorrente_PesquisarContaNaoListadaValidarExtratoMaio2021
		Scenario: Validar Pesquisar Agencia e conta Nao Listada Validar Extrato Maio 2021
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Pesquisa por agencia e conta nao listada
				And Pesquisar por agencia e conta corrente nao listada "551" "5001"
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				Then Fecho Pagina Atual
				
		@020_DEB_Extrato_ContaSalario_PesquisarContaNaoListadaValidarExtratoMaio2021
		Scenario: Validar Pesquisar Agencia e conta Nao Listada Validar Extrato Maio 2021
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Pesquisa por agencia e conta nao listada
				And Pesquisar por agencia e conta salario nao listada "551" "5001"
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
  			Then Fecho Pagina Atual
  			
  	@021_DEB_Extrato_ContaCorrente_ClicoBotaoVoltarExtratoExibido
		Scenario: Validar Clico no Botao Voltar
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Clico no botao Voltar
				Then Fecho Pagina Atual
				
		@022_DEB_Extrato_ContaSalario_ClicoBotaoVoltarExtratoExibido
		Scenario: Validar Clico no Botao Voltar
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				And Clico no botao Voltar
				Then Fecho Pagina Atual
				
		#@023_DEB_Extrato_ContaCorrente_ClicoValidoDownloadExtrato
		#Scenario: Validar Download Extrato Conta Corrente sem tarifa
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Corrente
				#And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				#And Realizo e valido o download do Extrato sem tarifa
				#Then Fecho Pagina Atual
				
		#@024_DEB_Extrato_ContaSalario_ClicoValidoDownloadExtrato
		#Scenario: Validar Download Extrato Conta Salario sem tarifa
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#And Conta salario realizo e valido o download do Extrato sem tarifa
				#Then Fecho Pagina Atual
				
		#@025_DEB_Extrato_ContaCorrente_ClicoValidoDownloadExtratoComTarifa
		#Scenario: Validar Download Extrato Conta Corrente com tarifa
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Corrente
				#And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				#And Realizo e valido o download do Extrato com tarifa
				#Then Fecho Pagina Atual
				
		#@026_DEB_Extrato_ContaSalario_ClicoValidoDownloadExtrato
		#Scenario: Validar download do Extrato com tarifa Conta Salario
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#And Conta salario realizo e valido o download sem poder ativar a tarifa
				#Then Fecho Pagina Atual
				
		@027_DEB_Extrato_ContaCorrente_ValidoDownloadExtratoSemTarifaCSV
		Scenario: Validar Download Extrato Conta Corrente sem tarifa CSV
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato sem tarifa
				And Valido o download CSV do Extrato
				Then Fecho Pagina Atual
				
		@028_DEB_Extrato_ContaCorrente_ValidoTarifaPDFDownloadExtrato
		Scenario: Validar Download Extrato Conta Corrente sem tarifa PDF
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato com tarifa
				And Realizo e valido o download PDF do Extrato
				Then Fecho Pagina Atual
				
	@029_DEB_Extrato_ContaSalario_ValidoDownloadExtratoSalarioSemTarifaPDF
		Scenario: Validar Download Extrato Conta Salario sem tarifa PDF
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				And Conta salario realizo e valido o download do Extrato sem tarifa
				And Valido Conta Salario o download PDF do Extrato
				Then Fecho Pagina Atual
				
	@030_DEB_Extrato_ContaSalario_ValidoDownloadExtratoSalarioSemTarifaCSV
		Scenario: Validar Download Extrato Conta Salario sem tarifa CSV
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				And Conta salario realizo e valido o download do Extrato sem tarifa
				And Seleciono Conta Salario o download CSV do Extrato
				Then Fecho Pagina Atual
				
	@031_DEB_Extrato_ContaCorrente_ValidoTarifaTXTDownloadExtratoSemTarifa
		Scenario: Validar Download Extrato Conta Corrente sem tarifa TXT
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato sem tarifa
				And Realizo e Valido o download TXT do Extrato
				Then Fecho Pagina Atual
				
				
	@032_DEB_Extrato_ContaCorrente_ValidoTarifaTXTDownloadExtratoComTarifa
		Scenario: Validar Download Extrato Conta Corrente com tarifa TXT
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato com tarifa
				And Realizo e Valido o download TXT do Extrato
				Then Fecho Pagina Atual
				
	@033_DEB_Extrato_ContaCorrente_ValidoTarifaOFXIDownloadExtratoSemTarifa
		Scenario: Validar Download Extrato Conta Corrente sem tarifa OFX
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato sem tarifa
				And Realizo e Valido o download OFX do Extrato
				Then Fecho Pagina Atual
				
				
	@034_DEB_Extrato_ContaCorrente_ValidoTarifaOFXDownloadExtratocomTarifa
		Scenario: Validar Download Extrato Conta Corrente com tarifa OFX
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato com tarifa
				And Realizo e Valido o download OFX do Extrato
				Then Fecho Pagina Atual
				
	@035_DEB_Extrato_ContaCorrente_ValidoTarifaBBTDownloadExtratosemTarifa
		Scenario: Validar Download Extrato Conta Corrente sem tarifa BBT
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Corrente
				And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				And Realizo e valido o download do Extrato sem tarifa
				And Realizo e Valido o download BBT do Extrato
				Then Fecho Pagina Atual
				
	#@036_DEB_Extrato_ContaCorrente_ValidoTarifaBBTDownloadExtratocomTarifa
		#Scenario: Validar Download Extrato Conta Corrente com tarifa BBT
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Corrente
				#And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
				#And Realizo e valido o download do Extrato com tarifa
				#And Realizo e Valido o download BBT do Extrato
				#Then Fecho Pagina Atual
				
	@037_DEB_Extrato_ContaSalario_ValidoDownloadContaSalarioSemTarifaTXT
		Scenario: Validar Download Extrato Conta Salario sem tarifa TXT
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				And Seleciono Conta Salario o download TXT do Extrato
				Then Fecho Pagina Atual
				
	#@038_DEB_Extrato_ContaSalario_ValidoDownloadContaSalarioComTarifaTXT
		#Scenario: Validar Download Extrato Conta Salario sem tarifa TXT
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato 	de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#And Seleciono Conta Salario o download TXT do Extrato
				#And Realizo e valido o download do Extrato com tarifa
				#Then Fecho Pagina Atual
				
	@039_DEB_Extrato_ContaSalario_ValidoDownloadContaSalarioSemTarifaOFX
		Scenario: Validar Download Extrato Conta Salario sem tarifa OFX
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				And Seleciono Conta Salario o download OFX do Extrato
				Then Fecho Pagina Atual
				
	#@040_DEB_Extrato_ContaSalario_ValidoDownloadContaSalarioComTarifaOFX
		#Scenario: Validar Download Extrato Conta Salario sem tarifa TXT
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#And Seleciono Conta Salario o download OFX do Extrato
				#And Realizo e valido o download do Extrato com tarifa
				#Then Fecho Pagina Atual
				
	@041_DEB_Extrato_ContaSalario_ValidoDownloadContaSalarioSemTarifaBBT
		Scenario: Validar Download Extrato Conta Salario sem tarifa BBT
		    Given Realizo o Login na Plataforma e acesso o Negocios
		    When Entro em Extrato de Conta Corrente
		    And Escolher Cliente por Agencia e Conta
				And Escolher Conta Salario
				And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				And Seleciono Conta Salario o download BBT do Extrato
				Then Fecho Pagina Atual
				
	#@042_DEB_Extrato_ContaSalario_ValidoDownloadContaSalarioComTarifaBBT
		#Scenario: Validar Download Extrato Conta Salario sem tarifa BBT
		    #Given Realizo o Login na Plataforma e acesso o Negocios
		    #When Entro em Extrato de Conta Corrente
		    #And Escolher Cliente por Agencia e Conta
				#And Escolher Conta Salario
				#And Validar Titular e Agencia e Conta Salario na Tela Extrato Maio 2021
				#And Seleciono Conta Salario o download BBT do Extrato
				#And Realizo e valido o download do Extrato com tarifa
				#Then Fecho Pagina Atual
				