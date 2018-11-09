package be.vyncke.domain;

public class Klant {

	private int id;
	private String voornaam;
	private String naam;
	private String email;
	private String passwoord;
	
	public Klant() {
		
	}

	public Klant(String voornaam, String naam, String email, String passwoord) {
		this.voornaam = voornaam;
		this.naam =naam;
		this.email = email;
		this.passwoord = passwoord;
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
}
