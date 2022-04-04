package br.edu.infnet.VenturaHr.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "TVagaCandidato")
public class VagaCandidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idcandidato")
	private Candidato candidato;

	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Vaga> vagas;
	

	@ManyToOne
	@JoinColumn(name = "idempresa")
	private Usuario usuario;
	
	public VagaCandidato() {
		
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Candidato getCandidato() {
		return candidato;
	}


	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}


	public List<Vaga> getVagas() {
		return vagas;
	}


	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public VagaCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
}
