package it.prova.societadipendentespringjpamaven.service;

import java.util.List;

import it.prova.societadipendentespringjpamaven.model.Dipendente;

public interface DipendenteService {
	public List<Dipendente> listAllAbitanti();

	public Dipendente caricaSingoloDipendente(Long id);

	public void aggiorna(Dipendente dipendenteInstance);

	public void inserisciNuovo(Dipendente dipendenteInstance);

	public void rimuovi(Dipendente dipendenteInstance);

	public List<Dipendente> trovaTuttiPerNome(String nome);

	public List<Dipendente> trovaTuttiPerNomeECognome(String nome, String cognome);

	public List<Dipendente> trovaTuttiPerRedditoAnnuoMaggioreDi(Integer input);

	public List<Dipendente> trovaTuttiPerNomeEager(String nome);
	
	public List<Dipendente> findByExample(Dipendente example);

}

