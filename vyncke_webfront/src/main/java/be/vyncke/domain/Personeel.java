package be.vyncke.domain;

public class Personeel {
	private int id;
	private String voornaam;
	private String naam;
	private String email;
	private String passwoord;
	private int functieId;
	
	private Functie functie;
	
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

	public Functie getFunctie() {
		return functie;
	}

	public void setFunctie(Functie functie) {
		this.functie = functie;
	}
}
