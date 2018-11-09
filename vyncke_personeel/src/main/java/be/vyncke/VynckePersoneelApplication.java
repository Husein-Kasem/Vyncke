package be.vyncke;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.vyncke.dao.FunctieRepository;
import be.vyncke.dao.PersoneelRepository;
import be.vyncke.domain.Functie;
import be.vyncke.domain.Personeel;

@SpringBootApplication
public class VynckePersoneelApplication {

	public static void main(String[] args) {
		SpringApplication.run(VynckePersoneelApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(PersoneelRepository repoPersoneel, FunctieRepository repoFunctie) {
		return (evt) -> {
			repoFunctie.save(new Functie("Verkoper", "Houdt contact met de klanten en kan offertes opstellen voor bestellingen"));
			repoFunctie.save(new Functie("Ketelmaker", "Bouwt de ketels voor de bestellingen en kan alle huidige projecten opvolgen"));
			repoPersoneel.save(new Personeel("Gert", "Van der Brempt", "gert.vanderbrempt@student.odisee.be", "passwoord", 1));
			repoPersoneel.save(new Personeel("Tanguy", "Ortegat", "tanguy.ortegat@student.odisee.be", "passwoord", 1));
			repoPersoneel.save(new Personeel("Noë", "Noël", "noe.noel@student.odisee.be", "passwoord", 2));
		};
	}
}
