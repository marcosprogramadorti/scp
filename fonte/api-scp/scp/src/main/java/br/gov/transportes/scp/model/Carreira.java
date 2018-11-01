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
@Table(schema="BD_SCP",  name = "TB_CARREIRA")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_CARREIRA_ID_GENERATOR", sequenceName = "SQ_CARREIRA", allocationSize = 1)
public class Carreira implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3973935784339951039L;

	@Id
	@Column(name="ID_CARREIRA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_CARREIRA_ID_GENERATOR")
	private Long id;
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="TP_CARREIRA")
	private String tpCarreira;
	
	@Column(name="NR_COMPRIMENTO")
	private BigDecimal nrComprimento;
	
	@Column(name="NR_LARGURA")
	private BigDecimal nrLargura;
	
	@Column(name="NR_CAPACIDADE")
	private Integer nrCapacidade;

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

	public String getTpCarreira() {
		return tpCarreira;
	}

	public void setTpCarreira(String tpCarreira) {
		this.tpCarreira = tpCarreira;
	}

	public BigDecimal getNrComprimento() {
		return nrComprimento;
	}

	public void setNrComprimento(BigDecimal nrComprimento) {
		this.nrComprimento = nrComprimento;
	}

	public BigDecimal getNrLargura() {
		return nrLargura;
	}

	public void setNrLargura(BigDecimal nrLargura) {
		this.nrLargura = nrLargura;
	}

	public Integer getNrCapacidade() {
		return nrCapacidade;
	}

	public void setNrCapacidade(Integer nrCapacidade) {
		this.nrCapacidade = nrCapacidade;
	}
	
	


}
