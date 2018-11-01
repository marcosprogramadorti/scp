package br.gov.transportes.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(schema="BD_SCP",  name = "TB_CAPACIDADE_PROCESSAMENTO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_CAPACIDADE_PROCESSAMENTO_ID_GENERATOR", sequenceName = "SQ_CAPACIDADE_PROCESSAMENTO", allocationSize = 1)
public class CapacidadeProcessamento implements Serializable {

		

	/**
	 * 
	 */
	private static final long serialVersionUID = -9169722888535443548L;

	@Id
	@Column(name="ID_CAPACIDADE_PROCESSAMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_CAPACIDADE_PROCESSAMENTO_ID_GENERATOR")
	private Long id;												 
	
	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	
	@Column(name="NR_CAPACIDADE_PROCESSAMENTO")
	private Integer nrCapacidadeProcessamento;
	
	@Column(name="TP_MATERIAL")
	private String tpMaterial;

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

	public Integer getNrCapacidadeProcessamento() {
		return nrCapacidadeProcessamento;
	}

	public void setNrCapacidadeProcessamento(Integer nrCapacidadeProcessamento) {
		this.nrCapacidadeProcessamento = nrCapacidadeProcessamento;
	}

	public String getTpMaterial() {
		return tpMaterial;
	}

	public void setTpMaterial(String tpMaterial) {
		this.tpMaterial = tpMaterial;
	}
	
	
	
	
	


}
