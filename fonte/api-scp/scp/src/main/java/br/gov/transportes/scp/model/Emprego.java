package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(schema="BD_SCP",  name = "TB_EMPREGO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EMPREGO_ID_GENERATOR", sequenceName = "SQ_EMPREGO", allocationSize = 1)
public class Emprego implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667282920708347336L;

	@Id
	@Column(name="ID_EMPREGO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EMPREGO_ID_GENERATOR")
	private Long id;
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="ID_UF")
	private Long idUf;
	
	@Column(name="QT_AREA_PROJETO")
	private Integer qtAreaProjeto;
	
	@Column(name="QT_AREA_PLANEJAMENTO")
	private Integer qtAreaPlanejamento;
	
	@Column(name="QT_AREA_ADMINISTRACAO")
	private Integer qtAreaAdministracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEstaleiro() {
		return idEstaleiro;
	}

	public void setIdEstaleiro(Long idEstaleiro) {
		this.idEstaleiro = idEstaleiro;
	}

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	public Integer getQtAreaProjeto() {
		return qtAreaProjeto;
	}

	public void setQtAreaProjeto(Integer qtAreaProjeto) {
		this.qtAreaProjeto = qtAreaProjeto;
	}

	public Integer getQtAreaPlanejamento() {
		return qtAreaPlanejamento;
	}

	public void setQtAreaPlanejamento(Integer qtAreaPlanejamento) {
		this.qtAreaPlanejamento = qtAreaPlanejamento;
	}

	public Integer getQtAreaAdministracao() {
		return qtAreaAdministracao;
	}

	public void setQtAreaAdministracao(Integer qtAreaAdministracao) {
		this.qtAreaAdministracao = qtAreaAdministracao;
	}

	
	
	
	
	
	
}
