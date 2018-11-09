package be.vyncke;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.vyncke.dao.*;
import be.vyncke.domain.*;

@SpringBootApplication
public class VynckeKlantenApplication {

	public static void main(String[] args) {
		SpringApplication.run(VynckeKlantenApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(KlantRepository repo) {
		return (evt) -> {
			repo.save(new Klant("Bert", "Bakkers", "bert.bakkers@hotmail.com", "passwoord", 20));
			repo.save(new Klant("José", "Gonzales", "el_tigre@hotmail.com", "eltigre", 21));
			repo.save(new Klant("Jimmy", "Page", "zeppelin@hotmail.com", "ledzep", 22));
			repo.save(new Klant("Isaac", "Newton", "newty@hotmail.com", "inertiarulezz", 23));
		};
	}
}
