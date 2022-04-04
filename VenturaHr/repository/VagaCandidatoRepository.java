package br.edu.infnet.VenturaHr.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaHr.model.VagaCandidato;


@Repository
public interface VagaCandidatoRepository extends CrudRepository<VagaCandidato, Integer> {
	@Query("from VagaCandidato h where h.usuario.id = :idusuario")
	Collection<VagaCandidato> findAll(Integer idusuario);
	
	Collection<VagaCandidato> findAll(Sort by);
	
	
}


