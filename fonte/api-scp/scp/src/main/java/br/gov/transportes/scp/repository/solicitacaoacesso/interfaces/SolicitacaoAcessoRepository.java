package br.gov.transportes.scp.repository.solicitacaoacesso.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.transportes.scp.model.SolicitacaoAcesso;

public interface SolicitacaoAcessoRepository extends JpaRepository<SolicitacaoAcesso, Long>, SolicitacaoAcessoRepositoryQuery {

}
