package br.gov.transportes.scp.repository.estaleiro.negocio;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.gov.transportes.scp.model.Estaleiro;
import br.gov.transportes.scp.repository.estaleiro.interfaces.EstaleiroRepository;

@Service
public class EstaleiroService {
	
	@Autowired
	EstaleiroRepository  estaleiroRepository;
	
	public List<Estaleiro> lista () {
		
		return estaleiroRepository.findAll();
		
	}
	
	public Optional<Estaleiro> buscarPorId (Long id) {
		
		return estaleiroRepository.findById(id);
		
	}
	
	public  List<Estaleiro> buscarPorIdUf (Long id) {
		
		return estaleiroRepository.buscarPorIdUf(id);
		
	}
	
	
	@PostMapping
	@PermitAll
	public Estaleiro salva (@RequestBody Estaleiro estaleiro){
		Estaleiro estaleiroSalvo = estaleiroRepository.save(estaleiro);
		return estaleiroSalvo;
		
	} 

}
