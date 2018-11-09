package be.vyncke.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.vyncke.domain.*;
import be.vyncke.service.BestellingService;

@Controller
@RequestMapping("/")
public class BestellingController {
	@Autowired
	protected BestellingService bestellingService = null;
	
	@RequestMapping(value={"/bestellingen.html"}, method=RequestMethod.GET)
	public String index(ModelMap model) {
		Collection<Bestelling> bestellingen = bestellingService.alleBestellingen();
		model.addAttribute("bestellingen", bestellingen);
		return "/bestellingen";
	}
	
	@RequestMapping(value= {"/bestellingDetailsPersoneel.html"}, method=RequestMethod.GET)
	public String bestellingDetails (@RequestParam("id") int id , ModelMap model) {
		Bestelling bestelling = bestellingService.vindBestellingOpId(id);
		model.addAttribute("bestellingdetails", bestelling);
		return "/bestellingDetailsPersoneel";
	}
	
	@RequestMapping(value={"/bestellingPlaatsen.html"}, method=RequestMethod.POST)
	public String bestellingPlaatsen(ModelMap model) {
		Ketel ketel = new Ketel();
		model.addAttribute("nieuweketel", ketel);	
		return "/bestellingPlaatsen";
	}
	
	@RequestMapping(value={"/bestellingPlaatsen.html"}, method=RequestMethod.POST, params={"bestelling"})
	public String nieuweBestelling(@ModelAttribute("nieuweketel") Ketel nieuweketel,
								@RequestParam("datumDeadline") String deadlineS,	
								ModelMap model) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datumDeadline = new Date();
		try {
			datumDeadline = sdf.parse(deadlineS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ketel ketel = bestellingService.nieuweKetel(nieuweketel);
		Bestelling bestelling = new Bestelling();
		bestelling.setKetel(ketel.getId());
		bestelling.setKlant(2);
		bestelling.setDatumAangemaakt(cal.getTime());
		bestelling.setDatumDeadline(datumDeadline);
		bestelling.setStatus("Nieuw");
		bestellingService.nieuweBestelling(bestelling);
		return "redirect:/klantBestellingen.html";
	}
	
	@RequestMapping(value={"/nieuweOfferte.html"}, method=RequestMethod.POST)
	public String nieuweOfferteToevoegen(@ModelAttribute("nieuwofferte") Offerte offerte, ModelMap model) {		
		return "redirect:/klantBestellingen.html";
	}	

	@RequestMapping(value= {"/beheerBestelling"}, method=RequestMethod.DELETE, params= {"delete"})
	public String deleteBestelling (@RequestParam("delete") int id, ModelMap model) {
		bestellingService.verwijderBestellingOpId(id);
		return "redirect:/klantBestellingen.html";
	}
	
	@RequestMapping(value= {"/bestellingDetailsKlant.html"}, method=RequestMethod.GET)
	public String bestellingDetailsKlant (@RequestParam("id") int id, ModelMap model) {
		Bestelling bestelling = bestellingService.vindBestellingOpId(id);
		Collection<Offerte> offertes = bestellingService.vindOffertesOpBestelling(id);
		model.addAttribute("bestellingdetails", bestelling);
		model.addAttribute("offertes", offertes);
		return "/bestellingDetailsKlant";
	}
	
	@RequestMapping(value= {"/deleteBestelling"}, method=RequestMethod.DELETE)
	public String deletePersoneel (@RequestParam("delete") int id, ModelMap model) {
		bestellingService.verwijderBestellingOpId(id);
		return "redirect:/klantBestellingen.html";
	}
	
	@RequestMapping(value= {"/offerteAccepteren"}, method=RequestMethod.POST)
	public String accepteerOfferte (@RequestParam("id") int id, ModelMap model) {
		Offerte offerte = bestellingService.vindOfferteOpId(id);
		bestellingService.accepteerOfferte(id, offerte.getBestellingId());
		return "redirect:/klantBestellingen.html";
	}
}
