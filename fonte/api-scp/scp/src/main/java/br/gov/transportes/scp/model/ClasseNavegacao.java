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
@Table(schema="BD_SCP",  name = "TB_CLASSE_NAVEGACAO")
public class ClasseNavegacao implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = -62251649608973962L;


	/**
	 * Author: Marcos Tavares
	 * Data: 11/10/2018
	 */
	
	@Id
	@Column(name = "ID_CLASSE_NAVEGACAO")
	private Long id;
	
	
	@Column(name = "DS_CLASSE_NAVEGACAO")
	private String dsClasseNavegacao;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDsClasseNavegacao() {
		return dsClasseNavegacao;
	}


	public void setDsClasseNavegacao(String dsClasseNavegacao) {
		this.dsClasseNavegacao = dsClasseNavegacao;
	}


	
	
	
}
