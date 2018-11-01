package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.transportes.scp.model.ClasseNavegacao;
import br.gov.transportes.scp.repository.classenavegacao.interfaces.ClasseNavegacaoRepository;


@RestController
@RequestMapping("/classeNavegacao")
public class ClasseNavegacaoResource {
	
	@Autowired
	private ClasseNavegacaoRepository classeNavegacaoRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<ClasseNavegacao>> lista () {
		List<ClasseNavegacao> lista = classeNavegacaoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
