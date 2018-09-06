package br.gov.transportes.scp.resource;


import java.util.List;


import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.PaisNacionalidade;
import br.gov.transportes.scp.repository.pais.interfaces.PaisNacionalidadeInterRepository;

@RestController
@RequestMapping("/paisNacionalidade")
public class PaisNacionalidadeResource {
	
	@Autowired
	private PaisNacionalidadeInterRepository paisNacionalidadeInterRepository; 
	
	
	@GetMapping("/paises")
	@PermitAll
	public List<PaisNacionalidade> listaTodos() {
		return paisNacionalidadeInterRepository.findAll();
	}
	
}
