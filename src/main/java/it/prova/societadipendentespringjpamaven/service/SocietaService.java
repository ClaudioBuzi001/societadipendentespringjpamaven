package it.prova.societadipendentespringjpamaven.service;

import java.util.List;

import it.prova.societadipendentespringjpamaven.model.Dipendente;
import it.prova.societadipendentespringjpamaven.model.Societa;


public interface SocietaService {

	
	public List<Societa> listAll();

	public Societa caricaSingolaSocieta(Long id);

	public void aggiorna(Societa societaInstance);

	public void inserisciNuovo(Societa societaInstance);

	public void rimuovi(Societa dipendenteInstance);
	
	public List<Societa> findAllByExample(Societa example);
	
	public void aggiungiDipendente(Dipendente dipendenteInstance, Societa societaInstance);
//
	public List<Societa> trovaTutteDistintePerDipendentiConRedditoAnnuoMaggioreDi(Integer reddito);
//	
//	public List<Societa> trovaTuttePerRagioneSocialeIniziaCon(String token);
	
	
	
	
}


















