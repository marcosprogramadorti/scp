package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;

public class PessoaFisicaTO {
	
	private Long id;
	private Date dtNascimento;
	private String nrCpf;
	private String tpSexo;
	private String nmMae;
	private String stNomeMae;
	private PessoaTO pessoa;
	private String dsCargo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getNrCpf() {
		return nrCpf;
	}
	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}
	public String getTpSexo() {
		return tpSexo;
	}
	public void setTpSexo(String tpSexo) {
		this.tpSexo = tpSexo;
	}
	public String getNmMae() {
		return nmMae;
	}
	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}
	public String getStNomeMae() {
		return stNomeMae;
	}
	public void setStNomeMae(String stNomeMae) {
		this.stNomeMae = stNomeMae;
	}
	public PessoaTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
	}
	public String getDsCargo() {
		return dsCargo;
	}
	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}
	
	
	   
	
	

}
