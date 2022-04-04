package br.edu.infnet.VenturaHr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.VenturaHr.model.Candidato;
import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.repository.CandidatoRepository;




@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;

	public Collection<Candidato> obterLista(Usuario usuario){		
		return (Collection<Candidato>) candidatoRepository.obterLista(usuario.getId(),  Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Collection<Candidato> obterLista(){		
		return (Collection<Candidato>) candidatoRepository.findAll();
	}
	
	public Candidato incluir(Candidato Candidato){
		return candidatoRepository.save(Candidato);
	}
	
	public void excluir(Integer id) {
		candidatoRepository.deleteById(id);
	}
	
	public Candidato obterPorId(Integer id) {
		return candidatoRepository.findById(id).orElse(null);
	}
}