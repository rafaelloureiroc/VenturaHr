package br.edu.infnet.VenturaHr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}

	public Usuario obterPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}
	

	public Usuario autenticacao(String email, String senha) {
		return usuarioRepository.autenticacao(email, senha);
	}
}
