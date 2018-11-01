package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.TipoAfretamento;
import br.gov.transportes.scp.repository.tipoafretamento.interfaces.TipoAfretamentoRepository;


@RestController
@RequestMapping("/tipoAfretamento")
public class TipoAfretamentoResource {
	
	@Autowired
	private TipoAfretamentoRepository tipoAfretamentoRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<TipoAfretamento>> lista () {
		List<TipoAfretamento> lista = tipoAfretamentoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
