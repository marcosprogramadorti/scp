package br.gov.transportes.scp.repository.representante.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.transportes.scp.model.Representante;

public interface RepresentanteRepository extends JpaRepository<Representante, Long> {
	public Representante buscarPorIdUsuario(Long id); 
}
