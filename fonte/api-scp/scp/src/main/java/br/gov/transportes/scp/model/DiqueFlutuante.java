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
@Table(schema="BD_SCP",  name = "TB_DIQUE_FLUTUANTE")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_DIQUE_FLUTUANTE_ID_GENERATOR", sequenceName = "SQ_DIQUE_FLUTUANTE", allocationSize = 1)
public class DiqueFlutuante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667282920708347336L;

	@Id
	@Column(name="ID_DIQUE_FLUTUANTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_DIQUE_FLUTUANTE_ID_GENERATOR")
	private Long id;
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="NR_COMPRIMENTO")
	private Integer nrComprimento;
	
	@Column(name="NR_LARGURA")
	private Integer nrLargura;
	
	@Column(name="NR_CAPACIDADE")
	private Integer nrCapacidade;
	
	@Column(name="NR_CALADO_MAXIMO")
	private BigDecimal nrCaladoMaximo;

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

	public Integer getNrComprimento() {
		return nrComprimento;
	}

	public void setNrComprimento(Integer nrComprimento) {
		this.nrComprimento = nrComprimento;
	}

	public Integer getNrLargura() {
		return nrLargura;
	}

	public void setNrLargura(Integer nrLargura) {
		this.nrLargura = nrLargura;
	}

	public Integer getNrCapacidade() {
		return nrCapacidade;
	}

	public void setNrCapacidade(Integer nrCapacidade) {
		this.nrCapacidade = nrCapacidade;
	}

	public BigDecimal getNrCaladoMaximo() {
		return nrCaladoMaximo;
	}

	public void setNrCaladoMaximo(BigDecimal nrCaladoMaximo) {
		this.nrCaladoMaximo = nrCaladoMaximo;
	}
	
	
	
	
		
	
	
}
