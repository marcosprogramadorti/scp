package br.gov.transportes.scp;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.transportes.scp.config.property.ScpServiceProperty;

public class Constantes implements Serializable {
	
	//FIXME:refazer para pegar do arquivo properties
	@Autowired
	ScpServiceProperty scpServiceProperty; 
	

	private static final long serialVersionUID = 6011917248514374461L;
	public static final String SERVICO_PESSOA = "pessoas/";
	public static final String SERVICO_PESSOA_PESQUISA = "pessoas/pesquisar";
	public static final String SERVICO_PESSOA_SALVAR_OU_ATUALIZAR = "pessoas";
	public static final String SERVICO_PESSOA_BUSCAR_POR_CPF = "pessoas/buscarPorCpf/";
	public static final String SERVICO_PESSOA_BUSCAR_POR_CPF_INFOCONV = "infoconv/cpf/";
	public static final String SERVICO_PESSOA_BUSCAR_POR_CNPJ_INFOCONV = "infoconv/cnpj/";
	public static final String SERVICO_PESSOA_BUSCAR_POR_CNPJ = "pessoas/buscarPorCnpj/";
	public static final String SERVICO_LISTA_TIPO_LOGRADOURO = "tipoLogradouros/ativos/";
	public static final String SERVICO_LISTA_UFS = "ufs";
	public static final String SERVICO_LISTA_lOCALIDADES_POR_ID = "localidades/";
	public static final String SERVICO_LISTA_LOCALIDADES_POR_UF = "localidades/listarPorUf";
	public static final String SERVICO_LISTA_LOGRADOUROS_POR_CEP = "logradouro/buscarPorCep/";
	public static final String URL_SUITE_CORP_SERVICE = "https://suitecorporativa.dev.mt.transportes.gov.br/suitecorporativa-restClient/service/";
	public static final String SERVICO_ARQUIVO_UPLOAD = "arquivos/upload";
}
