package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SCP", name="TB_SOLICITACAO_ACESSO")
@SequenceGenerator(schema="BD_SCP", name = "TB_SOLICITACAO_ACESSO_ID_GENERATOR", sequenceName = "BD_SCP.SQ_SOLICITACAO_ACESSO", allocationSize = 1)
public class SolicitacaoAcesso implements Serializable{

	private static final long serialVersionUID = -3135039127172619994L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_SOLICITACAO_ACESSO_ID_GENERATOR")
	@Column(name="ID_SOLICITACAO_ACESSO")
	private Long id;
	
	@Column(name="ID_USUARIO_ANALISTA")
	private Long idUsuarioAnalista;
	
	@Column(name="ST_SITUACAO")
	private String stSituacao;
	
	@Column(name="DT_SOLICITACAO_ACESSO")
	private Date dtSolicitacaoAcesso;
	
	@Column(name="DT_ATRIBUICAO")
	private Date dtAtribuicao;
	
	@Column(name="DT_ANALISE")
	private Date dtAnalise;
	
	@Column(name="DS_MOTIVO_INDEFERIMENTO")
	private String dsMotivoIndeferimento;
	
	@Column(name="ID_PESSOA_EMPRESA_SOLICITANTE")
	private Long idPessoaJuridicaSolicitante;
	
	@Column(name="ID_PESSOA_FISICA_SOLICITANTE")
	private Long idPessoaFisicaSolicitante;
	
	@OneToMany(mappedBy="solicitacaoAcesso")
	private Set<SolicitacaoAcessoArquivo> solicitacaoAcessoArquivos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuarioAnalista() {
		return idUsuarioAnalista;
	}

	public void setIdUsuarioAnalista(Long idUsuarioAnalista) {
		this.idUsuarioAnalista = idUsuarioAnalista;
	}

	public String getStSituacao() {
		return stSituacao;
	}

	public void setStSituacao(String stSituacao) {
		this.stSituacao = stSituacao;
	}

	public Date getDtSolicitacaoAcesso() {
		return dtSolicitacaoAcesso;
	}

	public void setDtSolicitacaoAcesso(Date dtSolicitacaoAcesso) {
		this.dtSolicitacaoAcesso = dtSolicitacaoAcesso;
	}

	public Date getDtAtribuicao() {
		return dtAtribuicao;
	}

	public void setDtAtribuicao(Date dtAtribuicao) {
		this.dtAtribuicao = dtAtribuicao;
	}

	public Date getDtAnalise() {
		return dtAnalise;
	}

	public void setDtAnalise(Date dtAnalise) {
		this.dtAnalise = dtAnalise;
	}

	public String getDsMotivoIndeferimento() {
		return dsMotivoIndeferimento;
	}

	public void setDsMotivoIndeferimento(String dsMotivoIndeferimento) {
		this.dsMotivoIndeferimento = dsMotivoIndeferimento;
	}

	public Long getIdPessoaJuridicaSolicitante() {
		return idPessoaJuridicaSolicitante;
	}

	public void setIdPessoaJuridicaSolicitante(Long idPessoaJuridicaSolicitante) {
		this.idPessoaJuridicaSolicitante = idPessoaJuridicaSolicitante;
	}

	public Long getIdPessoaFisicaSolicitante() {
		return idPessoaFisicaSolicitante;
	}

	public void setIdPessoaFisicaSolicitante(Long idPessoaFisicaSolicitante) {
		this.idPessoaFisicaSolicitante = idPessoaFisicaSolicitante;
	}

	public Set<SolicitacaoAcessoArquivo> getSolicitacaoAcessoArquivos() {
		return solicitacaoAcessoArquivos;
	}

	public void setSolicitacaoAcessoArquivos(Set<SolicitacaoAcessoArquivo> solicitacaoAcessoArquivos) {
		this.solicitacaoAcessoArquivos = solicitacaoAcessoArquivos;
	}

}
