package it.prova.societadipendentespringjpamaven.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.societadipendentespringjpamaven.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long>, QueryByExampleExecutor<Dipendente> {

//	List<Dipendente> findAllByNome(String nome);
//
//	List<Dipendente> findAllByNomeAndCognome(String nome, String cognome);
//
//	List<Dipendente> findAllByRedditoAnnuoLordoGreaterThan(Integer input);
//
//	@EntityGraph(attributePaths = { "societa" })
//	List<Dipendente> findAllByCognome(String cognome);
	
	Dipendente  findFirstBySocieta_DataFondazioneBeforeOrderByDataAssunzione(Date date);

}
