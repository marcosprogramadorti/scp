package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.TipoRegimeAfretamento;
import br.gov.transportes.scp.repository.tiporegimeafretamento.interfaces.TipoRegimeAfretamentoRepository;


@RestController
@RequestMapping("/tipoRegimeAfretamento")
public class TipoRegimeAfretamentoResource {
	
	@Autowired
	private TipoRegimeAfretamentoRepository tipoRegimeAfretamentoRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<TipoRegimeAfretamento>> lista () {
		List<TipoRegimeAfretamento> lista = tipoRegimeAfretamentoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
