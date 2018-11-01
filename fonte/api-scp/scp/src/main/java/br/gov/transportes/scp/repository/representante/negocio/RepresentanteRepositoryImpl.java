package br.gov.transportes.scp.repository.representante.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import br.gov.transportes.scp.model.Representante;
import br.gov.transportes.scp.repository.representante.interfaces.RepresentanteRepositoryQuery;

@Repository
public class RepresentanteRepositoryImpl implements RepresentanteRepositoryQuery {
	
	@PersistenceContext
	private EntityManager maneger;


	@Override
	public Representante buscarPorIdUsuario(Long id) {
		
		Representante representante = null;
		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<Representante> cr = builder.createQuery(Representante.class);
		
		Root<Representante> representanteRoot = cr.from(Representante.class);
		Predicate[] predicates = criarRestricoes(id, builder, representanteRoot);
		cr.where(predicates);

		TypedQuery<Representante> query = maneger.createQuery(cr);
		
		representante  = query.getSingleResult();
		
		return representante;
	}


	private Predicate[] criarRestricoes(Long id, CriteriaBuilder builder, Root<Representante> representanteRoot) {
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(id)) {
			predicates.add(builder.equal(representanteRoot.get("idUsuarioRepresentante"), id));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	
	
}
