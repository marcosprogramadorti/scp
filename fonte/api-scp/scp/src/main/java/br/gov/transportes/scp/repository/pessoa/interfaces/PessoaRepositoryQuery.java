package br.gov.transportes.scp.repository.pessoa.interfaces;

import java.util.List;
import br.gov.transportes.scp.model.Pessoa;
import br.gov.transportes.scp.repository.pessoa.negocio.PessoaFiltroTO;

public interface PessoaRepositoryQuery {
	public List<Pessoa> pesquisar (PessoaFiltroTO filtro) ;
}
