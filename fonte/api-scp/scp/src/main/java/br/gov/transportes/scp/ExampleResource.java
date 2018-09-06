package br.gov.transportes.scp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.transportes.scp.config.property.ScpServiceProperty;





@RestController
@RequestMapping("/exemplo")
public class ExampleResource {
	
	
	@Autowired
	private ExampleRepository exampleRepository;
	
	@GetMapping
	@Secured({"ROLE_SETOR_EXCLUIR"})
	public List<ExampleDao> listar(){
		return exampleRepository.findAll();
	} 
	
	
	@GetMapping("/teste")
	public List<ExampleDao> listar2(){
		//System.out.println(scpServiceProperty.getUrlSuiteCorpService());
		return exampleRepository.findAll();
	} 
}
