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
@Table(schema="BD_SCP",  name = "TB_EQUIPAMENTO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_EQUIPAMENTO_ID_GENERATOR", sequenceName = "SQ_EQUIPAMENTO", allocationSize = 1)
public class Equipamento implements Serializable {

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6219582853181194213L;

	@Id
	@Column(name="ID_EQUIPAMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_EQUIPAMENTO_ID_GENERATOR")
	private Long id;
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="TP_EQUIPAMENTO")
	private String tpEquipamento;
	
	@Column(name="DS_LOCALIZACAO")
	private String dsLocalizacao;
	
	@Column(name="QT_EQUIPAMENTO")
	private Integer qtEquipamento;
	
	@Column(name="NR_CAPACIDADE")
	private Integer nrCapacidade;
	
	@Column(name="NM_EQUIPAMENTO")
	private String nmEquipamento;
	
	@Column(name="NR_AREA")
	private Long nrArea;

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

	public String getTpEquipamento() {
		return tpEquipamento;
	}

	public void setTpEquipamento(String tpEquipamento) {
		this.tpEquipamento = tpEquipamento;
	}

	public String getDsLocalizacao() {
		return dsLocalizacao;
	}

	public void setDsLocalizacao(String dsLocalizacao) {
		this.dsLocalizacao = dsLocalizacao;
	}

	public Integer getQtEquipamento() {
		return qtEquipamento;
	}

	public void setQtEquipamento(Integer qtEquipamento) {
		this.qtEquipamento = qtEquipamento;
	}

	public Integer getNrCapacidade() {
		return nrCapacidade;
	}

	public void setNrCapacidade(Integer nrCapacidade) {
		this.nrCapacidade = nrCapacidade;
	}

	public String getNmEquipamento() {
		return nmEquipamento;
	}

	public void setNmEquipamento(String nmEquipamento) {
		this.nmEquipamento = nmEquipamento;
	}

	public Long getNrArea() {
		return nrArea;
	}

	public void setNrArea(Long nrArea) {
		this.nrArea = nrArea;
	}
	
	
	
	
	
	


}
