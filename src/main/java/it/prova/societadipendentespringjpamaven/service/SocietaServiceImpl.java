package it.prova.societadipendentespringjpamaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.societadipendentespringjpamaven.model.Dipendente;
import it.prova.societadipendentespringjpamaven.model.Societa;
import it.prova.societadipendentespringjpamaven.repository.DipendenteRepository;
import it.prova.societadipendentespringjpamaven.repository.SocietaRepository;

@Service
public class SocietaServiceImpl implements SocietaService {
	@Autowired
	private SocietaRepository societaRepository;
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Transactional(readOnly = true)
	public List<Societa> listAll() {
		return (List<Societa>)societaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Societa caricaSingolaSocieta(Long id) {
		return societaRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Societa societaInstance) {
		societaRepository.save(societaInstance);
	}

	@Transactional
	public void inserisciNuovo(Societa societaInstance) {
		societaRepository.save(societaInstance);
	}

	@Transactional
	public void rimuovi(Societa dipendenteInstance) {
		societaRepository.delete(dipendenteInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Societa> findAllByExample(Societa example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); 
		
		return (List<Societa>) societaRepository.findAll(Example.of(example, matcher));
	}

	@Override
	public void aggiungiDipendente(Dipendente dipendenteInstance, Societa societaInstance) {
		societaRepository.save(societaInstance);
		dipendenteRepository.save(dipendenteInstance);
		
		societaInstance.getDipendenti().add(dipendenteInstance);
	}

	@Override
	public List<Societa> trovaTutteDistintePerDipendentiConRedditoAnnuoMaggioreDi(Integer reddito) {
		return societaRepository.findAllDistinctByDipendenti_RedditoAnnuoLordoGreaterThan(reddito);
	}
//
//	@Override
//	public List<Societa> trovaTuttePerRagioneSocialeIniziaCon(String token) {
//		return societaRepository.findAllByRagioneSocialeStartsWith(token);
//	}

}
