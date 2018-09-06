package br.gov.transportes.scp.resource;

import java.net.URI;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.transportes.scp.model.DetalhePessoaFisica;
import br.gov.transportes.scp.repository.detalhepessoafisica.interfaces.DetalhePessoaFisicaInterRepository;

@RestController
@RequestMapping("/detalhePessoaFisica")
public class DetalhePessoaFisicaResource {
	
	@Autowired
	private DetalhePessoaFisicaInterRepository detalhePessoaFisicaInterRepository; 
	
	@PostMapping
	@PermitAll
	public ResponseEntity<DetalhePessoaFisica> salvar( @RequestBody DetalhePessoaFisica detalhePessoaFisica, HttpServletResponse response ) {
		
		DetalhePessoaFisica detalhePessoaFisicaSalva = detalhePessoaFisicaInterRepository.saveAndFlush(detalhePessoaFisica);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(detalhePessoaFisicaSalva.getId()).toUri();
		return ResponseEntity.created(uri).body(detalhePessoaFisicaSalva);
	}
	
	
	@GetMapping("/{id}")
	@PermitAll
	public Optional<DetalhePessoaFisica> buscarPorId (@PathVariable Long id) {
		return detalhePessoaFisicaInterRepository.findById(id);
	}
	
}
