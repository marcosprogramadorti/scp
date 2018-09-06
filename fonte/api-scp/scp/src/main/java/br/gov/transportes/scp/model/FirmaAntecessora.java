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


@Entity
@Table(schema="BD_SCP",  name = "TB_FIRMA_ANTECESSORA")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_FIRMA_ANTECESSORA_ID_GENERATOR", sequenceName = "BD_SCP.SQ_FIRMA_ANTECESSORA", allocationSize = 1)
public class FirmaAntecessora implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 05/09/2018
	 */
	
	private static final long serialVersionUID = -5075398113932237914L;
	
	@Id
	@Column(name = "ID_FIRMA_ANTECESSORA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_FIRMA_ANTECESSORA_ID_GENERATOR")
	private Long id;
	
	@Column(name = "ID_PESSOA_JURIDICA")
	private Long idDetalhePessoaJuridica;
	
	@Column(name = "NM_RAZAO_SOCIAL")
	private String nmRazaoSocial;
	
	@Column(name = "DT_INICIO_VIGENCIA")
	private Date dtInicioVigencia;
	
	@Column(name = "DT_FIM_VIGENCIA")
	private Date dtFimVigencia;

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

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}

	public Date getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(Date dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public Date getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(Date dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

		
		
	
	
	
	
	

}
