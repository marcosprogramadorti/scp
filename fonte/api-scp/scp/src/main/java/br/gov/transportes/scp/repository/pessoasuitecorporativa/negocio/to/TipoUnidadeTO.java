package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;

public class TipoUnidadeTO {

    private Long idTipoUnidade;
    private String nmTipoUnidade;
    private String dsTipoUnidade;
    private String stAtivo;
    private Date dhCadastro;
	public Long getIdTipoUnidade() {
		return idTipoUnidade;
	}
	public void setIdTipoUnidade(Long idTipoUnidade) {
		this.idTipoUnidade = idTipoUnidade;
	}
	public String getNmTipoUnidade() {
		return nmTipoUnidade;
	}
	public void setNmTipoUnidade(String nmTipoUnidade) {
		this.nmTipoUnidade = nmTipoUnidade;
	}
	public String getDsTipoUnidade() {
		return dsTipoUnidade;
	}
	public void setDsTipoUnidade(String dsTipoUnidade) {
		this.dsTipoUnidade = dsTipoUnidade;
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
    
    
    
}
