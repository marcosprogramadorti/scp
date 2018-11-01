package br.gov.transportes.scp.resource;

import java.net.URI;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.transportes.scp.model.SolicitacaoAcesso;
import br.gov.transportes.scp.repository.solicitacaoacesso.negocio.SolicitacaoAcessoService;

@RestController
@RequestMapping("/solicitacaoAcesso")
public class SolicitacaoAcessoResource {
	
	@Autowired
	private SolicitacaoAcessoService solicitacaoAcessoService;
	
	@GetMapping("/solicitacoes")
	@PermitAll
	public List<SolicitacaoAcesso> listaTodos() {
		return solicitacaoAcessoService.listarTodos();
	}
	
	@PostMapping
	@PermitAll
	public ResponseEntity<SolicitacaoAcesso> salvarOuAtualizar( @RequestBody SolicitacaoAcesso solicitacaoAcesso, HttpServletResponse response ) {
		SolicitacaoAcesso solicitacaoAcessoSalva = solicitacaoAcessoService.salvarOuAtualizar(solicitacaoAcesso);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(solicitacaoAcesso.getId()).toUri();
		return ResponseEntity.created(uri).body(solicitacaoAcessoSalva);
	}
	
	
	
}
