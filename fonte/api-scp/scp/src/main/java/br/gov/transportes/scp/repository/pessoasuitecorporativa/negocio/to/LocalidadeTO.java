package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocalidadeTO {
	
	  private Long id;
	  private UfTO uf;
	  private String nmLocalidade;
	  private Date dhCadastro;
	  private String stAtivo;
	  private String dsLocalidade;
	  private List<PessoaEnderecoTO> pessoaEnderecos = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UfTO getUf() {
		return uf;
	}
	public void setUf(UfTO uf) {
		this.uf = uf;
	}
	public String getNmLocalidade() {
		return nmLocalidade;
	}
	public void setNmLocalidade(String nmLocalidade) {
		this.nmLocalidade = nmLocalidade;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public String getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}
	public String getDsLocalidade() {
		return dsLocalidade;
	}
	public void setDsLocalidade(String dsLocalidade) {
		this.dsLocalidade = dsLocalidade;
	}
	public List<PessoaEnderecoTO> getPessoaEnderecos() {
		return pessoaEnderecos;
	}
	public void setPessoaEnderecos(List<PessoaEnderecoTO> pessoaEnderecos) {
		this.pessoaEnderecos = pessoaEnderecos;
	}
	  
	  
	    
	    

}
