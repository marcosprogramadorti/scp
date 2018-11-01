package br.gov.transportes.scp.repository.estaleiro.interfaces;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.transportes.scp.model.Estaleiro;

public interface EstaleiroRepository extends JpaRepository<Estaleiro, Long> {
	
	public List<Estaleiro> buscarPorIdUf (Long id);
	
	 
}
