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
@Table(schema="BD_SCP",  name = "TB_EXPERIENCIA_PROFISSIONAL")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EXPERIENCIA_PROFISSIONAL_ID_GENERATOR", sequenceName = "BD_SCP.SQ_EXPERIENCIA_PROFISSIONAL", allocationSize = 1)
public class ExperienciaProfissional implements Serializable {

	/**
	 * Author: Marcos Tavares
	 * Data: 30/08/2018
	 */
	private static final long serialVersionUID = -4145316646830626641L;
	
	@Id
	@Column(name = "ID_EXPERIENCIA_PROFISSIONAL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EXPERIENCIA_PROFISSIONAL_ID_GENERATOR")
	private Long id;
	
	
	@Column(name = "ID_PESSOA_FISICA")
	private Long idPessoa;
	
	@Column(name = "NM_EMPRESA")
	private String nmEmpresa;
	
	@Column(name = "NM_CARGO")
	private String nmCargo;
	
	@Column(name = "DT_INICIO_CARGO")
	private Date dtInicioCargo;
	
	@Column(name = "DT_FIM_CARGO")
	private Date dtFimCargo;
	
	
	
	
//	@JsonIgnore
//	@ManyToOne()
//	@JoinColumn(name = "ID_PESSOA", insertable=false, updatable=false)
//	private DetalhePessoaFisica detalhePessoaFisica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPEssoa(Long idPEssoa) {
		this.idPessoa = idPEssoa;
	}

	public String getNmEmpresa() {
		return nmEmpresa;
	}

	public void setNmEmpresa(String nmEmpresa) {
		this.nmEmpresa = nmEmpresa;
	}

	public String getNmCargo() {
		return nmCargo;
	}

	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}

	public Date getDtInicioCargo() {
		return dtInicioCargo;
	}

	public void setDtInicioCargo(Date dtInicioCargo) {
		this.dtInicioCargo = dtInicioCargo;
	}

	public Date getDtFimCargo() {
		return dtFimCargo;
	}

	public void setDtFimCargo(Date dtFimCargo) {
		this.dtFimCargo = dtFimCargo;
	}
	
	
	
//	public DetalhePessoaFisica getDetalhePessoaFisica() {
//		return detalhePessoaFisica;
//	}
//
//	public void setDetalhePessoaFisica(DetalhePessoaFisica detalhePessoaFisica) {
//		this.detalhePessoaFisica = detalhePessoaFisica;
//	}
	
	

	@Override
	public String toString() {
		return "ExperienciaProfissional [id=" + id + ", idPEssoa=" + idPessoa + ", nmEmpresa=" + nmEmpresa
				+ ", nmCargo=" + nmCargo + ", dtInicioCargo=" + dtInicioCargo + ", dtFimCargo=" + dtFimCargo + "]";
	}

		
	
	
	
	
	

}
