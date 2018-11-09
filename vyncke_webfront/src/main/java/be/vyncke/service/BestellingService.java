package be.vyncke.service;

import java.util.Collection;

import be.vyncke.domain.Bestelling;
import be.vyncke.domain.Ketel;
import be.vyncke.domain.Offerte;

public interface BestellingService {
	Collection<Bestelling> zoekBestellingenOpStatus(Bestelling bestelling);
	void verwijderBestellingOpId(int id);
	Collection<Bestelling> alleBestellingen();
	Collection<Bestelling> vindBestellingenOpKlantId(int id);
	Bestelling vindBestellingOpId(int id);
	Collection<Offerte> vindOffertesOpBestelling(int id);
	Offerte vindOfferteOpId(int id);
	void accepteerOfferte(int id, int bestellingsId);
	Bestelling nieuweBestelling(Bestelling bestelling);
	Ketel nieuweKetel(Ketel ketel);
	Offerte voegOfferteToe(Offerte offerte);
}
