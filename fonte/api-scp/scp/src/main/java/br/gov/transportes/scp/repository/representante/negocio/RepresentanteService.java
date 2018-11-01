package br.gov.transportes.scp.repository.representante.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.transportes.scp.model.Representante;
import br.gov.transportes.scp.repository.representante.interfaces.RepresentanteRepository;

@Service
public class RepresentanteService {
	
	@Autowired RepresentanteRepository representanteRepository; 
	
	public Representante buscarPorIdUsuario(Long id) {
		
		 return representanteRepository.buscarPorIdUsuario(id);
		 
		
	}

}
