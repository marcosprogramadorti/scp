package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.TipoPorte;
import br.gov.transportes.scp.repository.tipoporte.interfaces.TipoPorteRepository;

@RestController
@RequestMapping("/tipoPorte")
public class TipoPorteResource {
	
	@Autowired
	private TipoPorteRepository tipoPorteRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<TipoPorte>> lista () {
		List<TipoPorte> lista = tipoPorteRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
