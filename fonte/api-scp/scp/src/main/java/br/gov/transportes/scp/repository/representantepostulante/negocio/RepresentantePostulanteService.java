package br.gov.transportes.scp.repository.representantepostulante.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.gov.transportes.scp.model.RepresentantePostulante;
import br.gov.transportes.scp.repository.representantepostulante.interfaces.RepresentantePostulanteRepository;

@Service
public class RepresentantePostulanteService {
	
	@Autowired RepresentantePostulanteRepository representantePostulanteRepository; 
	
	public List<RepresentantePostulante> buscarPorIdUsuario(Long id) {
		
		 return representantePostulanteRepository.buscarPorIdUsuario(id);
		 
		
	}

}
