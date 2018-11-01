package br.gov.transportes.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class AnexoEstaleiroPK implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7782808315739688835L;

	@Column(name="ID_ESTALEIRO")
	private Long idEstaleiro;
	
	@Column(name="ID_ARQUIVO")
	private Long idArquivo;
	
	@Column(name="ID_TIPO_ANEXO")
	private Integer idTipoAnexo;
	
	@Column(name="ST_ATIVO")
	private String stAtivo;
	
	@Column(name="DH_CADASTRO")
	private String dhCadastro;

	public Long getIdEstaleiro() {
		return idEstaleiro;
	}

	public void setIdEstaleiro(Long idEstaleiro) {
		this.idEstaleiro = idEstaleiro;
	}

	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public Integer getIdTipoAnexo() {
		return idTipoAnexo;
	}

	public void setIdTipoAnexo(Integer idTipoAnexo) {
		this.idTipoAnexo = idTipoAnexo;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getDhCadastro() {
		return dhCadastro;
	}

	public void setDhCadastro(String dhCadastro) {
		this.dhCadastro = dhCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArquivo == null) ? 0 : idArquivo.hashCode());
		result = prime * result + ((idEstaleiro == null) ? 0 : idEstaleiro.hashCode());
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
		AnexoEstaleiroPK other = (AnexoEstaleiroPK) obj;
		if (idArquivo == null) {
			if (other.idArquivo != null)
				return false;
		} else if (!idArquivo.equals(other.idArquivo))
			return false;
		if (idEstaleiro == null) {
			if (other.idEstaleiro != null)
				return false;
		} else if (!idEstaleiro.equals(other.idEstaleiro))
			return false;
		return true;
	}
	
	
	
	

		
}
