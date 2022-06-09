package it.prova.societadipendentespringjpamaven.service;

import java.util.Date;
import java.util.List;

import it.prova.societadipendentespringjpamaven.model.Dipendente;

public interface DipendenteService {
	public List<Dipendente> listAll();

	public Dipendente caricaSingoloDipendente(Long id);

	public void aggiorna(Dipendente dipendenteInstance);

	public void inserisciNuovo(Dipendente dipendenteInstance);

	public void rimuovi(Dipendente dipendenteInstance);

//	public List<Dipendente> trovaTuttiPerNome(String nome);
//
//	public List<Dipendente> trovaTuttiPerNomeECognome(String nome, String cognome);
//
//	public List<Dipendente> trovaTuttiPerRedditoAnnuoMaggioreDi(Integer input);
//
//	public List<Dipendente> trovaTuttiPerCognomeEager(String nome);
	
	public List<Dipendente> findByExample(Dipendente example);
	
	public Dipendente findByDataAssunzineMaggioreEDataFondazioneSocietaMaggioreDi(Date data);

}

