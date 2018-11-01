package br.gov.transportes.scp.repository.estaleiro.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.gov.transportes.scp.model.Estaleiro;
import br.gov.transportes.scp.repository.estaleiro.interfaces.EstaleiroRepositoryQuery;

@Repository
public class EstaleiroRepositoryImpl implements EstaleiroRepositoryQuery {

	@PersistenceContext
	private EntityManager maneger;

	@Override
	public List<Estaleiro> buscarPorIdUf(Long id) {

		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<Estaleiro> cr = builder.createQuery(Estaleiro.class);
		Root<Estaleiro> estaleiro = cr.from(Estaleiro.class);

		Predicate[] predicates = criarRestricoes(id, builder, estaleiro);
		cr.where(predicates);

		TypedQuery<Estaleiro> query = maneger.createQuery(cr);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}

	private Predicate[] criarRestricoes(Long id, CriteriaBuilder builder, Root<Estaleiro> estaleiro) {

		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(id)) {
			predicates.add(builder.equal(estaleiro.get("idUf"), id));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
