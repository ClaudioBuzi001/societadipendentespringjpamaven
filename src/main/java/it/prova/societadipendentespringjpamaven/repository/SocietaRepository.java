package it.prova.societadipendentespringjpamaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.societadipendentespringjpamaven.model.Societa;

public interface SocietaRepository  extends CrudRepository<Societa, Long>, QueryByExampleExecutor<Societa>{
	List<Societa> findAllDistinctByDipendenti_RedditoAnnuoLordoGreaterThan(Integer reddito);
	
	@Query("from Societa s where s.nome like ?1%")
	List<Societa> findAllByRagioneSocialeStartsWith(String token);

}
