package br.gov.transportes.scp.repository.detalhepessoafisica.negocio;

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


import br.gov.transportes.scp.model.DetalhePessoaFisica;
import br.gov.transportes.scp.model.Pessoa;
import br.gov.transportes.scp.model.PessoaFisica;
import br.gov.transportes.scp.repository.detalhepessoafisica.interfaces.DetalhePessoaFisicaRepositoryQuery;

@Repository
public class DetalhePessoaFisicaRepositoryImpl implements DetalhePessoaFisicaRepositoryQuery {

	@PersistenceContext
	private EntityManager maneger;
	
	@Override
	public DetalhePessoaFisica buscaPorCPF(String cpf) {
		
		List<DetalhePessoaFisica> resultado = null;
		
		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<DetalhePessoaFisica> cr = builder.createQuery(DetalhePessoaFisica.class);

		Root<DetalhePessoaFisica> detalhePessoaFisica = cr.from(DetalhePessoaFisica.class);
		
		Join<DetalhePessoaFisica, Pessoa> pessoa = detalhePessoaFisica.join("pessoa", JoinType.INNER);
		Join<Pessoa, PessoaFisica> pessoaFisica = pessoa.join("pessoaFisica", JoinType.INNER);
		

		Predicate[] predicates = criarRestricoes(cpf, builder, pessoaFisica);
		cr.where(predicates);

		TypedQuery<DetalhePessoaFisica> query = maneger.createQuery(cr);
		
		resultado  = query.getResultList();
		if (resultado.size() > 0 ) {
			return resultado.get(0);
		}
		
		return null;
	}

	private Predicate[] criarRestricoes(String cpf, CriteriaBuilder builder, Join<Pessoa, PessoaFisica> pessoaFisica) {

		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(cpf)) {
			predicates.add(builder.equal(pessoaFisica.get("nrCpf"), cpf));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
