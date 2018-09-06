package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipoLogradouroTO {
    private Long id;
    private String nmTipoLogradouro;
    private String dsTipoLogradouro;
    private String stAtivo;
    private Date dhCadastro;
    private List<PessoaEnderecoTO> pessoaEnderecos = new ArrayList<PessoaEnderecoTO>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNmTipoLogradouro() {
		return nmTipoLogradouro;
	}
	public void setNmTipoLogradouro(String nmTipoLogradouro) {
		this.nmTipoLogradouro = nmTipoLogradouro;
	}
	public String getDsTipoLogradouro() {
		return dsTipoLogradouro;
	}
	public void setDsTipoLogradouro(String dsTipoLogradouro) {
		this.dsTipoLogradouro = dsTipoLogradouro;
	}
	public String getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public List<PessoaEnderecoTO> getPessoaEnderecos() {
		return pessoaEnderecos;
	}
	public void setPessoaEnderecos(List<PessoaEnderecoTO> pessoaEnderecos) {
		this.pessoaEnderecos = pessoaEnderecos;
	}
    
    
    
    
}
