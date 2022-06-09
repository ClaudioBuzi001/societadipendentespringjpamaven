package it.prova.societadipendentespringjpamaven.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.societadipendentespringjpamaven.model.Dipendente;
import it.prova.societadipendentespringjpamaven.model.Societa;


@Service
public class BatteriaDiTestService {
	
	@Autowired
	private DipendenteService dipendenteService;
	@Autowired
	private SocietaService societaService;
	
	public void testInserisciSocieta() {
		System.out.println("-------------test societa-------------");
		
		Societa societa = new Societa("Solving Teams", "Via miosca", new Date());
		
		societaService.inserisciNuovo(societa);
		
		if(societa.getId() == 0) {
			throw new RuntimeException("Errore");
		}
		
		System.out.println("Test Inserisci Societa PASSED -----------------");
		
		
	}
	
	public void testInserisciDipendente() {
		System.out.println("-------------test inserisci Dipendente-------------");

		Societa societa = new Societa("Solving Teams", "Via miosca", new Date());
		
		societaService.inserisciNuovo(societa);
		
		Dipendente dipendente = new Dipendente("Giorgio","Marione",new Date(),2000,societa);
		
		dipendenteService.inserisciNuovo(dipendente);
		
		if(dipendente.getId() < 1)
			throw new RuntimeException("ERRORE Inserimento NON PASSATO");
		
		System.out.println("-------------------Passed--------------");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
