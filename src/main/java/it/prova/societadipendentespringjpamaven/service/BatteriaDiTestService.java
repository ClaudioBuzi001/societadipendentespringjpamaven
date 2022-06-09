package it.prova.societadipendentespringjpamaven.service;

import java.util.Date;
import java.util.List;

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

		if (societa.getId() == 0) {
			throw new RuntimeException("Errore");
		}

		System.out.println("Test Inserisci Societa PASSED -----------------");

	}

	public void testInserisciDipendente() {
		System.out.println("-------------test inserisci Dipendente-------------");

		Societa societa = new Societa("Solving Teams", "Via miosca", new Date());

		societaService.inserisciNuovo(societa);

		Dipendente dipendente = new Dipendente("Giorgio", "Marione", new Date(), 2000, societa);

		dipendenteService.inserisciNuovo(dipendente);

		if (dipendente.getId() < 1)
			throw new RuntimeException("ERRORE Inserimento NON PASSATO");

		System.out.println("-------------------Passed--------------");

	}

	// Find ByExample societa
	public void testFindByExampleSocieta() {
		System.out.println("_-----------test FindByExample-----------");

		Societa example = new Societa("Solvi", null, null);

		societaService.findAllByExample(example).forEach(s -> System.out.println(s.toString()));

		System.out.println(".......TestFindByExample terminato.......");

	}
	
	public void testRimozioneSocieta() {
		System.out.println("_-------testRimozioneSocieta ----------");
		
		Societa societa = new Societa("Piero e paolo", "via dei sette nani", null);
		
		if(societa.getDipendenti().size()> 0)
			throw new RuntimeException("Errore, Dipendenti presenti nella societa");
		
		societaService.rimuovi(societa);
		
		System.out.println("_testRimozioneSocieta PASSED---------_");
		
	}

	public void testInserimentoDipendenteDataSocieta() {
		System.out.println("_-------testInserimentoDipendenteDataSocieta ----------");

		Societa societa = new Societa("Piero e Gianmaaa", "via dei sette nani", null);

		Dipendente dipendente = new Dipendente("Giorgio", "Marione", new Date(), 2000, societa);
		
		//Inserisco tutto insiemee
		societaService.aggiungiDipendente(dipendente, societa);
		
		if(societa.getDipendenti().size() < 1) 
			throw new RuntimeException("TESTINSERIMENTODIPENDETE FAILED");
		
		System.out.println("--------------testInserimentoDipendenteDataSocieta PASSED--------------");
	}
	
	public void testModificaDipendente() {
		System.out.println("_------testModificaDipendente----------------");
		
		Societa societa = new Societa("Piero e Gianmaaa", "via dei sette nani", null);
		societaService.inserisciNuovo(societa);
		
		Dipendente dipendente = new Dipendente("Giorgio", "Marione", new Date(), 2000, societa);
		dipendenteService.inserisciNuovo(dipendente);
		
		dipendente.setNome("Signor Giurgio");
		dipendenteService.aggiorna(dipendente);
		
		if(dipendente.getNome().equals("Giorgio")) {
			throw new RuntimeException("_---testModificaDipendente FAILED");
		}
		
		System.out.println("_----testModificaDipendente Passed");
		
	}
	
}


















