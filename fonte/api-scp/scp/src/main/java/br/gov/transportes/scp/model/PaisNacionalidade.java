package br.gov.transportes.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SC_CORP",  name = "TB_PAIS")
public class PaisNacionalidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5210848523890956720L;
	
	@Id
	@Column(name = "ID_PAIS")
	private Long id;
	
	@Column(name = "NM_PAIS")
	private String nmPais;
	
	@Column(name = "SG_PAIS")
	private String sgPais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmPais() {
		return nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}

	public String getSgPais() {
		return sgPais;
	}

	public void setSgPais(String sgPais) {
		this.sgPais = sgPais;
	}

	@Override
	public String toString() {
		return "PaisNacionalidade [id=" + id + ", nmPais=" + nmPais + ", sgPais=" + sgPais + "]";
	}
	
	
	
	
	
	

}
