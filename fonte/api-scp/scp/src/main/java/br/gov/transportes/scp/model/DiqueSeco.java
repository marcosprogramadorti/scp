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
@Table(schema="BD_SCP",  name = "TB_DIQUE_SECO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_DIQUE_SECO_ID_GENERATOR", sequenceName = "SQ_DIQUE_SECO", allocationSize = 1)
public class DiqueSeco implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3973935784339951039L;

	@Id
	@Column(name="ID_DIQUE_SECO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_DIQUE_SECO_ID_GENERATOR")
	private Long id;
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="NR_LARGURA_INTERNA_UTIL")
	private BigDecimal nrLarguraInternaUtil;
	
	@Column(name="NR_BOCA")
	private Integer nrLargura;

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

	public BigDecimal getNrLarguraInternaUtil() {
		return nrLarguraInternaUtil;
	}

	public void setNrLarguraInternaUtil(BigDecimal nrLarguraInternaUtil) {
		this.nrLarguraInternaUtil = nrLarguraInternaUtil;
	}

	public Integer getNrLargura() {
		return nrLargura;
	}

	public void setNrLargura(Integer nrLargura) {
		this.nrLargura = nrLargura;
	}
	
	
	
		
}
