package br.gov.transportes.scp.repository.estaleiro.interfaces;

import java.util.List;


import br.gov.transportes.scp.model.Estaleiro;

public interface EstaleiroRepositoryQuery  {
	public List<Estaleiro> buscarPorIdUf (Long id);
}
