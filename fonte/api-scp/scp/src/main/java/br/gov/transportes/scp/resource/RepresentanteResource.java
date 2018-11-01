package br.gov.transportes.scp.resource;



import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.Representante;
import br.gov.transportes.scp.repository.representante.negocio.RepresentanteService;


@RestController
@RequestMapping("/representante")
public class RepresentanteResource {
	
	@Autowired
	private RepresentanteService representanteService; 
	
	
	@GetMapping("/buscarPorIdUsuario/{id}")
	@PermitAll
	public ResponseEntity<Representante> buscarPorIdUsuario (@PathVariable Long id) {
		Representante representante = representanteService.buscarPorIdUsuario(id);
		return ResponseEntity.ok(representante);
	}
	
	
	
	
}
