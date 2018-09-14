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
import br.gov.transportes.scp.model.DetalhePessoaJuridica;
import br.gov.transportes.scp.repository.detalhepessoajuridica.interfaces.DetalhePessoaJuridicaRepository;

@RestController
@RequestMapping("/detalhePessoaJuridica")
public class DetalhePessoaJuridicaResource {
	
	@Autowired
	private DetalhePessoaJuridicaRepository detalhePessoaJuridicaRepository; 
	
	@PostMapping
	@PermitAll
	public ResponseEntity<DetalhePessoaJuridica> salvar( @RequestBody DetalhePessoaJuridica detalhePessoaJuridica, HttpServletResponse response ) {
		
		DetalhePessoaJuridica detalhePessoaJuridicaSalva = detalhePessoaJuridicaRepository.saveAndFlush(detalhePessoaJuridica);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(detalhePessoaJuridicaSalva.getId()).toUri();
		return ResponseEntity.created(uri).body(detalhePessoaJuridicaSalva);
	}
	
	
	@GetMapping("/{id}")
	@PermitAll
	public Optional<DetalhePessoaJuridica> buscarPorId (@PathVariable Long id) {
		return detalhePessoaJuridicaRepository.findById(id);
	}
	
}
