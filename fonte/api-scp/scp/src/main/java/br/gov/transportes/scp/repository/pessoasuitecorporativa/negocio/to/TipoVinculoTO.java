package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;

public class TipoVinculoTO {
	
    private Long id;
    private String nmTipoVinculo;
    private String dsTipoVinculo;
    private String stAtivo;
    private Date dhCadastro;
    private Character tpPessoa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNmTipoVinculo() {
		return nmTipoVinculo;
	}
	public void setNmTipoVinculo(String nmTipoVinculo) {
		this.nmTipoVinculo = nmTipoVinculo;
	}
	public String getDsTipoVinculo() {
		return dsTipoVinculo;
	}
	public void setDsTipoVinculo(String dsTipoVinculo) {
		this.dsTipoVinculo = dsTipoVinculo;
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
	public Character getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(Character tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
    
    
    
}
