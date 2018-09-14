package br.gov.transportes.scp.repository.detalhepessoafisica.interfaces;

import br.gov.transportes.scp.model.DetalhePessoaFisica;

public interface DetalhePessoaFisicaRepositoryQuery {
	public DetalhePessoaFisica buscaPorCPF (String cpf) ;
}
