package br.gov.transportes.scp.repository.representantepostulante.interfaces;

import java.util.List;

import br.gov.transportes.scp.model.RepresentantePostulante;

public interface RepresentantePostulanteRepositoryQuery  {
	 public List<RepresentantePostulante> buscarPorIdUsuario(Long id);
}
