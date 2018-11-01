package br.gov.transportes.scp.repository.representantepostulante.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.gov.transportes.scp.model.RepresentantePostulante;

public interface RepresentantePostulanteRepository extends JpaRepository<RepresentantePostulante, Long> {
	public List<RepresentantePostulante> buscarPorIdUsuario(Long id); 
}
