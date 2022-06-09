package it.prova.societadipendentespringjpamaven.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.transaction.annotation.Transactional;

import it.prova.societadipendentespringjpamaven.model.Dipendente;
import it.prova.societadipendentespringjpamaven.repository.DipendenteRepository;

public class DipendenteServiceImpl implements DipendenteService {

	private DipendenteRepository dipendenteRepository;

	@Transactional(readOnly = true)
	public List<Dipendente> listAll() {
		return (List<Dipendente>) dipendenteRepository.findAll();

	}

	@Transactional(readOnly = true)
	public Dipendente caricaSingoloDipendente(Long id) {
		return dipendenteRepository.findById(id).orElse(null);

	}

	@Transactional(readOnly = true)
	public void aggiorna(Dipendente dipendenteInstance) {
		dipendenteRepository.save(dipendenteInstance);
	}

	@Transactional(readOnly = true)
	public void inserisciNuovo(Dipendente dipendenteInstance) {
		dipendenteRepository.save(dipendenteInstance);
	}

	@Transactional(readOnly = true)
	public void rimuovi(Dipendente dipendenteInstance) {
		dipendenteRepository.delete(dipendenteInstance);
	}

	@Override
	public List<Dipendente> trovaTuttiPerNome(String nome) {
		return dipendenteRepository.findAllByNome(nome);
	}

	@Override
	public List<Dipendente> trovaTuttiPerNomeECognome(String nome, String cognome) {
		return dipendenteRepository.findAllByNomeECognome(nome, cognome);
	}

	@Override
	public List<Dipendente> trovaTuttiPerRedditoAnnuoMaggioreDi(Integer input) {
		return dipendenteRepository.findAllByRedditoAnnuoLordoGreaterThan(input);
	}

	@Override
	public List<Dipendente> trovaTuttiPerNomeEager(String nome) {
		return dipendenteRepository.findAllByNomeEager(nome);
	}

	@Transactional(readOnly = true)
	public List<Dipendente> findByExample(Dipendente example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); // Match string
																										// containing
																										// pattern
		// .withIgnoreCase();
		return (List<Dipendente>) dipendenteRepository.findAll(Example.of(example, matcher));

	}

}