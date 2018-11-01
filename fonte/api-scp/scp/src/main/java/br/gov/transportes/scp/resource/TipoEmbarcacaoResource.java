package br.gov.transportes.scp.resource;


import java.util.List;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.transportes.scp.model.TipoEmbarcacao;
import br.gov.transportes.scp.model.TipoSitEmbarcacaoPropria;
import br.gov.transportes.scp.repository.tipoembarcacao.interfaces.TipoEmbarcacaoRepository;
import br.gov.transportes.scp.repository.tipositembarcacaopropria.interfaces.TipoSitEmbarcacaoPropriaRepository;

@RestController
@RequestMapping("/tipoEmbarcacao")
public class TipoEmbarcacaoResource {
	
	@Autowired
	private TipoEmbarcacaoRepository tipoEmbarcacaoRepository; 
	
	
	@GetMapping("/lista")
	@PermitAll
	public ResponseEntity<List<TipoEmbarcacao>> lista () {
		List<TipoEmbarcacao> lista = tipoEmbarcacaoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
}
