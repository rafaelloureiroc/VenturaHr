package br.edu.infnet.VenturaHr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TVaga")
public class Vaga implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;

	@Basic(optional = false)
	@Column(nullable = false, length = 45)
	private String cargo;

	@Basic(optional = false)
	@Column(nullable = false, length = 45)
	private String cidade;

	@Basic(optional = false)
	@Column(name = "forma_contratacao", nullable = false, length = 45)
	private String formaContratacao;

	
	private String descricao;
	
	private String perfil;

	
	private String peso;

	@ManyToOne
	@JoinColumn(name = "idempresa")
	private Usuario usuario;

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "id_criterio", nullable = false)
	@JoinColumn(name = "id_criterio", referencedColumnName = "id", nullable = false)
	@OneToMany()
	private List<Criterio> criterioList;

	public Vaga() {
	}

	public Integer getId() {
		return id;
	}

	public String getCargo() {
		return cargo;
	}

	public String getCidade() {
		return cidade;
	}

	public String getFormaContratacao() {
		return formaContratacao;
	}

	public List<Criterio> getCriterioList() {
		return criterioList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setFormaContratacao(String formaContratacao) {
		this.formaContratacao = formaContratacao;
	}

	public void setCriterioList(List<Criterio> criterioList) {
		this.criterioList = criterioList;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	

	

	

}