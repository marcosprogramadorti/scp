package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(schema="BD_SCP",  name = "TB_EMBARCACAO_CONSTRUCAO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EMBARCACAO_CONSTRUCAO_ID_GENERATOR", sequenceName = "SQ_EMBARCACAO_CONSTRUCAO", allocationSize = 1)
public class EmbarcacaoConstrucao implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 16/10/2018
	 */
	private static final long serialVersionUID = 257512163852091212L;

	@Id
	@Column(name = "ID_EMBARCACAO_CONSTRUCAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EMBARCACAO_CONSTRUCAO_ID_GENERATOR")
	private Long id;
	
	@Column(name = "ID_POSTULANTE")
	private Long idPostulante;
	
	@Column(name = "CD_CASCO")
	private String cdCasco;
	
	@JoinColumn (name = "ID_TIPO_PORTE")
	@OneToOne
	private TipoPorte tipoPorte;
	
	@JoinColumn (name = "ID_CLASSE_NAVEGACAO")
	@OneToOne
	private ClasseNavegacao classeNavegacao;
	
	@Column (name = "DT_PREVISTA_ENTREGA")
	private  Date dtPrevistaEntrega ;
	
	@JoinColumn (name = "ID_TIPO_EMBARCACAO")
	@OneToOne
	private TipoEmbarcacao tipoEmbarcacao;
	
	@Column(name = "NM_CLASSIFICADORA")
	private String nmClassificadora;
	
	

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

	public String getCdCasco() {
		return cdCasco;
	}

	public void setCdCasco(String cdCasco) {
		this.cdCasco = cdCasco;
	}

	public TipoPorte getTipoPorte() {
		return tipoPorte;
	}

	public void setTipoPorte(TipoPorte tipoPorte) {
		this.tipoPorte = tipoPorte;
	}

	public ClasseNavegacao getClasseNavegacao() {
		return classeNavegacao;
	}

	public void setClasseNavegacao(ClasseNavegacao classeNavegacao) {
		this.classeNavegacao = classeNavegacao;
	}

	public Date getDtPrevistaEntrega() {
		return dtPrevistaEntrega;
	}

	public void setDtPrevistaEntrega(Date dtPrevistaEntrega) {
		this.dtPrevistaEntrega = dtPrevistaEntrega;
	}

	public TipoEmbarcacao getTipoEmbarcacao() {
		return tipoEmbarcacao;
	}

	public void setTipoEmbarcacao(TipoEmbarcacao tipoEmbarcacao) {
		this.tipoEmbarcacao = tipoEmbarcacao;
	}

	public String getNmClassificadora() {
		return nmClassificadora;
	}

	public void setNmClassificadora(String nmClassificadora) {
		this.nmClassificadora = nmClassificadora;
	}
	
	
	
}
