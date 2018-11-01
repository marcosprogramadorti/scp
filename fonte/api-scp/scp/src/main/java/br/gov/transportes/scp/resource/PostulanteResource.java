package br.gov.transportes.scp.resource;


import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.Postulante;
import br.gov.transportes.scp.repository.postulante.interfaces.PostulanteRepository;


@RestController
@RequestMapping("/postulante")
public class PostulanteResource {
	
	@Autowired
	private PostulanteRepository postulanteRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<Postulante>> lista () {
		List<Postulante> lista = postulanteRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	@PermitAll
	public Optional<Postulante> buscarPorId (@PathVariable Long id) {
		return postulanteRepository.findById(id);
	}
	
	@PostMapping
	@PermitAll
	public ResponseEntity<Postulante> salva (@RequestBody Postulante postulante){
		Postulante postulanteSalvo = postulanteRepository.save(postulante);
		return ResponseEntity.ok(postulanteSalvo);
		
	} 
	
	
}
