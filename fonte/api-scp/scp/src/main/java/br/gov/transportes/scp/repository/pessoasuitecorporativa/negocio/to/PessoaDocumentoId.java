package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

public class PessoaDocumentoId implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7154574966158630902L;
	
	private Long idPessoa;
	private Long idTipoDocumento;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((idTipoDocumento == null) ? 0 : idTipoDocumento.hashCode());
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
		PessoaDocumentoId other = (PessoaDocumentoId) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (idTipoDocumento == null) {
			if (other.idTipoDocumento != null)
				return false;
		} else if (!idTipoDocumento.equals(other.idTipoDocumento))
			return false;
		return true;
	}
	
	/**
     * @param other
     * @return boolean
     */
    private boolean verificaIgualdade(PessoaDocumentoId other) {
        if (verificaIgualdadeIdPessoa(other.idPessoa) && verificaIgualdadeIdTipoDocumento(other.idTipoDocumento))
            return true;
        return false;
    }

    /**
     * @param other
     * @return boolean
     */
    private boolean verificaIgualdadeIdTipoDocumento(Long other) {
        if (idTipoDocumento == null && other != null)
            return false;
        else if (!idTipoDocumento.equals(other))
            return false;
        return true;
    }

    /**
     * @param other
     * @return boolean
     */
    private boolean verificaIgualdadeIdPessoa(Long other) {
        if (idPessoa == null && other != null)
            return false;
        else if (!idPessoa.equals(other))
            return false;
        return true;
    }
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
}
