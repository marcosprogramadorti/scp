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
@Table(schema="BD_SCP",  name = "TB_EMBARCACAO_AFRETADA")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EMBARCACAO_AFRETADA_ID_GENERATOR", sequenceName = "SQ_EMBARCACAO_AFRETADA", allocationSize = 1)
public class EmbarcacaoAfretada implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 15/10/2018
	 */
	private static final long serialVersionUID = -318773741184719996L;

	@Id
	@Column(name = "ID_EMBARCACAO_AFRETADA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EMBARCACAO_AFRETADA_ID_GENERATOR")
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
	
	@Column(name = "DT_INICIO_AFRETAMENTO")
	private Date dtInicioAfretamento;
	
	@Column(name = "DT_FIM_AFRETAMENTO")
	private Date dtFimAfretamento;
	
	@Column(name = "NM_BANDEIRA")
	private String nmBandeira;
	
	@JoinColumn (name = "ID_TIPO_AFRETAMENTO")
	@OneToOne
	private TipoAfretamento tipoAfretamento;
	
	@JoinColumn (name = "ID_TIPO_REGIME_AFRETAMENTO")
	@OneToOne
	private TipoRegimeAfretamento tipoRegimeAfretamento;
	
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

	public Date getDtInicioAfretamento() {
		return dtInicioAfretamento;
	}

	public void setDtInicioAfretamento(Date dtInicioAfretamento) {
		this.dtInicioAfretamento = dtInicioAfretamento;
	}

	public Date getDtFimAfretamento() {
		return dtFimAfretamento;
	}

	public void setDtFimAfretamento(Date dtFimAfretamento) {
		this.dtFimAfretamento = dtFimAfretamento;
	}

	public String getNmBandeira() {
		return nmBandeira;
	}

	public void setNmBandeira(String nmBandeira) {
		this.nmBandeira = nmBandeira;
	}

	public TipoAfretamento getTipoAfretamento() {
		return tipoAfretamento;
	}

	public void setTipoAfretamento(TipoAfretamento tipoAfretamento) {
		this.tipoAfretamento = tipoAfretamento;
	}

	public TipoRegimeAfretamento getTipoRegimeAfretamento() {
		return tipoRegimeAfretamento;
	}

	public void setTipoRegimeAfretamento(TipoRegimeAfretamento tipoRegimeAfretamento) {
		this.tipoRegimeAfretamento = tipoRegimeAfretamento;
	}

	public TipoEmbarcacao getTipoEmbarcacao() {
		return tipoEmbarcacao;
	}

	public void setTipoEmbarcacao(TipoEmbarcacao tipoEmbarcacao) {
		this.tipoEmbarcacao = tipoEmbarcacao;
	}

		
	
}
