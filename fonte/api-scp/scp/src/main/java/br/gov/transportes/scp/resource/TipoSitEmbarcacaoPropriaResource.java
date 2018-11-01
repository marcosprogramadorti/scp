package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.TipoSitEmbarcacaoPropria;
import br.gov.transportes.scp.repository.tipositembarcacaopropria.interfaces.TipoSitEmbarcacaoPropriaRepository;

@RestController
@RequestMapping("/tipoSitEmbarcacaoPropria")
public class TipoSitEmbarcacaoPropriaResource {
	
	@Autowired
	private TipoSitEmbarcacaoPropriaRepository tipoSitEmbarcacaoPropriaRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<TipoSitEmbarcacaoPropria>> lista () {
		List<TipoSitEmbarcacaoPropria> lista = tipoSitEmbarcacaoPropriaRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
