package be.vyncke.service;

import java.util.Collection;

import be.vyncke.domain.Functie;
import be.vyncke.domain.Personeel;

public interface PersoneelService {
	Functie zoekFunctieOpId(int id);
	Collection<Personeel> zoekPersoneelOpNaam(Personeel personeel);
	Personeel voegPersoneelToe(Personeel personeel);
	Personeel zoekPersoneelOpId(int id);
	Collection<Personeel> allePersoneel();
	void verwijderPersoneelOpId(int id);
	void pasPersoneelAan(Personeel personeel);
}
