package be.vyncke.domain;

import javax.persistence.*;

@Entity
public class Functie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String naam;
	private String omschrijving;
	
	public Functie() {
		
	}
	
	public Functie(String naam, String omschrijving) {
		this.naam = naam;
		this.omschrijving = omschrijving;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
}
