package be.vyncke.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import be.vyncke.domain.Aanvraag;
import be.vyncke.domain.Functie;
import be.vyncke.domain.Huurcontract;
import be.vyncke.domain.Personeel;
import be.vyncke.service.KlantService;
import be.vyncke.service.VerhuurService;

@Controller
@RequestMapping("/")
public class VerhuurController {
	@Autowired
	protected VerhuurService verhuurService = null;
	
	@RequestMapping(value={"/ketelVerhuur.html"}, method=RequestMethod.GET)
	public String index(ModelMap model) {
		boolean aanvraag = false;
		boolean verzonden = false;
		Collection<Huurcontract> huurcontracten = null;
		model.addAttribute("aanvraag", aanvraag);
		model.addAttribute("verzonden", verzonden);
		model.addAttribute("huurcontracten", huurcontracten);	
		return "/ketelVerhuur";
	}
	
	@RequestMapping(value={"/ketelVerhuur.html"}, method=RequestMethod.POST, params={"aanvraag"})
	public String zoekHuurcontracten(@RequestParam(value="begindatum") String begindatumS, 
								@RequestParam(value="einddatum") String einddatumS,
								ModelMap model) {
		boolean aanvraag = true;
		boolean beschikbaar = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date begindatum = new Date();
		Date einddatum = new Date();
		Aanvraag nieuweaanvraag = new Aanvraag();
		Calendar cal = Calendar.getInstance();
		nieuweaanvraag.setAanvraagDatum(cal.getTime());
		try {
			begindatum = sdf.parse(begindatumS);
			einddatum = sdf.parse(einddatumS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(begindatum);
		cal.add(Calendar.DATE, -1);
		Date begindatum1 = cal.getTime();
		cal.setTime(einddatum);
		cal.add(Calendar.DATE, 1);
		Date einddatum1 = cal.getTime();
		Collection<Huurcontract> alleHuurcontracten = verhuurService.alleHuurcontracten();
		Collection<Huurcontract> huurcontracten = new ArrayList<Huurcontract>();
		for(Huurcontract h : alleHuurcontracten) {
			if (((h.getBeginDatum().after(begindatum1) && h.getBeginDatum().before(einddatum1)) || 
				(h.getEindDatum().before(einddatum1) && h.getEindDatum().after(begindatum1)))) {
				huurcontracten.add(h);
			}
		}
		nieuweaanvraag.setBeginDatum(begindatum);
		nieuweaanvraag.setEindDatum(einddatum);
		if (huurcontracten.isEmpty()) {
			verhuurService.voegAanvraagToe(nieuweaanvraag);
			beschikbaar = true;
		}
		model.addAttribute("aanvraag", aanvraag);
		model.addAttribute("beschikbaar", beschikbaar);
		return "/ketelVerhuur";
	}
}
