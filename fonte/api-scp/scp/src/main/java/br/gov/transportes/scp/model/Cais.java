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
@Table(schema="BD_SCP",  name = "TB_CAIS")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_CAIS_ID_GENERATOR", sequenceName = "SQ_CAIS", allocationSize = 1)
public class Cais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5443882554477099161L;

	@Id
	@Column(name="ID_CAIS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_CAIS_ID_GENERATOR")
	private Long id;
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="NR_COMPRIMENTO")
	private BigDecimal nrComprimento;
	
	@Column(name="NR_CALADO")
	private BigDecimal nrCalado;

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

	public BigDecimal getNrComprimento() {
		return nrComprimento;
	}

	public void setNrComprimento(BigDecimal nrComprimento) {
		this.nrComprimento = nrComprimento;
	}

	public BigDecimal getNrCalado() {
		return nrCalado;
	}

	public void setNrCalado(BigDecimal nrCalado) {
		this.nrCalado = nrCalado;
	}
	
	
	
	
	
}
