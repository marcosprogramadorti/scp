package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SCP",  name = "TB_REPRESENTANTE")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_REPRESENTANTE_ID_GENERATOR", sequenceName = "SQ_REPRESENTANTE", allocationSize = 1)
public class Representante implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 11/10/2018
	 */

	private static final long serialVersionUID = 7586334677667546668L;

	@Id
	@Column(name = "ID_REPRESENTANTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_REPRESENTANTE_ID_GENERATOR")
	private Long id;
	
	
	@Column(name = "ID_PESSOA_FISICA")
	private Long idPessoaFisica;
	
	@Column(name = "ID_USUARIO_REPRESENTANTE")
	private Long idUsuarioRepresentante;
	
	@Column(name = "ID_SOLICITACAO_ACESSO")
	private Long idSolicitacaoAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public Long getIdUsuarioRepresentante() {
		return idUsuarioRepresentante;
	}

	public void setIdUsuarioRepresentante(Long idUsuarioRepresentante) {
		this.idUsuarioRepresentante = idUsuarioRepresentante;
	}

	public Long getIdSolicitacaoAcesso() {
		return idSolicitacaoAcesso;
	}

	public void setIdSolicitacaoAcesso(Long idSolicitacaoAcesso) {
		this.idSolicitacaoAcesso = idSolicitacaoAcesso;
	}
	
	

	
	

	
	
		
}
