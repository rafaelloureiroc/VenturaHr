package br.edu.infnet.VenturaHr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.model.VagaCandidato;
import br.edu.infnet.VenturaHr.repository.VagaCandidatoRepository;


@Service

public class VagaCandidatoService {
	@Autowired
	private VagaCandidatoRepository vagaCandidatoRepository;
	
	public Collection<VagaCandidato> obterLista(Usuario usuario){		
		return (Collection<VagaCandidato>) vagaCandidatoRepository.findAll(usuario.getId());	

	}

	public Collection<VagaCandidato> obterLista(){		
		return (Collection<VagaCandidato>) vagaCandidatoRepository.findAll();
	}
	
	public VagaCandidato incluir(VagaCandidato vagaCandidato){
		return vagaCandidatoRepository.save(vagaCandidato);
	}
	
	public void excluir(Integer id) {
		vagaCandidatoRepository.deleteById(id);
	}
	
	public VagaCandidato obterPorId(Integer id) {
		return vagaCandidatoRepository.findById(id).orElse(null);
	}	
}

