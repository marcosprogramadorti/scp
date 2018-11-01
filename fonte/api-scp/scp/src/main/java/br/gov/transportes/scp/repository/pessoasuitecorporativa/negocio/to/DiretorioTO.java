package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DiretorioTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date dhCadastro;
    private String dsDiretorio;
    private Long idAplicacao;
    private String nmDiretorio;
    private String nmEnderecoServidor;
    private String nmServidor;
    private String stAtivo;
    private List<ArquivoTO> arquivos;
    private TipoDiretorioTO tipoDiretorio;
    
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
	public String getDsDiretorio() {
		return dsDiretorio;
	}
	public void setDsDiretorio(String dsDiretorio) {
		this.dsDiretorio = dsDiretorio;
	}
	public Long getIdAplicacao() {
		return idAplicacao;
	}
	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}
	public String getNmDiretorio() {
		return nmDiretorio;
	}
	public void setNmDiretorio(String nmDiretorio) {
		this.nmDiretorio = nmDiretorio;
	}
	public String getNmEnderecoServidor() {
		return nmEnderecoServidor;
	}
	public void setNmEnderecoServidor(String nmEnderecoServidor) {
		this.nmEnderecoServidor = nmEnderecoServidor;
	}
	public String getNmServidor() {
		return nmServidor;
	}
	public void setNmServidor(String nmServidor) {
		this.nmServidor = nmServidor;
	}
	public String getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}
	public List<ArquivoTO> getArquivos() {
		return arquivos;
	}
	public void setArquivos(List<ArquivoTO> arquivos) {
		this.arquivos = arquivos;
	}
	public TipoDiretorioTO getTipoDiretorio() {
		return tipoDiretorio;
	}
	public void setTipoDiretorio(TipoDiretorioTO tipoDiretorio) {
		this.tipoDiretorio = tipoDiretorio;
	}
    
}