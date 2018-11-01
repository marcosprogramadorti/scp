package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	
	@PostMapping
	@PermitAll
	//@Secured({"ROLE_PESSOA-FISICA_CONSULTAR"})
	public ResponseEntity<List<Pessoa>> pesquisar ( @RequestBody PessoaFiltroTO filtro) {
		
		List<Pessoa> pessoas =  pessoaRepository.pesquisar(filtro);
		
		if (pessoas == null) {
			return  ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
		
	}
	
}
