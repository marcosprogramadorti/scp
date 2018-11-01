package br.gov.transportes.scp.resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class LoginResource {
	
	
	
	
	@GetMapping
	//@Secured({"ROLE_SETOR_EXCLUIR"})
	@Secured({"ROLE_PESSOA-FISICA_CONSULTAR"})
	public String login(){
		return "OK";
	} 
	

}
