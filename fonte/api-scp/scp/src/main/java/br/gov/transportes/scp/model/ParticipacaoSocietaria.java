package br.gov.transportes.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(schema="BD_SCP",  name = "TB_PARTICIPACAO_SOCIETARIA")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_PARTICIPACAO_SOCIETARIA_ID_GENERATOR", sequenceName = "BD_SCP.SQ_PARTICIPACAO_SOCIETARIA", allocationSize = 1)
public class ParticipacaoSocietaria implements Serializable {

	/**
	 * Author: Marcos Tavares
	 * Data: 30/08/2018
	 */
	private static final long serialVersionUID = -4145316646830626641L;
	
	@Id
	@Column(name = "ID_PARTICIPACAO_SOCIETARIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_PARTICIPACAO_SOCIETARIA_ID_GENERATOR")
	private Long id;
	
	@Column(name = "ID_PESSOA_JURIDICA")
	private Long idDetalhePessoaJuridica;
	
	@OneToOne()
	@JoinColumn( name="ID_PESSOA_SOCIO_PESSOA_FISICA")
	private Pessoa socioPessoaFisica;
	
	@OneToOne()
	@JoinColumn( name="ID_PESSOA_SOCIO_PESSOA_JURIDIC")
	private Pessoa socioPessoaJuridica;
	
	@Column(name = "QT_ACAO_ORDINARIA")
	private Float qtAcaoOrdinaria;
	
	@Column(name = "PE_ACAO_ORDINARIA")
	private Float peAcaoOrdinaria;
	
	@Column(name = "QT_ACAO_PREFERENCIAL")
	private Float qtAcaoPreferencial;
	
	@Column(name = "PE_ACAO_PREFERENCIAL")
	private Float peAcaoPreferencial;
	
	@Column(name = "QT_ACAO_VOTO")
	private Float qtAcaoVoto;
	
	@Column(name = "PE_ACAO_VOTO")
	private Float peAcaoVoto;
	
	@OneToOne()
	@JoinColumn(name = "ID_UF")
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

	public Pessoa getSocioPessoaFisica() {
		return socioPessoaFisica;
	}

	public void setSocioPessoaFisica(Pessoa socioPessoaFisica) {
		this.socioPessoaFisica = socioPessoaFisica;
	}

	public Pessoa getSocioPessoaJuridica() {
		return socioPessoaJuridica;
	}

	public void setSocioPessoaJuridica(Pessoa socioPessoaJuridica) {
		this.socioPessoaJuridica = socioPessoaJuridica;
	}

	public Float getQtAcaoOrdinaria() {
		return qtAcaoOrdinaria;
	}

	public void setQtAcaoOrdinaria(Float qtAcaoOrdinaria) {
		this.qtAcaoOrdinaria = qtAcaoOrdinaria;
	}

	public Float getPeAcaoOrdinaria() {
		return peAcaoOrdinaria;
	}

	public void setPeAcaoOrdinaria(Float peAcaoOrdinaria) {
		this.peAcaoOrdinaria = peAcaoOrdinaria;
	}

	public Float getQtAcaoPreferencial() {
		return qtAcaoPreferencial;
	}

	public void setQtAcaoPreferencial(Float qtAcaoPreferrencial) {
		this.qtAcaoPreferencial = qtAcaoPreferrencial;
	}

	public Float getPeAcaoPreferencial() {
		return peAcaoPreferencial;
	}

	public void setPeAcaoPreferencial(Float peAcaoPreferencial) {
		this.peAcaoPreferencial = peAcaoPreferencial;
	}

	public Float getQtAcaoVoto() {
		return qtAcaoVoto;
	}

	public void setQtAcaoVoto(Float qtAcaoVoto) {
		this.qtAcaoVoto = qtAcaoVoto;
	}

	public Float getPeAcaoVoto() {
		return peAcaoVoto;
	}

	public void setPeAcaoVoto(Float peAcaoVoto) {
		this.peAcaoVoto = peAcaoVoto;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	
	
	
	
	

	
	
	
	

	

}
