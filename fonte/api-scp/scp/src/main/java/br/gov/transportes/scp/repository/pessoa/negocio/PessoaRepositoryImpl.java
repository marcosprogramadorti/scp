package br.gov.transportes.scp.repository.pessoa.negocio;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


import br.gov.transportes.scp.model.DetalhePessoaFisica;
import br.gov.transportes.scp.model.DetalhePessoaJuridica;
import br.gov.transportes.scp.model.Pessoa;
import br.gov.transportes.scp.model.PessoaFisica;
import br.gov.transportes.scp.model.PessoaJuridica;
import br.gov.transportes.scp.repository.detalhepessoafisica.interfaces.DetalhePessoaFisicaRepository;
import br.gov.transportes.scp.repository.pessoa.interfaces.PessoaRepositoryQuery;

@Repository
public class PessoaRepositoryImpl implements PessoaRepositoryQuery {

	@PersistenceContext
	private EntityManager maneger;
	
	@Autowired
	private DetalhePessoaFisicaRepository detalhePessoaFisicaRepository;
	
	
	@Override
	public List<Pessoa> pesquisar (PessoaFiltroTO filtro) {
		
		List<Pessoa> resultado = null;
		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<Pessoa> cr = builder.createQuery(Pessoa.class);

		Root<Pessoa> pessoa = cr.from(Pessoa.class);

		if ( filtro.getTpPessoa().equals("F") ) {
			
			Join<Pessoa, DetalhePessoaFisica> detalhePessoaFisica = pessoa.join("detalhePessoaFisica", JoinType.INNER);
			Join<Pessoa, PessoaFisica> pessoaFisica = pessoa.join("pessoaFisica", JoinType.LEFT);
			Predicate[] predicates = criarRestricoesPessoaFisica(filtro, builder, pessoa, pessoaFisica, detalhePessoaFisica);
			cr.where(predicates);
			TypedQuery<Pessoa> query = maneger.createQuery(cr);
			resultado  = query.getResultList();
			if (resultado.size() > 0 ) {
				return resultado;
			}
			
		}
		if ( filtro.getTpPessoa().equals("J") ) {
			
			Join<Pessoa, DetalhePessoaJuridica> detalhePessoaJuridica = pessoa.join("pessoaJuridica", JoinType.LEFT);
			Join<Pessoa, PessoaJuridica> pessoaJuridica = pessoa.join("pessoaJuridica", JoinType.LEFT);
			Predicate[] predicates = criarRestricoesPessoaJuridica(filtro, builder, pessoa, pessoaJuridica, detalhePessoaJuridica);
			cr.where(predicates);
			TypedQuery<Pessoa> query = maneger.createQuery(cr);
			resultado  = query.getResultList();
			if (resultado.size() > 0 ) {
				return resultado;
			}
			
		}
				
		
		
		
		return null;
	}

	private Predicate[] criarRestricoesPessoaFisica(PessoaFiltroTO filtro, CriteriaBuilder builder, Root<Pessoa> pessoa,  Join<Pessoa, PessoaFisica> pessoaFisica, Join<Pessoa, DetalhePessoaFisica> detalhePessoaFisica) {

		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(filtro.getTpPessoa())) {
			if (filtro.getTpPessoa().equals("Todas")) {
				predicates.add(builder.equal(detalhePessoaFisica.get("stAtivo"), "S" ));
			}else {
				predicates.add(builder.equal(pessoa.get("tpPessoa"), filtro.getTpPessoa()));
			}
		}
		
		
		if (!StringUtils.isEmpty(filtro.getNrCpf())) {
			predicates.add(builder.equal(pessoaFisica.get("nrCpf"), filtro.getNrCpf()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private Predicate[] criarRestricoesPessoaJuridica(PessoaFiltroTO filtro, CriteriaBuilder builder, Root<Pessoa> pessoa,  Join<Pessoa, PessoaJuridica> pessoaJuridica, Join<Pessoa, Join<Pessoa, Join<Pessoa, DetalhePessoaFisica> detalhePessoaFisica) {

		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(filtro.getTpPessoa())) {
			if (filtro.getTpPessoa().equals("Todas")) {
				predicates.add(builder.equal(detalhePessoaFisica.get("stAtivo"), "S" ));
			}else {
				predicates.add(builder.equal(pessoa.get("tpPessoa"), filtro.getTpPessoa()));
			}
		}
		
		
		if (!StringUtils.isEmpty(filtro.getNrCpf())) {
			predicates.add(builder.equal(pessoaFisica.get("nrCpf"), filtro.getNrCpf()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
