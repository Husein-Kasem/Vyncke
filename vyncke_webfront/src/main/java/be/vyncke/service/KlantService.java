package be.vyncke.service;

import java.util.Collection;
import java.util.List;

import be.vyncke.domain.*;

public interface KlantService {
	Collection<Klant> zoekKlantenOpNaam(Klant klant);
	Klant voegKlantToe(Klant klant);
	Klant zoekKlantOpId(int id);
	Collection<Klant> alleKlanten();
}
