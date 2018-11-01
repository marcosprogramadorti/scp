package br.gov.transportes.scp.model;

import java.io.Serializable;
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
@Table(schema="BD_SCP",  name = "TB_EMBARCACAO_PROPRIA")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EMBARCACAO_PROPRIA_ID_GENERATOR", sequenceName = "SQ_EMBARCACAO_PROPRIA", allocationSize = 1)
public class EmbarcacaoPropria implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 15/10/2018
	 */
	private static final long serialVersionUID = 257512163852091212L;


	
	
	@Id
	@Column(name = "ID_EMBARCACAO_PROPRIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EMBARCACAO_PROPRIA_ID_GENERATOR")
	private Long id;
	
	@Column(name = "ID_POSTULANTE")
	private Long idPostulante;
	
	@Column(name = "NM_EMBARCACAO")
	private String nmEmbarcacao;
	
	@JoinColumn (name = "ID_TIPO_PORTE")
	@OneToOne
	private TipoPorte tipoPorte;
	
	@JoinColumn (name = "ID_CLASSE_NAVEGACAO")
	@OneToOne
	private ClasseNavegacao classeNavegacao;
	
	@Column (name = "AN_CONSTRUCAO")
	private  Integer anConstrucao ;
	
	@JoinColumn (name = "ID_TIPO_SIT_EMBARCACAO_PROPRIA")
	@OneToOne
	private TipoSitEmbarcacaoPropria tipoSitEmbarcacaoPropria;
	
	@JoinColumn (name = "ID_TIPO_EMBARCACAO")
	@OneToOne
	private TipoEmbarcacao tipoEmbarcacao;

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

	public String getNmEmbarcacao() {
		return nmEmbarcacao;
	}

	public void setNmEmbarcacao(String nmEmbarcacao) {
		this.nmEmbarcacao = nmEmbarcacao;
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

	public Integer getAnConstrucao() {
		return anConstrucao;
	}

	public void setAnConstrucao(Integer anConstrucao) {
		this.anConstrucao = anConstrucao;
	}

	public TipoSitEmbarcacaoPropria getTipoSitEmbarcacaoPropria() {
		return tipoSitEmbarcacaoPropria;
	}

	public void setTipoSitEmbarcacaoPropria(TipoSitEmbarcacaoPropria tipoSitEmbarcacaoPropria) {
		this.tipoSitEmbarcacaoPropria = tipoSitEmbarcacaoPropria;
	}

	public TipoEmbarcacao getTipoEmbarcacao() {
		return tipoEmbarcacao;
	}

	public void setTipoEmbarcacao(TipoEmbarcacao tipoEmbarcacao) {
		this.tipoEmbarcacao = tipoEmbarcacao;
	}
	
	
	
	
}
