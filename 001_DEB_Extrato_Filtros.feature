#Author: drangeld@minsait.com
#encoding: iso-8859-1
#Author : Diogo Rangel (minsait/Indra)#####
####language: pt########
# encoding: UTF-8

@000_DEB_Extrato_Filtros_TesteCompleto
Feature: Extrato Filtros Filtros Cenários

  @001_DEB_Extrato_Filtros_ValidoFiltros
  Scenario: Valido Filtros
     Given Realizo o Login na Plataforma e acesso o Negocios
		 When Entro em Extrato de Conta Corrente
		 And Escolher Cliente por MCI
		 And Escolher Conta Corrente
		 And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
		 And Validar os filtros da tela Extrato de Meses Anteriores
		 Then Fecho Pagina Atual

  @002_DEB_Extrato_Filtros_PainelBaixarArquivos
  Scenario: Validar Painel Baixar Arquivos
     Given Realizo o Login na Plataforma e acesso o Negocios
		 When Entro em Extrato de Conta Corrente
		 And Escolher Cliente por MCI
		 And Escolher Conta Corrente
		 And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
		 And Validar os filtros da tela Extrato de Meses Anteriores
		 And Valido a exibicao do painel de baixar arquivos e Email
		 Then Fecho Pagina Atual
		 
	@003_DEB_Extrato_Filtros_ValidarClienteSemServiçoEmail
  Scenario: Validar Cliente não tem Serviço de E-mail
     Given Realizo o Login na Plataforma e acesso o Negocios
		 When Entro em Extrato de Conta Corrente
		 And Escolher Cliente por MCI
		 And Escolher Conta Corrente
		 And Validar Titular e Agencia e Conta Corrente na Tela Extrato Maio 2021
		 And Validar os filtros da tela Extrato de Meses Anteriores
		 And Valido a exibicao do painel de baixar arquivos e Email
		 And Valido Cliente sem servico de Email
		 Then Fecho Pagina Atual
		 
	@004_DEB_Extrato_Filtros_EntroNoEmail
  Scenario: Entrar no Email
  	Given Realizo o Login na Plataforma e acesso o Negocios
    When Valido envio do arquivo lancamentos no SMPT
		Then Fecho Pagina Atual
