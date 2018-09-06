package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;

public class PessoaEmailTO {
	
    private Long id;
    private PessoaTO pessoa;
    private String dsEmail;
    private String stPrincipal;
    private Date dhCadastro;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PessoaTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public String getStPrincipal() {
		return stPrincipal;
	}
	public void setStPrincipal(String stPrincipal) {
		this.stPrincipal = stPrincipal;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
    
    
    
    
    
    
}
