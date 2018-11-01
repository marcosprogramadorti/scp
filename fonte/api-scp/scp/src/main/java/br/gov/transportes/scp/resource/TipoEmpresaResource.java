package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.TipoEmpresa;
import br.gov.transportes.scp.repository.tipoempresa.interfaces.TipoEmpresaRepository;


@RestController
@RequestMapping("/tipoEmpresa")
public class TipoEmpresaResource {
	
	@Autowired
	private TipoEmpresaRepository tipoEmpresaRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<TipoEmpresa>> lista () {
		List<TipoEmpresa> lista = tipoEmpresaRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
