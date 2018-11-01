package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TipoDiretorioTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String cdDiretorio;
    private Date dhCadastro;
    private String nmTipoDiretorio;
    private String stAtivo;
    private List<DiretorioTO> diretorios;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCdDiretorio() {
		return cdDiretorio;
	}
	public void setCdDiretorio(String cdDiretorio) {
		this.cdDiretorio = cdDiretorio;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public String getNmTipoDiretorio() {
		return nmTipoDiretorio;
	}
	public void setNmTipoDiretorio(String nmTipoDiretorio) {
		this.nmTipoDiretorio = nmTipoDiretorio;
	}
	public String getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}
	public List<DiretorioTO> getDiretorios() {
		return diretorios;
	}
	public void setDiretorios(List<DiretorioTO> diretorios) {
		this.diretorios = diretorios;
	}
    
    
}