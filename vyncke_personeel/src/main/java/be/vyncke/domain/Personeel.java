package be.vyncke.domain;

import javax.persistence.*;

@Entity
public class Personeel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String voornaam;
	private String naam;
	private String email;
	private String passwoord;
	private int functieId;
	
	public Personeel() {
		
	}

	public Personeel(String voornaam, String naam, String email, String passwoord, int functieId) {
		this.voornaam = voornaam;
		this.naam =naam;
		this.email = email;
		this.passwoord = passwoord;
		this.functieId = functieId;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswoord() {
		return passwoord;
	}

	public void setPasswoord(String passwoord) {
		this.passwoord = passwoord;
	}

	public int getFunctieId() {
		return functieId;
	}

	public void setFunctieId(int functieId) {
		this.functieId = functieId;
	}
}
