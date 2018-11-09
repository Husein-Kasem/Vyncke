package be.vyncke.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.vyncke.domain.Functie;
import be.vyncke.domain.Personeel;

@Service
public class PersoneelServiceImpl implements PersoneelService {

	@Override
	public Functie zoekFunctieOpId(int id) {
		RestTemplate rt = new RestTemplate();
		Functie functie = rt.getForObject("http://localhost:8082/functies/{id}", Functie.class, id);
		return functie;
	}

	@Override
	public Collection<Personeel> zoekPersoneelOpNaam(Personeel personeel) {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8082/personeels/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("voornaam", personeel.getVoornaam());
		parameters.put("naam", personeel.getNaam());
		TraversalBuilder tb = traverson.follow("search", "findByVoornaamStartingWithIgnoreCaseAndNaamStartingWithIgnoreCaseOrderByNaam")
										.withTemplateParameters(parameters); 
		ParameterizedTypeReference<Resources<Personeel>> typeRefDevices = new ParameterizedTypeReference<Resources<Personeel>>() {};
		Resources<Personeel> resPersoneel = tb.toObject(typeRefDevices);
		Collection<Personeel> personeelList = resPersoneel.getContent();
		for(Personeel p : personeelList) {
			Functie f = zoekFunctieOpId(p.getFunctieId());
			p.setFunctie(f);
		}
		return personeelList;
	}

	@Override
	public Personeel voegPersoneelToe(Personeel personeel) {
		RestTemplate rt = new RestTemplate();
		return rt.postForObject("http://localhost:8082/personeels", personeel, Personeel.class);
	}

	@Override
	public Personeel zoekPersoneelOpId(int id) {
		RestTemplate rt = new RestTemplate();
		Personeel personeel = rt.getForObject("http://localhost:8082/personeels/{id}", Personeel.class, id);
		Functie f = zoekFunctieOpId(personeel.getFunctieId());
		personeel.setFunctie(f);
		return personeel;
	}

	@Override
	public Collection<Personeel> allePersoneel() {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8082/personeels/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TraversalBuilder tb = traverson.follow(); 
		ParameterizedTypeReference<Resources<Personeel>> typeRefDevices = new ParameterizedTypeReference<Resources<Personeel>>() {};
		Resources<Personeel> resPersoneel = tb.toObject(typeRefDevices);
		Collection<Personeel> personeel = resPersoneel.getContent();
		for(Personeel p : personeel) {
			Functie f = zoekFunctieOpId(p.getFunctieId());
			p.setFunctie(f);
		}
		return personeel;
	}

	@Override
	public void verwijderPersoneelOpId(int id) {
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8082/personeels/{id}", id);
	}

	@Override
	public void pasPersoneelAan(Personeel personeel) {
		RestTemplate rt = new RestTemplate();
		rt.put("http://localhost:8082/personeels/{id}", personeel, personeel.getId());
	}

}
