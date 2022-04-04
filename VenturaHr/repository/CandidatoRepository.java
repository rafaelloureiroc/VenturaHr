package br.edu.infnet.VenturaHr.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaHr.model.Candidato;


@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {

	@Query("from Candidato c where c.usuario.id = :idusuario")
	public List<Candidato> obterLista(Integer idusuario, Sort sort);
}