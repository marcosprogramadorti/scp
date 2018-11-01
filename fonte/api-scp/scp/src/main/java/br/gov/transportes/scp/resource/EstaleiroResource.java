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

import br.gov.transportes.scp.model.Estaleiro;
import br.gov.transportes.scp.model.Postulante;
import br.gov.transportes.scp.repository.estaleiro.negocio.EstaleiroService;

@RestController
@RequestMapping("/estaleiro")

public class EstaleiroResource {
	
	@Autowired 
	EstaleiroService estaleiroService;  
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<Estaleiro>> lista () {
		List<Estaleiro> lista = estaleiroService.lista();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/buscarPorId/{id}")
	@PermitAll
	public Optional<Estaleiro> buscarPorId (@PathVariable Long id) {
		
		return   estaleiroService.buscarPorId(id);
		
	}
	@GetMapping("/buscarPorIdUf/{id}")
	@PermitAll
	public List<Estaleiro> buscarPorIdUf (@PathVariable Long id) {
		
		return   estaleiroService.buscarPorIdUf(id);
		
	}
	
	@PostMapping
	@PermitAll
	public ResponseEntity<Estaleiro> salva (@RequestBody Estaleiro estaleiro){
		Estaleiro estaleiroSalvo = estaleiroService.salva(estaleiro);
		return ResponseEntity.ok(estaleiroSalvo);
		
	} 
	

}
