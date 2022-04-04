package br.edu.infnet.VenturaHr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaHr.model.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	

	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	public Usuario autenticacao(String email, String senha);
	
	
}