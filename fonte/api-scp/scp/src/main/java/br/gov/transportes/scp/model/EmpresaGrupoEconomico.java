package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.PessoaFisicaTO;
import br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to.PessoaJuridicaTO;


@Entity
@Table(schema="BD_SCP",  name = "TB_EMPRESA_GRUPO_ECONOMICO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EMPRESA_GRUPO_ECONOMICO_ID_GENERATOR", sequenceName = "BD_SCP.SQ_EMPRESA_GRUPO_ECONOMICO", allocationSize = 1)
public class EmpresaGrupoEconomico implements Serializable {

	
	

	/**
	 * Author: Marcos Tavares
	 * Data: 30/08/2018
	 */
	private static final long serialVersionUID = -1554946913760543514L;
	
	@Id
	@Column(name = "ID_EMPRESA_GRUPO_ECONOMICO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EMPRESA_GRUPO_ECONOMICO_ID_GENERATOR")
	private Long id;
	
	@Column(name = "ID_PESSOA_JURIDICA")
	private Long idDetalhePessoaJuridica;
	
	@OneToOne()
	@JoinColumn( name="ID_PESSOA_PARTICIPANTE_GRUPO")
	private PessoaJuridica participanteGrupoPessoaJuridica;
	
	@OneToOne()
	@JoinColumn( name="ID_UF")
	private Uf uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDetalhePessoaJuridica() {
		return idDetalhePessoaJuridica;
	}

	public void setIdDetalhePessoaJuridica(Long idDetalhePessoaJuridica) {
		this.idDetalhePessoaJuridica = idDetalhePessoaJuridica;
	}

	public PessoaJuridica getParticipanteGrupoPessoaJuridica() {
		return participanteGrupoPessoaJuridica;
	}

	public void setParticipanteGrupoPessoaJuridica(PessoaJuridica participanteGrupoPessoaJuridica) {
		this.participanteGrupoPessoaJuridica = participanteGrupoPessoaJuridica;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	
	
	
	
	
	

	

}
