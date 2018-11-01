package br.gov.transportes.scp.resource;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.gov.transportes.scp.config.property.ScpServiceProperty;

@RestController
@RequestMapping("/logout")

public class LogoutResource {
	
	
	@Autowired
	ScpServiceProperty scpServiceProperty;
	
	@GetMapping
	@PermitAll
	public ResponseEntity<Object> logout(){
		
		String URL_LOGOUT = scpServiceProperty.getUrlScaLogout();
		String URL_API = scpServiceProperty.getUrlScaApi();
		
		final String url = URL_LOGOUT + "+'?service='+" +  URL_API;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(HttpStatus.GONE);
		try {
			restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return responseEntity;
	} 
	

}
