package br.gov.transportes.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class SolicitacaoAcessoArquivoPK implements Serializable{
	
	private static final long serialVersionUID = -8350098582389450160L;

	@Column(name="ID_SOLICITACAO_ACESSO")
	private Long idSolicitacaoAcesso;
	
	@Column(name="ID_ARQUIVO")
	private Long idArquivo;

	public Long getIdSolicitacaoAcesso() {
		return idSolicitacaoAcesso;
	}

	public void setIdSolicitacaoAcesso(Long idSolicitacaoAcesso) {
		this.idSolicitacaoAcesso = idSolicitacaoAcesso;
	}

	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArquivo == null) ? 0 : idArquivo.hashCode());
		result = prime * result + ((idSolicitacaoAcesso == null) ? 0 : idSolicitacaoAcesso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolicitacaoAcessoArquivoPK other = (SolicitacaoAcessoArquivoPK) obj;
		if (idArquivo == null) {
			if (other.idArquivo != null)
				return false;
		} else if (!idArquivo.equals(other.idArquivo))
			return false;
		if (idSolicitacaoAcesso == null) {
			if (other.idSolicitacaoAcesso != null)
				return false;
		} else if (!idSolicitacaoAcesso.equals(other.idSolicitacaoAcesso))
			return false;
		return true;
	}
	
}
