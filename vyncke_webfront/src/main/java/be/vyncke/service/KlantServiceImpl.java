package be.vyncke.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.vyncke.domain.Klant;

@Service
public class KlantServiceImpl implements KlantService {

	@Override
	public Collection<Klant> zoekKlantenOpNaam(Klant klant) {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8081/klants/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("voornaam", klant.getVoornaam());
		parameters.put("naam", klant.getNaam());
		TraversalBuilder tb = traverson.follow("search", "findByVoornaamStartingWithIgnoreCaseAndNaamStartingWithIgnoreCaseOrderByNaam")
										.withTemplateParameters(parameters); 
		ParameterizedTypeReference<Resources<Klant>> typeRefDevices = new ParameterizedTypeReference<Resources<Klant>>() {};
		Resources<Klant> resKlanten = tb.toObject(typeRefDevices);
		Collection<Klant> klanten = resKlanten.getContent();
		return klanten;
	}

	@Override
	public Klant voegKlantToe(Klant klant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Klant zoekKlantOpId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Klant> alleKlanten() {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8081/klants/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TraversalBuilder tb = traverson.follow(); 
		ParameterizedTypeReference<Resources<Klant>> typeRefDevices = new ParameterizedTypeReference<Resources<Klant>>() {};
		Resources<Klant> resKlanten = tb.toObject(typeRefDevices);
		Collection<Klant> klanten = resKlanten.getContent();
		return klanten;
	}

}
