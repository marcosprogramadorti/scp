package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.Date;
import java.util.List;

public class PessoaTO {
	
	private Long id;
	private Date dhCadastro;
	private String dsInfoAdicional;
	private String nmPessoa;
	private String stAtivo;
	private String tpPessoa;
	private List<TipoVinculoTO> listaTipoVinculos;
	private TipoVinculoTO tipoVinculo;
	private UnidadeTO unidade;
	private List<PessoaDocumentoTO> pessoaDocumentos;
	private List<PessoaEmailTO> pessoaEmails;
	private List<PessoaEnderecoTO> pessoaEnderecos;
	private PessoaFisicaTO pessoaFisica;
	private PessoaJuridicaTO pessoaJuridica;
	private List<PessoaTelefoneTO> pessoaTelefones;
	private Long idPessoaFisica;
	private Long idPessoaJuridica;
	private String cdRecursoProprietario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDhCadastro() {
		return dhCadastro;
	}
	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}
	public String getDsInfoAdicional() {
		return dsInfoAdicional;
	}
	public void setDsInfoAdicional(String dsInfoAdicional) {
		this.dsInfoAdicional = dsInfoAdicional;
	}
	public String getNmPessoa() {
		return nmPessoa;
	}
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	public String getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}
	public String getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	public List<TipoVinculoTO> getListaTipoVinculos() {
		return listaTipoVinculos;
	}
	public void setListaTipoVinculos(List<TipoVinculoTO> listaTipoVinculos) {
		this.listaTipoVinculos = listaTipoVinculos;
	}
	public TipoVinculoTO getTipoVinculo() {
		return tipoVinculo;
	}
	public void setTipoVinculo(TipoVinculoTO tipoVinculo) {
		this.tipoVinculo = tipoVinculo;
	}
	public UnidadeTO getUnidade() {
		return unidade;
	}
	public void setUnidade(UnidadeTO unidade) {
		this.unidade = unidade;
	}
	public List<PessoaDocumentoTO> getPessoaDocumentos() {
		return pessoaDocumentos;
	}
	public void setPessoaDocumentos(List<PessoaDocumentoTO> pessoaDocumentos) {
		this.pessoaDocumentos = pessoaDocumentos;
	}
	public List<PessoaEmailTO> getPessoaEmails() {
		return pessoaEmails;
	}
	public void setPessoaEmails(List<PessoaEmailTO> pessoaEmails) {
		this.pessoaEmails = pessoaEmails;
	}
	public List<PessoaEnderecoTO> getPessoaEnderecos() {
		return pessoaEnderecos;
	}
	public void setPessoaEnderecos(List<PessoaEnderecoTO> pessoaEnderecos) {
		this.pessoaEnderecos = pessoaEnderecos;
	}
	public PessoaFisicaTO getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisicaTO pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	public PessoaJuridicaTO getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridicaTO pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public List<PessoaTelefoneTO> getPessoaTelefones() {
		return pessoaTelefones;
	}
	public void setPessoaTelefones(List<PessoaTelefoneTO> pessoaTelefones) {
		this.pessoaTelefones = pessoaTelefones;
	}
	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	public Long getIdPessoaJuridica() {
		return idPessoaJuridica;
	}
	public void setIdPessoaJuridica(Long idPessoaJuridica) {
		this.idPessoaJuridica = idPessoaJuridica;
	}
	public String getCdRecursoProprietario() {
		return cdRecursoProprietario;
	}
	public void setCdRecursoProprietario(String cdRecursoProprietario) {
		this.cdRecursoProprietario = cdRecursoProprietario;
	}
	
	
	
	

}
