package be.vyncke.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.vyncke.domain.*;
import be.vyncke.service.BestellingService;
import be.vyncke.service.KlantService;
import be.vyncke.service.VerhuurService;

@Controller
@RequestMapping("/")
public class KlantController {
	@Autowired
	protected KlantService klantService = null;
	
	@Autowired
	protected BestellingService bestellingService = null;
	
	@Autowired
	protected VerhuurService verhuurService = null;
	
	@RequestMapping(value={"/klanten.html","/zoekklanten.html"}, method=RequestMethod.GET)
	public String index(ModelMap model) {
		Klant klant = new Klant();
		Collection<Klant> klanten = klantService.alleKlanten();
		model.addAttribute("zoekklant", klant);	
		model.addAttribute("klanten", klanten);	
		return "/klanten";
	}
	
	@RequestMapping(value={"/klanten.html","/zoekklanten.html"}, method=RequestMethod.POST, params={"zoek"})
	public String zoekLeden(@ModelAttribute("zoekklant") Klant zoekklant, ModelMap model) {
		Collection<Klant> klanten = klantService.zoekKlantenOpNaam(zoekklant);
		model.addAttribute("zoekklant", zoekklant);
		model.addAttribute("klanten",klanten);		
		return "/klanten";
	}
	
	@RequestMapping(value={"/klantBestellingen.html"}, method=RequestMethod.GET)
	public String vindBestellingen(ModelMap model) {
		Collection<Bestelling> bestellingen = new ArrayList<Bestelling>();
		Collection<Aanvraag> aanvragen = new ArrayList<Aanvraag>();
		Collection<Huurcontract> huurcontracten = new ArrayList<Huurcontract>();
		bestellingen = bestellingService.vindBestellingenOpKlantId(2);
		model.addAttribute("bestellingen", bestellingen);
		aanvragen = verhuurService.zoekAanvragenOpKlantId(2);
		model.addAttribute("aanvragen",aanvragen);
		huurcontracten = verhuurService.zoekHuurcontractenOpKlantId(2);
		model.addAttribute("huurcontracten", huurcontracten);
		return "/klantBestellingen";
	}
}
