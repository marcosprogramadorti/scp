package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class ArquivoTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date dhCadastro;
    private String nmArquivoFisico;
    private String nmArquivoLogico;
    private String nmResumoArquivo;
    private DiretorioTO diretorio;
    private String stArquivo;
    
    @JsonIgnore
    private Map<String, File> files = new HashMap<>();
    
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
	public String getNmArquivoFisico() {
		return nmArquivoFisico;
	}
	public void setNmArquivoFisico(String nmArquivoFisico) {
		this.nmArquivoFisico = nmArquivoFisico;
	}
	public String getNmArquivoLogico() {
		return nmArquivoLogico;
	}
	public void setNmArquivoLogico(String nmArquivoLogico) {
		this.nmArquivoLogico = nmArquivoLogico;
	}
	public String getNmResumoArquivo() {
		return nmResumoArquivo;
	}
	public void setNmResumoArquivo(String nmResumoArquivo) {
		this.nmResumoArquivo = nmResumoArquivo;
	}
	public DiretorioTO getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(DiretorioTO diretorio) {
		this.diretorio = diretorio;
	}
	public String getStArquivo() {
		return stArquivo;
	}
	public void setStArquivo(String stArquivo) {
		this.stArquivo = stArquivo;
	}
	public Map<String, File> getFiles() {
		return files;
	}
	public void setFiles(Map<String, File> files) {
		this.files = files;
	}
    
}