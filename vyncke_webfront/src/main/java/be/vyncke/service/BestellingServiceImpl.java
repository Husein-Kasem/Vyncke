package be.vyncke.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import be.vyncke.domain.*;

@Service
public class BestellingServiceImpl implements BestellingService {

	@Override
	public Collection<Bestelling> zoekBestellingenOpStatus(Bestelling bestelling) {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8084/bestellings/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("status", bestelling.getStatus());
		TraversalBuilder tb = traverson.follow("search", "findByStatusStartingWithIgnoreCase")
										.withTemplateParameters(parameters); 
		ParameterizedTypeReference<Resources<Bestelling>> typeRefDevices = new ParameterizedTypeReference<Resources<Bestelling>>() {};
		Resources<Bestelling> resBestellingen = tb.toObject(typeRefDevices);
		Collection<Bestelling> bestellingen = resBestellingen.getContent();
		return bestellingen;
	}
	@Override
	public void verwijderBestellingOpId(int id) {
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8084/bestellings/{id}", id);
	}
	@Override
	public Collection<Bestelling> alleBestellingen() {
		Traverson traverson = null;
		Collection<Bestelling> bestellingen = new ArrayList<Bestelling>();
		try {
			traverson = new Traverson(new URI("http://localhost:8084/bestellings/"), MediaTypes.HAL_JSON);
			TraversalBuilder tb = traverson.follow(); 
			ParameterizedTypeReference<Resources<Bestelling>> typeRefDevices = new ParameterizedTypeReference<Resources<Bestelling>>() {};
			try {
				Resources<Bestelling> resBestellingen = tb.toObject(typeRefDevices);
				bestellingen = resBestellingen.getContent();
			} catch (HttpClientErrorException ex)   {
			    if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
			        return bestellingen;
			    }
			}
			for(Bestelling b : bestellingen) {
				RestTemplate rt = new RestTemplate();
				int klantId = b.getKlant();
				int ketelId = b.getKetel();
				Klant klant = rt.getForObject("http://localhost:8081/klants/{id}", Klant.class, klantId);
				Ketel ketel = rt.getForObject("http://localhost:8084/ketels/{id}", Ketel.class, ketelId);
				b.setThisKetel(ketel);
				b.setThisKlant(klant);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bestellingen;
	}
	@Override
	public Collection<Bestelling> vindBestellingenOpKlantId(int id) {
		Traverson traverson = null;
		Collection<Bestelling> bestellingen = new ArrayList<Bestelling>();
		try {
			traverson = new Traverson(new URI("http://localhost:8084/bestellings/"), MediaTypes.HAL_JSON);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("klant", id);
			TraversalBuilder tb = traverson.follow("search", "findByKlant")
											.withTemplateParameters(parameters);  
			ParameterizedTypeReference<Resources<Bestelling>> typeRefDevices = new ParameterizedTypeReference<Resources<Bestelling>>() {};
			try {
				Resources<Bestelling> resBestellingen = tb.toObject(typeRefDevices);
				bestellingen = resBestellingen.getContent();
			} catch (HttpClientErrorException ex)   {
			    if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
			        return bestellingen;
			    }
			}
			for(Bestelling b : bestellingen) {
				RestTemplate rt = new RestTemplate();
				int klantId = b.getKlant();
				int ketelId = b.getKetel();
				Klant klant = rt.getForObject("http://localhost:8081/klants/{id}", Klant.class, klantId);
				Ketel ketel = rt.getForObject("http://localhost:8084/ketels/{id}", Ketel.class, ketelId);
				b.setThisKetel(ketel);
				b.setThisKlant(klant);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bestellingen;
	}
	@Override
	public Bestelling vindBestellingOpId(int id) {
		RestTemplate rt = new RestTemplate();
		Bestelling b = rt.getForObject("http://localhost:8084/bestellings/{id}", Bestelling.class, id);
		int klantId = b.getKlant();
		int ketelId = b.getKetel();
		Klant klant = rt.getForObject("http://localhost:8081/klants/{id}", Klant.class, klantId);
		Ketel ketel = rt.getForObject("http://localhost:8084/ketels/{id}", Ketel.class, ketelId);
		b.setThisKetel(ketel);
		b.setThisKlant(klant);
		return b;
	}
	@Override
	public Collection<Offerte> vindOffertesOpBestelling(int id) {
		Traverson traverson = null;
		Collection<Offerte> offertes =  new ArrayList<Offerte>();
		try {
			traverson = new Traverson(new URI("http://localhost:8084/offertes/"), MediaTypes.HAL_JSON);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("bestelling", id);
			TraversalBuilder tb = traverson.follow("search", "findByBestellingId")
											.withTemplateParameters(parameters);  
			ParameterizedTypeReference<Resources<Offerte>> typeRefDevices = new ParameterizedTypeReference<Resources<Offerte>>() {};
			try {
				Resources<Offerte> resOffertes = tb.toObject(typeRefDevices);
				offertes = resOffertes.getContent();
			} catch (HttpClientErrorException ex)   {
			    if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
			        return offertes;
			    }
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offertes;
	}
	@Override
	public Offerte vindOfferteOpId(int id) {
		RestTemplate rt = new RestTemplate();
		return rt.getForObject("http://localhost:8084/offertes/{id}", Offerte.class, id);
	}
	
	@Override
	public void accepteerOfferte(int id, int bestellingId) {
		Collection<Offerte> offertes = vindOffertesOpBestelling(bestellingId);
		RestTemplate rt = new RestTemplate();
		for (Offerte o : offertes) {
			if (o.getId() != id) {
				rt.delete("http://localhost:8084/offertes/{id}", o.getId());
			}
		}
		Bestelling bestelling = vindBestellingOpId(bestellingId);
		bestelling.setStatus("Actief");
		rt.put("http://localhost:8084/bestellings/{id}", bestelling, bestellingId);
	}
	@Override
	public Bestelling nieuweBestelling(Bestelling bestelling) {
		RestTemplate rt = new RestTemplate();
		return rt.postForObject("http://localhost:8084/bestellings/", bestelling, Bestelling.class);
	}
	@Override
	public Ketel nieuweKetel(Ketel ketel) {
		RestTemplate rt = new RestTemplate();
		return rt.postForObject("http://localhost:8084/ketels/", ketel, Ketel.class);
	}
	@Override
	public Offerte voegOfferteToe(Offerte offerte) {
		RestTemplate rt = new RestTemplate();
		return rt.postForObject("http://localhost:8084/offertes", offerte, Offerte.class);
	}

}
