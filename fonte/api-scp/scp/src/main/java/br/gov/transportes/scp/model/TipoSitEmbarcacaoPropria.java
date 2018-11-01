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
@Table(schema="BD_SCP",  name = "TB_TIPO_SIT_EMBARCACAO_PROPRIA")
public class TipoSitEmbarcacaoPropria implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 15/10/2018
	 */
	
	private static final long serialVersionUID = -1489902465600966303L;
	
	
	@Id
	@Column(name = "ID_TIPO_SIT_EMBARCACAO_PROPRIA")
	private Long id;
	
	
	@Column(name = "DS_TIPO_SIT_EMBARCACAO_PROPRIA")
	private String dsTipoSitEmbarcacaoPropria;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDsTipoSitEmbarcacaoPropria() {
		return dsTipoSitEmbarcacaoPropria;
	}


	public void setDsTipoSitEmbarcacaoPropria(String dsTipoSitEmbarcacaoPropria) {
		this.dsTipoSitEmbarcacaoPropria = dsTipoSitEmbarcacaoPropria;
	}


	


	
	
}
