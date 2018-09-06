package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;

public class UnidadeTO {

    private Long id;
    private TipoUnidadeTO tipoUnidade;
    private String tpOrigemUnidade;
    private UnidadeTO unidadeSuperior;
    private String nmUnidade;
    private String sgUnidade;
    private String stAtivo;
    private Date dhCadastro;
    private String dsUnidade;
    private Long idUnidadeSuperior;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoUnidadeTO getTipoUnidade() {
		return tipoUnidade;
	}
	public void setTipoUnidade(TipoUnidadeTO tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
	public String getTpOrigemUnidade() {
		return tpOrigemUnidade;
	}
	public void setTpOrigemUnidade(String tpOrigemUnidade) {
		this.tpOrigemUnidade = tpOrigemUnidade;
	}
	public UnidadeTO getUnidadeSuperior() {
		return unidadeSuperior;
	}
	public void setUnidadeSuperior(UnidadeTO unidadeSuperior) {
		this.unidadeSuperior = unidadeSuperior;
	}
	public String getNmUnidade() {
		return nmUnidade;
	}
	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}
	public String getSgUnidade() {
		return sgUnidade;
	}
	public void setSgUnidade(String sgUnidade) {
		this.sgUnidade = sgUnidade;
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
	public String getDsUnidade() {
		return dsUnidade;
	}
	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}
	public Long getIdUnidadeSuperior() {
		return idUnidadeSuperior;
	}
	public void setIdUnidadeSuperior(Long idUnidadeSuperior) {
		this.idUnidadeSuperior = idUnidadeSuperior;
	}
    
    
    
}
