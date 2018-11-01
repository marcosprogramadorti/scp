package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(schema="BD_SCP",  name = "TB_POSTULANTE")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_POSTULANTE_ID_GENERATOR", sequenceName = "SQ_POSTULANTE", allocationSize = 1)
public class Postulante implements Serializable {

	


	/**
	 * Author: Marcos Tavares
	 * Data: 15/10/2018
	 * 
	 * https://pt.stackoverflow.com/questions/187347/mapeamento-manytomany-com-coluna-adicional
	 */
	
	private static final long serialVersionUID = -3076354717325855908L;

	
	
	@Id
	@Column(name = "ID_POSTULANTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_POSTULANTE_ID_GENERATOR")
	private Long id;
	
	@Column(name = "ID_PESSOA_JURIDICA")
	private Long idPessoaJuridica;
	
	@Column(name = "ID_PESSOA_FISICA")
	private Long idPessoaFisica;
	
	@Column(name = "ST_ATIVO")
	private String stAtivo;
	
	
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="idPostulante", orphanRemoval = true)
	private List<RepresentantePostulante> representantes;
	
	@OneToOne ( cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="ID_POSTULANTE")
	private Armador armador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPessoaJuridica() {
		return idPessoaJuridica;
	}

	public void setIdPessoaJuridica(Long idPessoaJuridica) {
		this.idPessoaJuridica = idPessoaJuridica;
	}

	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public List<RepresentantePostulante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(List<RepresentantePostulante> representantes) {
		this.representantes = representantes;
	}

	public Armador getArmador() {
		return armador;
	}

	public void setArmador(Armador armador) {
		this.armador = armador;
	}
	

	


	
	
	
	
	
	


	

	
		
	
	
}
