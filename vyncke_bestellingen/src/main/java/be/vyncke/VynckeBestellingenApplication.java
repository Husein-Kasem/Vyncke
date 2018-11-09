package be.vyncke;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.vyncke.dao.BestellingRepository;
import be.vyncke.dao.KetelRepository;
import be.vyncke.dao.OfferteRepository;
import be.vyncke.domain.*;

@SpringBootApplication
public class VynckeBestellingenApplication {

	public static void main(String[] args) {
		SpringApplication.run(VynckeBestellingenApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(BestellingRepository repoBestelling, KetelRepository repoKetel, OfferteRepository repoOfferte) {
		return (evt) -> {
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			cal.add(Calendar.DATE, 7);
			Date nextWeek = cal.getTime();
			cal.add(Calendar.DATE, 7);
			Date nextNextWeek = cal.getTime();
			cal.add(Calendar.DATE, 12);
			Date date1 = cal.getTime();
			cal.add(Calendar.MONTH, 1);
			Date date2 = cal.getTime();
			repoKetel.save(new Ketel("OMG-X73", 750));
			repoKetel.save(new Ketel("SUPERNOVA", 1500));
			repoKetel.save(new Ketel("NO_JUICE", 100));
			repoBestelling.save(new Bestelling(date2, 2, 2, "Nieuw"));
			repoBestelling.save(new Bestelling(date1, 3, 3, "Nieuw"));
			repoOfferte.save(new Offerte(1200.00, date2, 4));
			repoOfferte.save(new Offerte(1400.00, date2, 4));
			repoOfferte.save(new Offerte(1000.00, date2, 4));
		};
	}
}
