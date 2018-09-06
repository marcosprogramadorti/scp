package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;
public class PessoaEnderecoTO {
	
    private Long id;
    private LocalidadeTO localidade;
    private TipoLogradouroTO tipoLogradouro;
    private PessoaTO pessoa;
    private TipoEnderecoTO tipoEndereco;
    private String nrCep;
    private String nmBairro;
    private String dsLogradouro;
    private String nrLogradouro;
    private String dsComplemento;
    private String stPrincipal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalidadeTO getLocalidade() {
		return localidade;
	}
	public void setLocalidade(LocalidadeTO localidade) {
		this.localidade = localidade;
	}
	public TipoLogradouroTO getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouroTO tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public PessoaTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
	}
	public TipoEnderecoTO getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEnderecoTO tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	public String getNrCep() {
		return nrCep;
	}
	public void setNrCep(String nrCep) {
		this.nrCep = nrCep;
	}
	public String getNmBairro() {
		return nmBairro;
	}
	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}
	public String getDsLogradouro() {
		return dsLogradouro;
	}
	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}
	public String getNrLogradouro() {
		return nrLogradouro;
	}
	public void setNrLogradouro(String nrLogradouro) {
		this.nrLogradouro = nrLogradouro;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	public String getStPrincipal() {
		return stPrincipal;
	}
	public void setStPrincipal(String stPrincipal) {
		this.stPrincipal = stPrincipal;
	}
    
    
    
    
}
