package br.gov.transportes.scp.resource;





import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.PessoaSuiteCorporativaNegocio;
import br.gov.transportes.scp.security.TokenProvider;




@RestController
@RequestMapping("/permissoes")
public class PermissoesResource {
	
	
	
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private PessoaSuiteCorporativaNegocio pessoaSuiteCorporativaNegocio;
	        
    
    
	@PostMapping()
	public ResponseEntity<?> decodificaToken( HttpServletResponse response, @RequestBody String token) {
		
				
		return ResponseEntity.ok(tokenProvider.getAuthentication(token).getAuthorities()); 
		
		
	}
	
	@PostMapping("/buscarUsuario")	
	public ResponseEntity<?> buscaFuncionario( HttpServletResponse response, @RequestBody String token) {
		
		return pessoaSuiteCorporativaNegocio.buscarUsuarioPorLogin(tokenProvider.getAuthentication(token).getName());
	}
	
	
	
}
