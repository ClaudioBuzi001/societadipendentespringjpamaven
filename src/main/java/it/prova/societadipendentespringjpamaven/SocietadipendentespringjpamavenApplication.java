package it.prova.societadipendentespringjpamaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.societadipendentespringjpamaven.service.BatteriaDiTestService;


@SpringBootApplication
public class SocietadipendentespringjpamavenApplication implements CommandLineRunner{

	@Autowired
	private BatteriaDiTestService batteriaDiTestService;	
	
	public static void main(String[] args) {
		SpringApplication.run(SocietadipendentespringjpamavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("################ START   #################");
		System.out.println("################ eseguo i test  #################");
		
		batteriaDiTestService.testInserisciSocieta();
		
		batteriaDiTestService.testInserisciDipendente();
		
		//batteriaDiTestService.testFindByExampleSocieta();
		
		batteriaDiTestService.testRimozioneSocieta();
		
		batteriaDiTestService.testInserimentoDipendenteDataSocieta();
		
		System.out.println("################ FINE   #################");
	}
	
	
	

}
