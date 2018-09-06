package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipoDocumentoTO {
    
	private Long id;
    private String nmTipoDocumento;
    private String dsTipoDocumento;
    private String stAtivo;
    private Date dhCadastro;
    private String tpPessoa;
    private List<PessoaDocumentoTO> pessoaDocumentos = new ArrayList<>(0);
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNmTipoDocumento() {
		return nmTipoDocumento;
	}
	public void setNmTipoDocumento(String nmTipoDocumento) {
		this.nmTipoDocumento = nmTipoDocumento;
	}
	public String getDsTipoDocumento() {
		return dsTipoDocumento;
	}
	public void setDsTipoDocumento(String dsTipoDocumento) {
		this.dsTipoDocumento = dsTipoDocumento;
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
	public String getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	public List<PessoaDocumentoTO> getPessoaDocumentos() {
		return pessoaDocumentos;
	}
	public void setPessoaDocumentos(List<PessoaDocumentoTO> pessoaDocumentos) {
		this.pessoaDocumentos = pessoaDocumentos;
	}
    
    
   
    
}
