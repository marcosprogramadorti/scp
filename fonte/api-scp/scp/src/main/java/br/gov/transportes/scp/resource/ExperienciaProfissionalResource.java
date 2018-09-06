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
import br.gov.transportes.scp.model.ExperienciaProfissional;
import br.gov.transportes.scp.repository.experiencialprofissional.interfaces.ExperienciaProfissionalInterRepository;

@RestController
@RequestMapping("/experienciaProfissional")
public class ExperienciaProfissionalResource {
	
	@Autowired
	private ExperienciaProfissionalInterRepository experienciaProfissionalInterRepository; 
	
	@PostMapping
	@PermitAll
	public ResponseEntity<ExperienciaProfissional> salvar( @RequestBody ExperienciaProfissional experienciaProfissional, HttpServletResponse response ) {
		
		ExperienciaProfissional experienciaProfissionalSalva = experienciaProfissionalInterRepository.save(experienciaProfissional);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(experienciaProfissionalSalva.getId()).toUri();
		return ResponseEntity.created(uri).body(experienciaProfissionalSalva);
	}
	
	
	@GetMapping("/{id}")
	@PermitAll
	public Optional<ExperienciaProfissional> buscarPorId (@PathVariable Long id) {
		return experienciaProfissionalInterRepository.findById(id);
	}
	
}
