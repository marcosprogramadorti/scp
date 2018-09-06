package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import br.gov.transportes.scp.Constantes;
import br.gov.transportes.scp.config.property.ScpServiceProperty;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.PessoaTO;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.UfTO;


@Component
public class PessoaSuiteCorporativaNegocio {
	
	//TODO: configurar o arquivo de propriedade
//	@Autowired
//	ScpServiceProperty scpServiceProperty; 
	
	public ResponseEntity<Object[]> pesquisar(PessoaTO pessoa) {

		
		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA_PESQUISA;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PessoaTO> entity = new HttpEntity<PessoaTO>(pessoa, headers);

		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(url, entity, Object[].class);

		return responseEntity;

	}
	public PessoaTO salvarOuAtualizar(PessoaTO pessoa) {

		
		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA_SALVAR_OU_ATUALIZAR;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "usuario.spl");
		HttpEntity<PessoaTO> entity = new HttpEntity<PessoaTO>(pessoa, headers);
		ResponseEntity<PessoaTO> pessoaSalva = restTemplate.postForEntity(url, entity, PessoaTO.class);
		System.out.println(pessoaSalva.getBody());
		return pessoaSalva.getBody();

	}
	
	public ResponseEntity<Object> buscarPessoaPorCpf(String cpf) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA_BUSCAR_POR_CPF + cpf;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;

	}
	public ResponseEntity<Object> buscarPessoaPorCnpj(String cnpj) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA_BUSCAR_POR_CNPJ + cnpj;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;

	}
	
	
	public ResponseEntity<Object> listaDeTipoDeLogradourosAtivos() {
		
		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_LISTA_TIPO_LOGRADOURO;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;
		
	}
	
	public ResponseEntity<Object> listaDeUfs() {
		
		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_LISTA_UFS;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;
		
	}
	
	public ResponseEntity<Object[]> listaLocalidadesPorUf(UfTO uf) {

		
		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_LISTA_LOCALIDADES_POR_UF;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UfTO> entity = new HttpEntity<UfTO>(uf, headers);

		ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(url, entity, Object[].class);

		return responseEntity;

	}
	public ResponseEntity<Object> localidadePorId(Long id) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_LISTA_lOCALIDADES_POR_ID + id;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;

	}
	
	public ResponseEntity<Object> logradouroPorCep(String nrCep) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_LISTA_LOGRADOUROS_POR_CEP + nrCep;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;

	}
	
	

}
