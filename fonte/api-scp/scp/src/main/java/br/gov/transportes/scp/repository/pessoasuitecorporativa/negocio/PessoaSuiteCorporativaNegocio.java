package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.gov.transportes.scp.Constantes;
import br.gov.transportes.scp.config.property.ScpServiceProperty;
import br.gov.transportes.scp.model.SolicitacaoAcessoArquivo;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.ArquivoTO;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.PessoaTO;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.UfTO;
import br.gov.transportes.scp.resource.Converter;
import br.gov.transportes.scp.resource.FileUtil;
import br.gov.transportes.scp.resource.RequestUtil;

@Component
public class PessoaSuiteCorporativaNegocio {

	// TODO: configurar o arquivo de propriedade
	// @Autowired
	// ScpServiceProperty scpServiceProperty;

	@Autowired
	private RequestUtil requestUtil;

	@Autowired
	ScpServiceProperty scpServiceProperty;

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

	public ResponseEntity<Object> buscarPessoaPorCpfInfoconv(String cpf, String tipoVinculo) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA_BUSCAR_POR_CPF_INFOCONV
				+ cpf + '/' + tipoVinculo;
		ResponseEntity<Object> responseEntity = null;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
		} catch (Exception e) {
			return null;
		}

		return responseEntity;

	}

	public ResponseEntity<Object> buscarPessoaPorCnpjInfoconv(String cnpj, String tipoVinculo) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA_BUSCAR_POR_CNPJ_INFOCONV
				+ cnpj + '/' + tipoVinculo;
		ResponseEntity<Object> responseEntity = null;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
		} catch (Exception e) {
			return null;
		}

		return responseEntity;

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

	public ResponseEntity<Object> buscarPorId(Long id) {

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_PESSOA + id;

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

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_LISTA_LOGRADOUROS_POR_CEP
				+ nrCep;

		final String url = URL_SUITE_CORP;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

		return responseEntity;

	}

	public ArquivoTO uploadArquivo(MultipartFile multipartFile, ArquivoTO solicitacaoAcessoAnexo) {

		ArquivoTO arquivoSalvo = null;

		String URL_SUITE_CORP = Constantes.URL_SUITE_CORP_SERVICE + Constantes.SERVICO_ARQUIVO_UPLOAD;

		final String url = URL_SUITE_CORP;

		int indiceExtensao = solicitacaoAcessoAnexo.getNmArquivoFisico().lastIndexOf(".");
		String nomeLogico = solicitacaoAcessoAnexo.getNmArquivoLogico();
		if (indiceExtensao > -1) {
			nomeLogico = nomeLogico + solicitacaoAcessoAnexo.getNmArquivoFisico().substring(indiceExtensao);
		}
		File file;
		try {
			file = FileUtil.streamToFile(multipartFile.getInputStream(), solicitacaoAcessoAnexo.getNmArquivoFisico());
			arquivoSalvo = Converter.convertJSONToObject(
					requestUtil.postFile(url, file, new String(Base64.encode(nomeLogico.getBytes()), "UTF-8"), true),
					ArquivoTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arquivoSalvo;
	}

	public ResponseEntity<Object> buscarUsuarioPorLogin(String login) {

		String URL_SCA_SERVICE = scpServiceProperty.getUrlScaService();
		final String url = URL_SCA_SERVICE + login;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(HttpStatus.GONE);
		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
			return responseEntity;
		}
		return responseEntity;
	}

}
