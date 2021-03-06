package br.gov.transportes.scp.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.transportes.scp.model.SolicitacaoAcessoArquivo;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.PessoaSuiteCorporativaNegocio;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.ArquivoTO;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.PessoaTO;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.UfTO;

@RestController
@RequestMapping("/suiteCorporativa")
public class PessoaSuiteCorporativaResource{
	
	@Autowired
	PessoaSuiteCorporativaNegocio pessoaSuiteCorporativaNegocio;
	@PostMapping("pessoas/pesquisar")
	public ResponseEntity<Object> pesquisar( @RequestBody PessoaTO pessoa, HttpServletResponse response ) {
		
		
		ResponseEntity<Object[]> responseEntity  = pessoaSuiteCorporativaNegocio.pesquisar(pessoa);
		
		Object[] lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista.length == 0) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	@PostMapping("pessoas/salvarOuAtualizar")
	public ResponseEntity<PessoaTO> criarPessoaSuite( @RequestBody PessoaTO pessoa, HttpServletResponse response ) {
		PessoaTO pessoaSalva  = pessoaSuiteCorporativaNegocio.salvarOuAtualizar(pessoa);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	
	@GetMapping("pessoas/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id")  Long id)  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.buscarPorId(id);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	@GetMapping("pessoas/buscarPessoaPorCpf/{cpf}")
	public ResponseEntity<Object> buscarPessoaPorCpf(@PathVariable("cpf")  String cpf)  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.buscarPessoaPorCpf(cpf);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	@GetMapping("pessoas/buscarPessoaPorCpfInfoconv/{cpf}/{tipoVinculo}")
	public ResponseEntity<Object> buscarPessoaPorCpfInfoconv(@PathVariable("cpf")  String cpf, @PathVariable("tipoVinculo")String tipoVinculo)  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.buscarPessoaPorCpfInfoconv(cpf, tipoVinculo);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	@GetMapping("pessoas/buscarPessoaPorCnpjInfoconv/{cnpj}/{tipoVinculo}")
	public ResponseEntity<Object> buscarPessoaPorCnpjInfoconv(@PathVariable("cnpj")  String cnpj, @PathVariable("tipoVinculo")String tipoVinculo)  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.buscarPessoaPorCnpjInfoconv(cnpj, tipoVinculo);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	@GetMapping("pessoas/buscarPessoaPorCnpj/{cnpj}")
	public ResponseEntity<Object> buscarPessoaPorCnpj(@PathVariable("cnpj")  String cnpj)  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.buscarPessoaPorCnpj(cnpj);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	
	@PostMapping("/localidadesPorUf")
	public ResponseEntity<Object> pesquisar( @RequestBody UfTO uf, HttpServletResponse response ) {
		
		
		ResponseEntity<Object[]> responseEntity  = pessoaSuiteCorporativaNegocio.listaLocalidadesPorUf(uf);
		
		Object[] lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista.length == 0) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	@GetMapping("localidadePorId/{id}")
	public ResponseEntity<Object> localidadePorId(@PathVariable("id")  Long id)  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.localidadePorId(id);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	
	
	@GetMapping("/listarTiposLogradouro")
	public ResponseEntity<Object> tiposLogradouroListarTodosAtivos()  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.listaDeTipoDeLogradourosAtivos();
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	@GetMapping("/ufs")
	public ResponseEntity<Object> ufsListarTodos()  {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.listaDeUfs();
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	
	@GetMapping("/logradouroPorCep/{nrCep}")
	public ResponseEntity<Object> logradouroPorCep( @PathVariable("nrCep") String nrCep ) {
		
		
		ResponseEntity<Object> responseEntity  = pessoaSuiteCorporativaNegocio.logradouroPorCep(nrCep);
		
		Object lista = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		if (lista == null) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista); 
	}
	
	
	@PostMapping(value = "arquivos/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ArquivoTO> uploadArquivo(@RequestPart("file") MultipartFile file,
			@RequestPart("arquivoTO") ArquivoTO solicitacaoAcessoAnexo) {
//		return null;
		ArquivoTO arquivoSalvo = pessoaSuiteCorporativaNegocio.uploadArquivo(file, solicitacaoAcessoAnexo);
		
		if (arquivoSalvo == null) {
			return  ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(arquivoSalvo);
	}

}
