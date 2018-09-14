package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.transportes.scp.model.Pessoa;

import br.gov.transportes.scp.repository.pessoa.interfaces.PessoaRepository;
import br.gov.transportes.scp.repository.pessoa.negocio.PessoaFiltroTO;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository; 
	
	
	
	@GetMapping()
	@PermitAll
	public ResponseEntity<List<Pessoa>> buscaPorCPF (PessoaFiltroTO filtro) {
		
		List<Pessoa> pessoas =  pessoaRepository.pesquisar(filtro);
		
		if (pessoas == null) {
			return  ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
		
	}
	
}
