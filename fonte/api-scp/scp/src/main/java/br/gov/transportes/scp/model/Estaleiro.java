package br.gov.transportes.scp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(schema="BD_SCP",  name = "TB_ESTALEIRO")
@SequenceGenerator(schema="BD_SCP" ,name = "TB_ESTALEIRO_ID_GENERATOR", sequenceName = "SQ_ESTALEIRO", allocationSize = 1)
public class Estaleiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5443882554477099161L;

	@Id
	@Column(name="ID_ESTALEIRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ESTALEIRO_ID_GENERATOR")
	private Long id;
	
	@Column(name="SG_ESTALEIRO")
	private String sgEstaleiro;
	
	@Column(name="NR_AREA_TOTAL")
	private Long nrAreaTotal;
	
	@Column(name="NR_AREA_CONSTRUIDA")
	private Long nrAreaConstruida;
	
	@Column(name="NR_PORTE_MAXIMO_CONSTRUCAO")
	private Integer nrPorteMaximoConstrucao;
	
	@Column(name="NR_PORTE_MAXIMO_CONSTRUIDA")
	private Integer nrPorteMaximoConstruida;
	
	@Column(name="NR_CAPACIDADE_PRODUCAO")
	private Integer nrCapacidadeProducao;
	
	@Column(name="AN_INICIO_OPERACAO")
	private Integer anInicioOperacao;
	
	@Column(name="DS_PROCESSO_PRODUTIVO")
	private String dsProcessoProdutivo;
	
	@Column(name="ST_ATIVO")
	private String stAtivo;
	
	@Column(name="NM_ESTALEIRO")
	private String nmEstaleiro;
	
	@Column(name="ID_UF")
	private Integer idUf;
	
	@Column(name="TP_ATIVIDADE_PROJETO")
	private String tpAtividadeProjeto;
	
	@Column(name="QT_EMPREGADO")
	private Integer qtEmpregado;
	
	@Column(name="QT_EMPREGADO_DIRETO_PRODUCAO")
	private Integer qtEmpregadoDiretoProducao;
	
	@Column(name="QT_SUPERVISAO_PRODUCAO_CQ")
	private Integer qtSupervisaoProducaoCq;
	
	
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cais> listaCais;
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CapacidadeProcessamento> listaCapacidadeProcessamento;
	
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Emprego> listaEmprego;
	
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DiqueFlutuante> listaDiqueFlutuante;
	
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DiqueSeco> listaDiqueSeco;
	
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Carreira> listaCarreira;
	
	@OneToMany(mappedBy = "idEstaleiro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Equipamento> listaEquipamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSgEstaleiro() {
		return sgEstaleiro;
	}

	public void setSgEstaleiro(String sgEstaleiro) {
		this.sgEstaleiro = sgEstaleiro;
	}

	public Long getNrAreaTotal() {
		return nrAreaTotal;
	}

	public void setNrAreaTotal(Long nrAreaTotal) {
		this.nrAreaTotal = nrAreaTotal;
	}

	public Long getNrAreaConstruida() {
		return nrAreaConstruida;
	}

	public void setNrAreaConstruida(Long nrAreaConstruida) {
		this.nrAreaConstruida = nrAreaConstruida;
	}

	public Integer getNrPorteMaximoConstrucao() {
		return nrPorteMaximoConstrucao;
	}

	public void setNrPorteMaximoConstrucao(Integer nrPorteMaximoConstrucao) {
		this.nrPorteMaximoConstrucao = nrPorteMaximoConstrucao;
	}

	public Integer getNrPorteMaximoConstruida() {
		return nrPorteMaximoConstruida;
	}

	public void setNrPorteMaximoConstruida(Integer nrPorteMaximoConstruida) {
		this.nrPorteMaximoConstruida = nrPorteMaximoConstruida;
	}

	public Integer getNrCapacidadeProducao() {
		return nrCapacidadeProducao;
	}

	public void setNrCapacidadeProducao(Integer nrCapacidadeProducao) {
		this.nrCapacidadeProducao = nrCapacidadeProducao;
	}

	public Integer getAnInicioOperacao() {
		return anInicioOperacao;
	}

	public void setAnInicioOperacao(Integer anInicioOperacao) {
		this.anInicioOperacao = anInicioOperacao;
	}

	public String getDsProcessoProdutivo() {
		return dsProcessoProdutivo;
	}

	public void setDsProcessoProdutivo(String dsProcessoProdutivo) {
		this.dsProcessoProdutivo = dsProcessoProdutivo;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getNmEstaleiro() {
		return nmEstaleiro;
	}

	public void setNmEstaleiro(String nmEstaleiro) {
		this.nmEstaleiro = nmEstaleiro;
	}

	public Integer getIdUf() {
		return idUf;
	}

	public void setIdUf(Integer idUf) {
		this.idUf = idUf;
	}

	public String getTpAtividadeProjeto() {
		return tpAtividadeProjeto;
	}

	public void setTpAtividadeProjeto(String tpAtividadeProjeto) {
		this.tpAtividadeProjeto = tpAtividadeProjeto;
	}

	public Integer getQtEmpregado() {
		return qtEmpregado;
	}

	public void setQtEmpregado(Integer qtEmpregado) {
		this.qtEmpregado = qtEmpregado;
	}

	public Integer getQtEmpregadoDiretoProducao() {
		return qtEmpregadoDiretoProducao;
	}

	public void setQtEmpregadoDiretoProducao(Integer qtEmpregadoDiretoProducao) {
		this.qtEmpregadoDiretoProducao = qtEmpregadoDiretoProducao;
	}

	public Integer getQtSupervisaoProducaoCq() {
		return qtSupervisaoProducaoCq;
	}

	public void setQtSupervisaoProducaoCq(Integer qtSupervisaoProducaoCq) {
		this.qtSupervisaoProducaoCq = qtSupervisaoProducaoCq;
	}

	public List<CapacidadeProcessamento> getListaCapacidadeProcessamento() {
		return listaCapacidadeProcessamento;
	}

	public void setListaCapacidadeProcessamento(List<CapacidadeProcessamento> listaCapacidadeProcessamento) {
		this.listaCapacidadeProcessamento = listaCapacidadeProcessamento;
	}

	public List<Emprego> getListaEmprego() {
		return listaEmprego;
	}

	public void setListaEmprego(List<Emprego> listaEmprego) {
		this.listaEmprego = listaEmprego;
	}

	public List<DiqueFlutuante> getListaDiqueFlutuante() {
		return listaDiqueFlutuante;
	}

	public void setListaDiqueFlutuante(List<DiqueFlutuante> listaDiqueFlutuante) {
		this.listaDiqueFlutuante = listaDiqueFlutuante;
	}

	public List<DiqueSeco> getListaDiqueSeco() {
		return listaDiqueSeco;
	}

	public void setListaDiqueSeco(List<DiqueSeco> listaDiqueSeco) {
		this.listaDiqueSeco = listaDiqueSeco;
	}

	public List<Carreira> getListaCarreira() {
		return listaCarreira;
	}

	public void setListaCarreira(List<Carreira> listaCarreira) {
		this.listaCarreira = listaCarreira;
	}

	public List<Equipamento> getListaEquipamento() {
		return listaEquipamento;
	}

	public void setListaEquipamento(List<Equipamento> listaEquipamento) {
		this.listaEquipamento = listaEquipamento;
	}

	public List<Cais> getListaCais() {
		return listaCais;
	}

	public void setListaCais(List<Cais> listaCais) {
		this.listaCais = listaCais;
	}
	
	
	
		
	
}


