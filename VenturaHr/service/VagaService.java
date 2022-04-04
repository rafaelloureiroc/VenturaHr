package br.edu.infnet.VenturaHr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.model.Vaga;
import br.edu.infnet.VenturaHr.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;

	public Collection<Vaga> obterLista(Usuario usuario) {
		return (Collection<Vaga>) vagaRepository.findAll(usuario.getId());
	}

	public Collection<Vaga> obterLista() {
		return (Collection<Vaga>) vagaRepository.findAll();
	}

	public void excluir(Integer id) {
		vagaRepository.deleteById(id);
	}

	public void incluir(Vaga vaga) {
		vagaRepository.save(vaga);
	}

	public Vaga incluiRetorna(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	public Vaga obterPorId(Integer id) {
		return vagaRepository.findById(id).orElse(null);
	}

}
