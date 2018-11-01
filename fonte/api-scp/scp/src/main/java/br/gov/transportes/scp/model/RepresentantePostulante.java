package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema="BD_SCP",  name = "TB_REPRESENTANTE_POSTULANTE")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_REPRESENTANTE_POSTULANTE_ID_GENERATOR", sequenceName = "SQ_REPRESENTANTE_POSTULANTE", allocationSize = 1)
public class RepresentantePostulante implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 16/10/2018
	 */

	private static final long serialVersionUID = 7586334677667546668L;

	@Id
	@Column(name = "ID_REPRESENTANTE_POSTULANTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_REPRESENTANTE_ID_GENERATOR")
	private Long id;
	
	
//	@EmbeddedId
//	private RepresentantePostulantePK pk = new RepresentantePostulantePK();
	
//	@Column(name = "ID_REPRESENTANTE")
//	private Long idRepresentante;
	
	@Column(name = "ID_POSTULANTE")
	private Long idPostulante;
	
	

	@Column(name = "DT_INICIO_VIGENCIA")
	private Date dtIniciVigencia;
	
	@Column(name = "DT_FIM_VIGENCIA")
	private Date dtFimVigencia;
	
	@Column(name = "TP_REPRESENTANTE")
	private String tpRepresentante;
	
	@Column(name = "ST_SUBMETER")
	private String stSubmeter;
	
	@Column(name = "ST_ATIVO")
	private String stAtivo;
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="ID_REPRESENTANTE")
	Representante representante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Long idPostulante) {
		this.idPostulante = idPostulante;
	}

	public Date getDtIniciVigencia() {
		return dtIniciVigencia;
	}

	public void setDtIniciVigencia(Date dtIniciVigencia) {
		this.dtIniciVigencia = dtIniciVigencia;
	}

	public Date getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(Date dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public String getTpRepresentante() {
		return tpRepresentante;
	}

	public void setTpRepresentante(String tpRepresentante) {
		this.tpRepresentante = tpRepresentante;
	}

	public String getStSubmeter() {
		return stSubmeter;
	}

	public void setStSubmeter(String stSubmeter) {
		this.stSubmeter = stSubmeter;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	
	
	
	
	


}
