package br.gov.transportes.scp.repository.representantepostulante.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import br.gov.transportes.scp.model.Representante;
import br.gov.transportes.scp.model.RepresentantePostulante;
import br.gov.transportes.scp.repository.representantepostulante.interfaces.RepresentantePostulanteRepositoryQuery;

@Repository
public class RepresentantePostulanteRepositoryImpl implements RepresentantePostulanteRepositoryQuery {
	
	@PersistenceContext
	private EntityManager maneger;


	@Override
	public List<RepresentantePostulante> buscarPorIdUsuario(Long id) {
		
		List<RepresentantePostulante> resultado = null;
		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<RepresentantePostulante> cr = builder.createQuery(RepresentantePostulante.class);
		
		Root<RepresentantePostulante> representantePostulanteRoot = cr.from(RepresentantePostulante.class);
		Join<RepresentantePostulante, Representante> representante = representantePostulanteRoot.join("representante", JoinType.INNER);
		
		Predicate[] predicates = criarRestricoes(id, builder, representante);
		cr.where(predicates);

		TypedQuery<RepresentantePostulante> query = maneger.createQuery(cr);
		
		try {
			resultado  = query.getResultList();
		}catch (Exception e) {
			resultado = null;
		}
		
		return resultado;
	}


	private Predicate[] criarRestricoes(Long id, CriteriaBuilder builder, Join<RepresentantePostulante, Representante> representante) {
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(id)) {
			predicates.add(builder.equal(representante.get("idUsuarioRepresentante"), id));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	
	
}
