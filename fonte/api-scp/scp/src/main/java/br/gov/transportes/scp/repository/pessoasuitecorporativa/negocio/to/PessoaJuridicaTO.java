package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

public class PessoaJuridicaTO {

	private Long id;
	private String nmRazaoSocial;
	private String nrCnpj;
	private PessoaTO pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}

	public String getNrCnpj() {
		return nrCnpj;
	}

	public void setNrCnpj(String nrCnpj) {
		this.nrCnpj = nrCnpj;
	}

	public PessoaTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
	}

}
