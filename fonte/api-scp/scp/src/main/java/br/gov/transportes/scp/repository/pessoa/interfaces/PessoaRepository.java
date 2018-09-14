package br.gov.transportes.scp.repository.pessoa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.transportes.scp.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {

}
