package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UfTO {
	
	private Long id;
    private RegiaoTO regiao;
    private String nmUf;
    private String sgUf;
    private Date dhCadastro;
    private List<LocalidadeTO> localidades = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RegiaoTO getRegiao() {
		return regiao;
	}
	public void setRegiao(RegiaoTO regiao) {
		this.regiao = regiao;
	}
	public String getNmUf() {
		return nmUf;
	}
	public void setNmUf(String nmUf) {
		this.nmUf = nmUf;
	}
	public String getSgUf() {
		return sgUf;
	}
	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public List<LocalidadeTO> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<LocalidadeTO> localidades) {
		this.localidades = localidades;
	}
    
    
    
    

}
