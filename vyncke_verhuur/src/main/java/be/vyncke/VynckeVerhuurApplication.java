package be.vyncke;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.vyncke.dao.*;
import be.vyncke.domain.*;

@SpringBootApplication
public class VynckeVerhuurApplication {

	public static void main(String[] args) {
		SpringApplication.run(VynckeVerhuurApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(AanvraagRepository repoAanvraag, HuurcontractRepository repoContract) {
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
			repoAanvraag.save(new Aanvraag(2, nextWeek, nextNextWeek));
			repoAanvraag.save(new Aanvraag(4, date1, date2));
			repoContract.save(new Huurcontract(2, today, nextNextWeek));
		};
	}
}
