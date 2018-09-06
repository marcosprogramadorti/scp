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
@Table(schema="BD_SC_CORP",  name = "TB_PESSOA")
public class Pessoa implements Serializable {

	
	/**
	 * Author: Marcos Tavares
	 * Data: 30/08/2018
	 */
	
	private static final long serialVersionUID = 2011359302632002181L;

	@Id
	@Column(name = "ID_PESSOA")
	private Long id;
	
	@Column(name = "NM_PESSOA")
	private String nmPessoa;
	
	@OneToOne()
	@JoinColumn(name="ID_PESSOA")
	private PessoaFisica pessoaFisica;
	
	@OneToOne()
	@JoinColumn(name="ID_PESSOA")
	private PessoaJuridica pessoaJuridica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	
	

	

}
