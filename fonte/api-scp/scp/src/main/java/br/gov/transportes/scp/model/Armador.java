package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(schema="BD_SCP",  name = "TB_ARMADOR")
public class Armador implements Serializable {


	/**
	 * Author: Marcos Tavares
	 * Data: 16/10/2018
	 */
	private static final long serialVersionUID = -6933878337351434362L;

	
	@Id
	@Column(name = "ID_POSTULANTE")
	private Long id;
	
	@Column(name = "DS_HISTORICO_OPERACIONAL")
	private String dsHistoricoOperacional;
	
	@Column(name = "ST_ATIVO")
	private String stAtivo;
	
	@OneToMany(mappedBy = "idPostulante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmbarcacaoAfretada> embarcacoesAfretadas;
	
	@OneToMany(mappedBy = "idPostulante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmbarcacaoPropria> embarcacoesProprias;
	
	@OneToMany(mappedBy = "idPostulante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmbarcacaoConstrucao> embarcacoesConstrucoes;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsHistoricoOperacional() {
		return dsHistoricoOperacional;
	}

	public void setDsHistoricoOperacional(String dsHistoricoOperacional) {
		this.dsHistoricoOperacional = dsHistoricoOperacional;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public List<EmbarcacaoAfretada> getEmbarcacoesAfretadas() {
		return embarcacoesAfretadas;
	}

	public void setEmbarcacoesAfretadas(List<EmbarcacaoAfretada> embarcacoesAfretadas) {
		this.embarcacoesAfretadas = embarcacoesAfretadas;
	}

	public List<EmbarcacaoPropria> getEmbarcacoesProprias() {
		return embarcacoesProprias;
	}

	public void setEmbarcacoesProprias(List<EmbarcacaoPropria> embarcacoesProprias) {
		this.embarcacoesProprias = embarcacoesProprias;
	}

	public List<EmbarcacaoConstrucao> getEmbarcacoesConstrucoes() {
		return embarcacoesConstrucoes;
	}

	public void setEmbarcacoesConstrucoes(List<EmbarcacaoConstrucao> embarcacoesConstrucoes) {
		this.embarcacoesConstrucoes = embarcacoesConstrucoes;
	}

	
	
	
	
	

	
	
	
}
