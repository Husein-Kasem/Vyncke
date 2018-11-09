package be.vyncke.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import be.vyncke.domain.*;
import be.vyncke.service.PersoneelService;

@Controller
@RequestMapping("/")
public class PersoneelController {
	@Autowired
	protected PersoneelService personeelService = null;
	
	@RequestMapping(value={"/personeel.html","/zoekpersoneel.html"}, method=RequestMethod.GET)
	public String index(ModelMap model) {
		Personeel personeel = new Personeel();
		Collection<Personeel> personeelList = personeelService.allePersoneel();
		model.addAttribute("zoekpersoneel", personeel);	
		model.addAttribute("personeel", personeelList);	
		return "/personeel";
	}
	
	@RequestMapping(value={"/personeel.html","/zoekpersoneel.html"}, method=RequestMethod.POST, params={"zoek"})
	public String zoekPersoneel(@ModelAttribute("zoekpersoneel") Personeel zoekpersoneel, ModelMap model) {
		Collection<Personeel> personeelList = personeelService.zoekPersoneelOpNaam(zoekpersoneel);
		model.addAttribute("zoekpersoneel", zoekpersoneel);
		model.addAttribute("personeel", personeelList);		
		return "/personeel";
	}
	
	@RequestMapping(value={"/personeel.html","/zoekpersoneel.html"}, method=RequestMethod.POST, params={"nieuw"})
	public String nieuwPersoneel(ModelMap model) {
		model.addAttribute("nieuwpersoneel", new Personeel());		
		return "/nieuwPersoneel";
	}
	
	@RequestMapping(value={"/nieuwPersoneel.html"}, method=RequestMethod.POST)
	public String nieuwLidToevoegen(@ModelAttribute("nieuwpersoneel") Personeel personeel, 							
							@RequestParam(required=false, value="verkoper") String verkoper, 
							@RequestParam(required=false, value="ketelmaker") String ketelmaker, 
							ModelMap model) {		
		if (verkoper != null) {
			personeel.setFunctieId(1);
		}
		else if (ketelmaker != null) {
			personeel.setFunctieId(2);
		}
		personeelService.voegPersoneelToe(personeel);	
		return "redirect:/personeel.html";
	}
	
	@RequestMapping(value= {"/personeelDetails.html"}, method=RequestMethod.GET)
	public String personeelDetails (@RequestParam("id") int id , ModelMap model) {
		Personeel personeel = personeelService.zoekPersoneelOpId(id);
		model.addAttribute("personeeldetails", personeel);
		return "/personeelDetails";
	}
	
	@RequestMapping(value= {"/beheerPersoneel"}, method=RequestMethod.POST, params= {"delete"})
	public String deletePersoneel (@RequestParam("delete") int id, ModelMap model) {
		personeelService.verwijderPersoneelOpId(id);
		return "redirect:/personeel.html";
	}
	
	@RequestMapping(value= {"/beheerPersoneel"}, method=RequestMethod.POST, params= {"wijzig"})
	public String wijzigPersoneel (@RequestParam("wijzig") int id, ModelMap model) {
		Personeel personeel = personeelService.zoekPersoneelOpId(id);
		model.addAttribute("personeel", personeel);
		return "/personeelWijzigen";
	}
	
	@RequestMapping(value= {"/personeelWijzigen.html"}, method=RequestMethod.PUT)
	public String wijzigPersoneel (@ModelAttribute("personeel") Personeel personeel,
				@RequestParam(required=false, value="verkoper") String verkoper, 
				@RequestParam(required=false, value="ketelmaker") String ketelmaker, 
				ModelMap model) {		
		if (verkoper != null) {
		personeel.setFunctieId(1);
		}
		else if (ketelmaker != null) {
		personeel.setFunctieId(2);
		}
		personeelService.pasPersoneelAan(personeel);	
		return "redirect:/personeel.html";
	}
}
