package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaisTO {
	
    private Long id;
    private String nmPais;
    private String sgPais;
    private Date dhCadastro;
    private List<RegiaoTO> regioes = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNmPais() {
		return nmPais;
	}
	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}
	public String getSgPais() {
		return sgPais;
	}
	public void setSgPais(String sgPais) {
		this.sgPais = sgPais;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public List<RegiaoTO> getRegioes() {
		return regioes;
	}
	public void setRegioes(List<RegiaoTO> regioes) {
		this.regioes = regioes;
	}
    
    
    
    

}
