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
@Table(schema="BD_SCP",  name = "TB_DIRETORIA")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_DIRETORIA_ID_GENERATOR", sequenceName = "BD_SCP.ID_DIRETORIA", allocationSize = 1)
public class Diretoria implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 05/09/2018
	 */
	
	private static final long serialVersionUID = -5218665712375353505L;
	
	@Id
	@Column(name = "ID_DIRETORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_DIRETORIA_ID_GENERATOR")
	private Long id;
	
	
	@Column(name = "ID_PESSOA_JURIDICA")
	private Long idDetalhePessoaJuridica;
	
	@OneToOne()
	@JoinColumn( name="ID_PESSOA_DIRETOR")
	private Pessoa pessoaDiretoria;
	
	@Column(name = "NM_CARGO")
	private String nmCargo;
	
	@Column(name = "DT_INICIO_MANDATO")
	private Date dtInicioMandato;
	
	@Column(name = "DT_FIM_MANDATO")
	private Date dtFimMandato;

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

	public Pessoa getPessoaDiretoria() {
		return pessoaDiretoria;
	}

	public void setPessoaDiretoria(Pessoa pessoaDiretoria) {
		this.pessoaDiretoria = pessoaDiretoria;
	}

	public String getNmCargo() {
		return nmCargo;
	}

	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}

	public Date getDtInicioMandato() {
		return dtInicioMandato;
	}

	public void setDtInicioMandato(Date dtInicioMandato) {
		this.dtInicioMandato = dtInicioMandato;
	}

	public Date getDtFimMandato() {
		return dtFimMandato;
	}

	public void setDtFimMandato(Date dtFimMandato) {
		this.dtFimMandato = dtFimMandato;
	}

	
	
		
	
	
	
	
	

}
