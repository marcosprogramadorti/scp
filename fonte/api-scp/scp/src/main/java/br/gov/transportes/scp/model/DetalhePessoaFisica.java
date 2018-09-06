package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(schema="BD_SCP",  name = "TB_DETALHE_PESSOA_FISICA")
@SequenceGenerator(name = "SQ_DETALHE_PESSOA_FISICA", sequenceName = "SQ_DETALHE_PESSOA_FISICA", allocationSize = 1)
public class DetalhePessoaFisica implements Serializable {

	/**
	 * Author: Marcos Tavares
	 * Data: 28/08/2018
	 */
	private static final long serialVersionUID = -4145316646830626641L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DETALHE_PESSOA_FISICA")
	@Column(name = "ID_PESSOA")
	private Long id;
	
	
	@Column(name = "ID_PAIS_NACIONALIDADE")
	private Long idPaisNacionalidade;
	
	@Column(name = "TP_REGIME_CASAMENTO")
	private String tpRegimeCasamento;
	
	@Column(name = "ST_ATIVO")
	private String stAtivo;
	
	@Column(name = "DT_CHEGADA_BRASIL")
	private Date dtChegadaBrasil;
	
	@Column(name = "DS_INFORMACAO_ADICIONAL")
	private String dsInformacaoAdicional;
	
	
	//@OneToMany(mappedBy = "detalhePessoaFisica", cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(mappedBy = "idPessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExperienciaProfissional> experienciasProfissionais;  
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getIdPaisNacionalidade() {
		return idPaisNacionalidade;
	}

	public void setIdPaisNacionalidade(Long idPaisNacionalidade) {
		this.idPaisNacionalidade = idPaisNacionalidade;
	}

	public String getTpRegimeCasamento() {
		return tpRegimeCasamento;
	}

	public void setTpRegimeCasamento(String tpRegimeCasamento) {
		this.tpRegimeCasamento = tpRegimeCasamento;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public Date getDtChegadaBrasil() {
		return dtChegadaBrasil;
	}

	public void setDtChegadaBrasil(Date dtChegadaBrasil) {
		this.dtChegadaBrasil = dtChegadaBrasil;
	}

	public String getDsInformacaoAdicional() {
		return dsInformacaoAdicional;
	}

	public void setDsInformacaoAdicional(String dsInformacaoAdicional) {
		this.dsInformacaoAdicional = dsInformacaoAdicional;
	}
	
	

	public List<ExperienciaProfissional> getExperienciasProfissionais() {
		return experienciasProfissionais;
	}

	public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
		this.experienciasProfissionais = experienciasProfissionais;
	}

	@Override
	public String toString() {
		return "DetalhePessoaFisica [id=" + id + ", idPaisNacionalidade="
				+ idPaisNacionalidade + ", tpRegimeCasamento=" + tpRegimeCasamento + ", stAtivo=" + stAtivo
				+ ", dtChegadaBrasil=" + dtChegadaBrasil + ", dsInformacaoAdicional=" + dsInformacaoAdicional + "]";
	}
	
	
	
	

}
