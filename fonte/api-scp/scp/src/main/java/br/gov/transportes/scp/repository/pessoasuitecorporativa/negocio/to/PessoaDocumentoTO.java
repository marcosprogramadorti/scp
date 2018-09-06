package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;
public class PessoaDocumentoTO {
    
	private PessoaDocumentoId id;
    private TipoDocumentoTO tipoDocumento;
    private PessoaTO pessoa;
    private String nrDocumento;
    
    
	public TipoDocumentoTO getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public PessoaTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
	}
	public String getNrDocumento() {
		return nrDocumento;
	}
	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}
	public PessoaDocumentoId getId() {
		return id;
	}
	public void setId(PessoaDocumentoId id) {
		this.id = id;
	}
    
    
	

    
}
