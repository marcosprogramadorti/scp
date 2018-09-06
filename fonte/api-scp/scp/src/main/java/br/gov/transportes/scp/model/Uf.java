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
@Table(schema="BD_SC_CORP",  name = "TB_UF")
public class Uf implements Serializable {

	
	
	

	/**
	 * Author: Marcos Tavares
	 * Data: 30/08/2018
	 */
	private static final long serialVersionUID = -4364541642343769920L;
	
	@Id
	@Column(name = "ID_UF")
	private Long id;
	
	@Column(name = "NM_UF")
	private String nmUf;
	
	@Column(name = "SG_UF")
	private String sgUf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmUf() {
		return nmUf;
	}

	public void setNmUf(String nmUf) {
		this.nmUf = nmUf;
	}

	public String getSgUf() {
		return sgUf;
	}

	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}
	
	

}
