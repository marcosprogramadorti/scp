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
	public List<Pessoa> pesquisar(PessoaFiltroTO filtro) {

		List<Pessoa> resultado = null;
		List<Pessoa> resultadoFisica = null;
		List<Pessoa> resultadoJuridica = null;

		if (filtro.getTpPessoa().equalsIgnoreCase("F")) {

			resultado = pesquisaPessoaFisica(filtro);
		}
		if (filtro.getTpPessoa().equalsIgnoreCase("J")) {

			resultado = pesquisaPessoaJuridica(filtro);

		}
		if (filtro.getTpPessoa().equalsIgnoreCase("Todas") || filtro.getTpPessoa().equalsIgnoreCase("Todos")
				|| filtro.getTpPessoa().equalsIgnoreCase("T")) {

			resultadoFisica = pesquisaPessoaFisica(filtro);
			resultadoJuridica = pesquisaPessoaJuridica(filtro);

			if (resultadoFisica != null) {
				resultado = resultadoFisica;

				if (resultadoJuridica != null) {
					resultado.addAll(resultadoJuridica);
				}

			} else {
				if (resultadoJuridica != null) {
					resultado = resultadoJuridica;
				}
			}
		}

		return resultado;
	}

	private List<Pessoa> pesquisaPessoaJuridica(PessoaFiltroTO filtro) {

		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<Pessoa> cr = builder.createQuery(Pessoa.class);

		Root<Pessoa> pessoa = cr.from(Pessoa.class);

		List<Pessoa> resultado = null;
		Join<Pessoa, DetalhePessoaJuridica> detalhePessoaJuridica = pessoa.join("detalhePessoaJuridica",
				JoinType.INNER);
		Join<Pessoa, PessoaJuridica> pessoaJuridica = pessoa.join("pessoaJuridica", JoinType.LEFT);
		Predicate[] predicates = criarRestricoesPessoaJuridica(filtro, builder, pessoa, pessoaJuridica,
				detalhePessoaJuridica);
		cr.where(predicates);
		TypedQuery<Pessoa> query = maneger.createQuery(cr);
		resultado = query.getResultList();
		if (resultado.size() > 0) {
			return resultado;
		}
		return null;
	}

	private List<Pessoa> pesquisaPessoaFisica(PessoaFiltroTO filtro) {
		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<Pessoa> cr = builder.createQuery(Pessoa.class);
		Root<Pessoa> pessoa = cr.from(Pessoa.class);
		List<Pessoa> resultado = null;
		Join<Pessoa, DetalhePessoaFisica> detalhePessoaFisica = pessoa.join("detalhePessoaFisica", JoinType.INNER);
		Join<Pessoa, PessoaFisica> pessoaFisica = pessoa.join("pessoaFisica", JoinType.LEFT);
		Predicate[] predicates = criarRestricoesPessoaFisica(filtro, builder, pessoa, pessoaFisica,
				detalhePessoaFisica);
		cr.where(predicates);
		TypedQuery<Pessoa> query = maneger.createQuery(cr);
		resultado = query.getResultList();
		if (resultado.size() > 0) {
			return resultado;
		}
		return null;
	}

	private Predicate[] criarRestricoesPessoaFisica(PessoaFiltroTO filtro, CriteriaBuilder builder, Root<Pessoa> pessoa,
			Join<Pessoa, PessoaFisica> pessoaFisica, Join<Pessoa, DetalhePessoaFisica> detalhePessoaFisica) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filtro.getNrCpf())) {
			predicates.add(builder.equal(pessoaFisica.get("nrCpf"), filtro.getNrCpf()));
		}

		if (!StringUtils.isEmpty(filtro.getNmPessoa())) {
			predicates.add(builder.like(builder.lower(pessoa.get("nmPessoa")),
					"%" + filtro.getNmPessoa().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private Predicate[] criarRestricoesPessoaJuridica(PessoaFiltroTO filtro, CriteriaBuilder builder,
			Root<Pessoa> pessoa, Join<Pessoa, PessoaJuridica> pessoaJuridica,
			Join<Pessoa, DetalhePessoaJuridica> detalhePessoaJuridica) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filtro.getNrCnpj())) {
			predicates.add(builder.equal(pessoaJuridica.get("nrCnpj"), filtro.getNrCnpj()));
		}
		if (!StringUtils.isEmpty(filtro.getNmPessoa())) {
			predicates.add(builder.like(builder.lower(pessoaJuridica.get("nmRazaoSocial")),
					"%" + filtro.getNmPessoa().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
