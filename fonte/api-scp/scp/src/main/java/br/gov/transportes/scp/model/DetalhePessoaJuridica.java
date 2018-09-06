package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(schema="BD_SCP",  name = "TB_DETALHE_PESSOA_JURIDICA")
public class DetalhePessoaJuridica implements Serializable {

	/**
	 * Author: Marcos Tavares
	 * Data: 28/08/2018
	 */
	private static final long serialVersionUID = -4145316646830626641L;
	
	@Id
	@Column(name = "ID_PESSOA")
	private Long id;
	
	
	@Column(name = "NR_INSCRICAO_ESTADUAL")
	private Long nrInscricaoEstadual;
	
	@Column(name = "SG_POSTULANTE")
	private String sgPostulante;
	
	@Column(name = "TP_FORMA_JURIDICA")
	private String tpFormaJuridica;
	
	@Column(name = "DT_REGISTRO")
	private Date dtRegistro;
	
	@Column(name = "NR_PRAZO_DURACAO")
	private BigDecimal nrPrazoDuracao;
	
	@Column(name = "VL_CAPITAL_SOCIAL")
	private BigDecimal vlCapitalSocila;
	
	@Column(name = "DT_ULTIMA_ATUALIZACAO")
	private Date dtUltimaAtualizacao;
	
	@Column(name = "DS_HISTORICO_EMPRESA")
	private String dsHistoricoEmpresa;
	
	@Column(name = "DS_INFORMACAO_ADICIONAL")
	private String dsInformacaoAdicional;
	
	@Column(name = "ST_ATIVO")
	private String stAtivo;
	
	@OneToMany(mappedBy = "idDetalhePessoaJuridica", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ParticipacaoSocietaria> listaParticipacaoSocietaria;
	
	@OneToMany(mappedBy = "idDetalhePessoaJuridica", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmpresaGrupoEconomico> listaEmpresaGrupoEconomico;
	
	@OneToMany(mappedBy = "idDetalhePessoaJuridica", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Diretoria> listaDiretoria;
	
	@OneToMany(mappedBy = "idDetalhePessoaJuridica", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FirmaAntecessora> listaFirmaAntecessora;
	
	@Column(name = "NM_GRUPO_ECONOMICO")
	private String nmGrupoEconomico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNrInscricaoEstadual() {
		return nrInscricaoEstadual;
	}

	public void setNrInscricaoEstadual(Long nrInscricaoEstadual) {
		this.nrInscricaoEstadual = nrInscricaoEstadual;
	}

	public String getSgPostulante() {
		return sgPostulante;
	}

	public void setSgPostulante(String sgPostulante) {
		this.sgPostulante = sgPostulante;
	}

	public String getTpFormaJuridica() {
		return tpFormaJuridica;
	}

	public void setTpFormaJuridica(String tpFormaJuridica) {
		this.tpFormaJuridica = tpFormaJuridica;
	}

	public Date getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public BigDecimal getNrPrazoDuracao() {
		return nrPrazoDuracao;
	}

	public void setNrPrazoDuracao(BigDecimal nrPrazoDuracao) {
		this.nrPrazoDuracao = nrPrazoDuracao;
	}

	public BigDecimal getVlCapitalSocila() {
		return vlCapitalSocila;
	}

	public void setVlCapitalSocila(BigDecimal vlCapitalSocila) {
		this.vlCapitalSocila = vlCapitalSocila;
	}

	public Date getDtUltimaAtualizacao() {
		return dtUltimaAtualizacao;
	}

	public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
	}

	public String getDsHistoricoEmpresa() {
		return dsHistoricoEmpresa;
	}

	public void setDsHistoricoEmpresa(String dsHistoricoEmpresa) {
		this.dsHistoricoEmpresa = dsHistoricoEmpresa;
	}

	public String getDsInformacaoAdicional() {
		return dsInformacaoAdicional;
	}

	public void setDsInformacaoAdicional(String dsInformacaoAdicional) {
		this.dsInformacaoAdicional = dsInformacaoAdicional;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public List<ParticipacaoSocietaria> getListaParticipacaoSocietaria() {
		return listaParticipacaoSocietaria;
	}

	public void setListaParticipacaoSocietaria(List<ParticipacaoSocietaria> listaParticipacaoSocietaria) {
		this.listaParticipacaoSocietaria = listaParticipacaoSocietaria;
	}

	public List<EmpresaGrupoEconomico> getListaEmpresaGrupoEconomico() {
		return listaEmpresaGrupoEconomico;
	}

	public void setListaEmpresaGrupoEconomico(List<EmpresaGrupoEconomico> listaEmpresaGrupoEconomico) {
		this.listaEmpresaGrupoEconomico = listaEmpresaGrupoEconomico;
	}

	public List<Diretoria> getListaDiretoria() {
		return listaDiretoria;
	}

	public void setListaDiretoria(List<Diretoria> listaDiretoria) {
		this.listaDiretoria = listaDiretoria;
	}

	public List<FirmaAntecessora> getListaFirmaAntecessora() {
		return listaFirmaAntecessora;
	}

	public void setListaFirmaAntecessora(List<FirmaAntecessora> listaFirmaAntecessora) {
		this.listaFirmaAntecessora = listaFirmaAntecessora;
	}

	public String getNmGrupoEconomico() {
		return nmGrupoEconomico;
	}

	public void setNmGrupoEconomico(String nmGrupoEconomico) {
		this.nmGrupoEconomico = nmGrupoEconomico;
	}

	
	
	
	
	
	
	

}
