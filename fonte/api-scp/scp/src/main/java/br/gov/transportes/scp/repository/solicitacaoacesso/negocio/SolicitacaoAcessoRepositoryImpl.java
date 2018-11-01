package br.gov.transportes.scp.repository.solicitacaoacesso.negocio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.gov.transportes.scp.repository.solicitacaoacesso.interfaces.SolicitacaoAcessoRepositoryQuery;

@Repository
public class SolicitacaoAcessoRepositoryImpl implements SolicitacaoAcessoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

}
