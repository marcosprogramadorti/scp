package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipoEnderecoTO {
	
    private Long id;
    private String nmTipoEndereco;
    private String dsTipoEndereco;
    private String stAtivo;
    private Date dhCadastro;
    private List<PessoaEnderecoTO> pessoaEnderecos = new ArrayList<PessoaEnderecoTO>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNmTipoEndereco() {
		return nmTipoEndereco;
	}
	public void setNmTipoEndereco(String nmTipoEndereco) {
		this.nmTipoEndereco = nmTipoEndereco;
	}
	public String getDsTipoEndereco() {
		return dsTipoEndereco;
	}
	public void setDsTipoEndereco(String dsTipoEndereco) {
		this.dsTipoEndereco = dsTipoEndereco;
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
