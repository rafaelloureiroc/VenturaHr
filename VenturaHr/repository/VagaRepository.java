package br.edu.infnet.VenturaHr.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaHr.model.Vaga;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Integer> {

	@Query("from Vaga v where v.usuario.id = :idusuario")
	List<Vaga> findAll(Integer idusuario);

	List<Vaga> findAll();

	List<Vaga> findByCargoContainingIgnoreCase(String pesquisa);

	List<Vaga> findByCidadeContainingIgnoreCase(String pesquisa);
}