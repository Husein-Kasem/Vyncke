package be.vyncke.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.vyncke.VynckeWebfrontApplication;
import be.vyncke.domain.Bestelling;
import be.vyncke.service.BestellingService;
import be.vyncke.service.KlantService;
import be.vyncke.domain.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= VynckeWebfrontApplication.class)
@SpringBootTest
public class VynckeWebfrontApplicationTests {

	@Autowired
	private BestellingService bestellingService;
	private KlantService klantService;

	//	@Test
	//	public void klantOpzoeken() {
	//		Klant zoekKlant = new Klant("Bert", "Bakkers", "bert.bakkers@hotmail.com", "passwoord");
	//		//Klant zoekKlant = new Klant();
	//
	//		Collection<Klant> resultaat = klantService.zoekKlantenOpNaam(zoekKlant);
	//		if (resultaat != null)
	//		{
	//			assertEquals(1, resultaat.size());
	//			Klant gevondenKlant = resultaat.iterator().next();
	//			assertEquals("Bert", gevondenKlant.getVoornaam());
	//			assertEquals("Bakkers", gevondenKlant.getNaam());
	//			assertEquals("bert.bakkers@hotmail.com", gevondenKlant.getEmail());
	//		}
	//	}
	//


	@Test
	public void bestellingPlaatsen() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datum = new Date();
		try {
			datum = sdf.parse("2018-11-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Bestelling bestelling = new Bestelling(datum, 1, 2, "Nieuw");
		bestellingService.nieuweBestelling(bestelling);
		System.out.println(bestelling.getId());
		Bestelling besteld = bestellingService.vindBestellingOpId(10);

		assertEquals(datum, besteld.getDatumDeadline());
		assertEquals(1, bestelling.getKetel());
		assertEquals(2, bestelling.getKlant());
		assertEquals("Nieuw", bestelling.getStatus());
	}

}
