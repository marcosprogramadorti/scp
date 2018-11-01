package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import javax.persistence.Table;



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
	
	@Column(name = "SG_PESSOA_JURIDICA")
	private String sgPessoaJuridica;
	
	@Column(name = "TP_FORMA_JURIDICA")
	private String tpFormaJuridica;
	
	@Column(name = "DT_REGISTRO")
	private Date dtRegistro;
	
	@Column(name = "DS_PRAZO_DURACAO")
	private String dsPrazoDuracao;
	
	@Column(name = "VL_CAPITAL_SOCIAL")
	private BigDecimal vlCapitalSocial;
	
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
	
	@Column(name = "NM_ATIVIDADE_PRINCIPAL")
	private String nmAtividadePrincipal;
	
	@Column(name = "NM_SEDE_FORO")
	private String nmSedeForo;
	
	@Column(name = "NM_SITIO_ELETRONICO")
	private String nmSitioEletronico;
	
	@Column(name = "NM_CAPITAL_SOCIAL_INTEGRAL")
	private String nmCapitalSocialIntegral;
	
	
	@ManyToOne (cascade= CascadeType.ALL)
	@JoinColumn(name="ID_TIPO_EMPRESA")
	private TipoEmpresa tipoEmpresa;

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

	public String getSgPessoaJuridica() {
		return sgPessoaJuridica;
	}

	public void setSgPessoaJuridica(String sgPessoaJuridica) {
		this.sgPessoaJuridica = sgPessoaJuridica;
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

	public String getDsPrazoDuracao() {
		return dsPrazoDuracao;
	}

	public void setDsPrazoDuracao(String dsPrazoDuracao) {
		this.dsPrazoDuracao = dsPrazoDuracao;
	}

	public BigDecimal getVlCapitalSocial() {
		return vlCapitalSocial;
	}

	public void setVlCapitalSocial(BigDecimal vlCapitalSocial) {
		this.vlCapitalSocial = vlCapitalSocial;
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

	public String getNmAtividadePrincipal() {
		return nmAtividadePrincipal;
	}

	public void setNmAtividadePrincipal(String nmAtividadePrincipal) {
		this.nmAtividadePrincipal = nmAtividadePrincipal;
	}

	public String getNmSedeForo() {
		return nmSedeForo;
	}

	public void setNmSedeForo(String nmSedeForo) {
		this.nmSedeForo = nmSedeForo;
	}

	public String getNmSitioEletronico() {
		return nmSitioEletronico;
	}

	public void setNmSitioEletronico(String nmSitioEletronico) {
		this.nmSitioEletronico = nmSitioEletronico;
	}

	public String getNmCapitalSocialIntegral() {
		return nmCapitalSocialIntegral;
	}

	public void setNmCapitalSocialIntegral(String nmCapitalSocialIntegral) {
		this.nmCapitalSocialIntegral = nmCapitalSocialIntegral;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	
	

		
}
