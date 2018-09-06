package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;
import java.util.List;

public class RegiaoTO {
	
    private Long id;
    private PaisTO pais;
    private String nmRegiao;
    private Date dhCadastro;
    private List<UfTO> ufs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PaisTO getPais() {
		return pais;
	}
	public void setPais(PaisTO pais) {
		this.pais = pais;
	}
	public String getNmRegiao() {
		return nmRegiao;
	}
	public void setNmRegiao(String nmRegiao) {
		this.nmRegiao = nmRegiao;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public List<UfTO> getUfs() {
		return ufs;
	}
	public void setUfs(List<UfTO> ufs) {
		this.ufs = ufs;
	}
    
    
    
}
