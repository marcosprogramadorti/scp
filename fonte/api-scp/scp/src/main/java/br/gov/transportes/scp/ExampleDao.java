package br.gov.transportes.scp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_CENARIO", schema = "BD_SPL_V2B")
public class ExampleDao {
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CENARIO")
	private Long codigo;
	
	@NotNull
	@Size(min=3, max = 20)
	@Column(name = "NM_CENARIO")
	private String nome;
	
}
