package br.gov.transportes.scp.repository.pessoasuitecorporativa.negocio.to;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipoTelefoneTO {
	
    private Long id;
    private String nmTipoTelefone;
    private String dsTipoTelefone;
    private String stAtivo;
    private Date dhCadastro;
    private List<PessoaTelefoneTO> pessoaTelefones = new ArrayList<>(0);
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNmTipoTelefone() {
		return nmTipoTelefone;
	}
	public void setNmTipoTelefone(String nmTipoTelefone) {
		this.nmTipoTelefone = nmTipoTelefone;
	}
	public String getDsTipoTelefone() {
		return dsTipoTelefone;
	}
	public void setDsTipoTelefone(String dsTipoTelefone) {
		this.dsTipoTelefone = dsTipoTelefone;
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
	public List<PessoaTelefoneTO> getPessoaTelefones() {
		return pessoaTelefones;
	}
	public void setPessoaTelefones(List<PessoaTelefoneTO> pessoaTelefones) {
		this.pessoaTelefones = pessoaTelefones;
	}
    
    
    
    
}
