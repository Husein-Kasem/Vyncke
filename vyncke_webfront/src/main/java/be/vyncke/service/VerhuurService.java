package be.vyncke.service;

import java.util.Collection;
import java.util.Date;

import be.vyncke.domain.*;

public interface VerhuurService {
	Collection<Huurcontract> alleHuurcontracten();
	Collection<Aanvraag> zoekAanvragenOpKlantId(int id);
	Collection<Huurcontract> zoekHuurcontractenOpKlantId(int id);
	Collection<Huurcontract> zoekHuurcontractenTijdensPeriode(Date beginDatum, Date eindDatum);
	Aanvraag voegAanvraagToe(Aanvraag aanvraag);
}
