package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RepresentantePostulantePK implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7287832989453906473L;

	@Column(name = "ID_REPRESENTANTE")
	private Long idRepresentante;
	
	@Column(name = "ID_POSTULANTE")
	private Long idPostulante;

	public RepresentantePostulantePK() {
	
	}

	public Long getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public Long getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Long idPostulante) {
		this.idPostulante = idPostulante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPostulante == null) ? 0 : idPostulante.hashCode());
		result = prime * result + ((idRepresentante == null) ? 0 : idRepresentante.hashCode());
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
		RepresentantePostulantePK other = (RepresentantePostulantePK) obj;
		if (idPostulante == null) {
			if (other.idPostulante != null)
				return false;
		} else if (!idPostulante.equals(other.idPostulante))
			return false;
		if (idRepresentante == null) {
			if (other.idRepresentante != null)
				return false;
		} else if (!idRepresentante.equals(other.idRepresentante))
			return false;
		return true;
	}
	
	
	
	
	

}
