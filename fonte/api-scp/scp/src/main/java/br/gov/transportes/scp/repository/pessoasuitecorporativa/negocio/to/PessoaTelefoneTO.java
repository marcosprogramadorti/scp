package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

public class PessoaTelefoneTO {
	
    private Long id;
    private TipoTelefoneTO tipoTelefone;
    private PessoaTO pessoa;
    private String nrTelefone;
    private String nrDdd;
    private String stPrincipal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoTelefoneTO getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefoneTO tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	public PessoaTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
	public String getNrDdd() {
		return nrDdd;
	}
	public void setNrDdd(String nrDdd) {
		this.nrDdd = nrDdd;
	}
	public String getStPrincipal() {
		return stPrincipal;
	}
	public void setStPrincipal(String stPrincipal) {
		this.stPrincipal = stPrincipal;
	}
    
    
	
    
    
}
