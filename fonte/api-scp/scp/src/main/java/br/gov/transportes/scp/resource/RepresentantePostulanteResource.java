package br.gov.transportes.scp.resource;



import java.util.List;

import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.gov.transportes.scp.model.RepresentantePostulante;
import br.gov.transportes.scp.repository.representantepostulante.negocio.RepresentantePostulanteService;


@RestController
@RequestMapping("/representantePostulante")
public class RepresentantePostulanteResource {
	
	@Autowired
	private RepresentantePostulanteService representantePostulanteServiceService; 
	
	
	@GetMapping("/buscarPorIdUsuario/{id}")
	@PermitAll
	public ResponseEntity<List<RepresentantePostulante>> buscarPorIdUsuario (@PathVariable Long id) {
		List<RepresentantePostulante> representantePostulante = representantePostulanteServiceService.buscarPorIdUsuario(id);
		return ResponseEntity.ok(representantePostulante);
	}
	
	
	
	
}
