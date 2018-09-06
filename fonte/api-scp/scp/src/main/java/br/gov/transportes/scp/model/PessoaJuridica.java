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
@Table(schema="BD_SC_CORP",  name = "TB_PESSOA_JURIDICA")
public class PessoaJuridica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5958013830242968804L;

	/**
	 * Author: Marcos Tavares
	 * Data: 30/08/2018
	 */
	
	
	@Id
	@Column(name = "ID_PESSOA")
	private Long id;
	
	@Column(name = "NR_CNPJ")
	private String nrCnpj;
	
	@Column(name = "NM_RAZAO_SOCIAL")
	private String nmRazaoSocial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrCnpj() {
		return nrCnpj;
	}

	public void setNrCnpj(String nrCnpj) {
		this.nrCnpj = nrCnpj;
	}

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}

	

	
	
	

	

}
