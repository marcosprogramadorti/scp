package br.gov.transportes.scp.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SCP", name="RL_SOLICITACAO_ACESSO_ARQUIVO")
public class SolicitacaoAcessoArquivo implements Serializable{

	private static final long serialVersionUID = -3135039127172619994L;

	@EmbeddedId
	private SolicitacaoAcessoArquivoPK id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SOLICITACAO_ACESSO", insertable = false, updatable = false)
	private SolicitacaoAcesso solicitacaoAcesso;

	public SolicitacaoAcessoArquivoPK getId() {
		return id;
	}

	public void setId(SolicitacaoAcessoArquivoPK id) {
		this.id = id;
	}
	
}
