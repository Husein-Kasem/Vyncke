package be.vyncke.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import be.vyncke.domain.Aanvraag;
import be.vyncke.domain.Bestelling;
import be.vyncke.domain.Functie;
import be.vyncke.domain.Huurcontract;
import be.vyncke.domain.Ketel;
import be.vyncke.domain.Klant;
import be.vyncke.domain.Personeel;

@Service
public class VerhuurServiceImpl implements VerhuurService {

	@Override
	public Collection<Huurcontract> alleHuurcontracten() {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8083/huurcontracts/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TraversalBuilder tb = traverson.follow(); 
		ParameterizedTypeReference<Resources<Huurcontract>> typeRefDevices = new ParameterizedTypeReference<Resources<Huurcontract>>() {};
		Resources<Huurcontract> resHuurcontracten = tb.toObject(typeRefDevices);
		Collection<Huurcontract> huurcontracten = resHuurcontracten.getContent();
		return huurcontracten;
	}

	@Override
	public Collection<Aanvraag> zoekAanvragenOpKlantId(int id) {
		Traverson traverson = null;
		Collection<Aanvraag> aanvragen = new ArrayList<Aanvraag>();
		try {
			traverson = new Traverson(new URI("http://localhost:8083/aanvraags/"), MediaTypes.HAL_JSON);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("klant", id);
			TraversalBuilder tb = traverson.follow("search", "findByKlantId")
											.withTemplateParameters(parameters);  
			ParameterizedTypeReference<Resources<Aanvraag>> typeRefDevices = new ParameterizedTypeReference<Resources<Aanvraag>>() {};
			try {
				Resources<Aanvraag> resAanvragen = tb.toObject(typeRefDevices);
				aanvragen = resAanvragen.getContent();
			} catch (HttpClientErrorException ex)   {
			    if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
			        return aanvragen;
			    }
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aanvragen;
	}

	@Override
	public Collection<Huurcontract> zoekHuurcontractenOpKlantId(int id) {
		Traverson traverson = null;
		Collection<Huurcontract> huurcontracten = new ArrayList<Huurcontract>();
		try {
			traverson = new Traverson(new URI("http://localhost:8083/huurcontracts/"), MediaTypes.HAL_JSON);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("klant", id);
			TraversalBuilder tb = traverson.follow("search", "findByKlantId")
											.withTemplateParameters(parameters);  
			ParameterizedTypeReference<Resources<Huurcontract>> typeRefDevices = new ParameterizedTypeReference<Resources<Huurcontract>>() {};
			try {
				Resources<Huurcontract> resHuurcontracten = tb.toObject(typeRefDevices);
				huurcontracten = resHuurcontracten.getContent();
			} catch (HttpClientErrorException ex)   {
			    if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
			        return huurcontracten;
			    }
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return huurcontracten;
	}

	@Override
	public Collection<Huurcontract> zoekHuurcontractenTijdensPeriode(Date beginDatum, Date eindDatum) {
		Traverson traverson = null;
		try {
			traverson = new Traverson(new URI("http://localhost:8083/huurcontracts/"), MediaTypes.HAL_JSON);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("beginDatum1", beginDatum);
		parameters.put("eindDatum1", eindDatum);
		parameters.put("beginDatum2", beginDatum);
		parameters.put("eindDatum2", eindDatum);
		TraversalBuilder tb = traverson.follow("search", "findByBeginDatumBetweenAndEindDatumBetween")
										.withTemplateParameters(parameters); 
		ParameterizedTypeReference<Resources<Huurcontract>> typeRefDevices = new ParameterizedTypeReference<Resources<Huurcontract>>() {};
		Resources<Huurcontract> resHuurcontracten = tb.toObject(typeRefDevices);
		Collection<Huurcontract> huurcontracten = resHuurcontracten.getContent();
		return huurcontracten;
	}

	@Override
	public Aanvraag voegAanvraagToe(Aanvraag aanvraag) {
		RestTemplate rt = new RestTemplate();
		return rt.postForObject("http://localhost:8083/aanvraags", aanvraag, Aanvraag.class);
	}

}
