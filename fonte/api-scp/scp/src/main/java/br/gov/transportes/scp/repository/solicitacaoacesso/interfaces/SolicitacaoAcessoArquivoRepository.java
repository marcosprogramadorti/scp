package br.gov.transportes.scp.repository.solicitacaoacesso.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.transportes.scp.model.SolicitacaoAcessoArquivo;

public interface SolicitacaoAcessoArquivoRepository extends JpaRepository<SolicitacaoAcessoArquivo, Long>, SolicitacaoAcessoArquivoRepositoryQuery {

}
