package be.vyncke.domain;

import javax.persistence.*;

@Entity
public class Klant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String voornaam;
	private String naam;
	private String email;
	private String passwoord;
	private int age;
	
	public Klant() {
		
	}

	public Klant(String voornaam, String naam, String email, String passwoord, int age) {
		this.voornaam = voornaam;
		this.naam =naam;
		this.email = email;
		this.passwoord = passwoord;
		this.age = age;
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
		if(voornaam == ""){
			throw new IllegalArgumentException("De naam mag niet leeg zijn");
		}else if(voornaam.length() > 20){
			voornaam = voornaam.substring(0,20);
		}
		this.voornaam = voornaam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if(naam == ""){
			naam = "no name";
		}else if(naam.length() > 20){
			naam = naam.substring(0,20);
		}
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age <= 0){
			throw new IllegalArgumentException("De leeftijd mag niet 0 of nigatieve nummer zijn");
		}else if (age > 120){
			throw new IllegalArgumentException("De leeftijd mag niet meer dan 120 zijn");
		}else{
			this.age = age;
		}
	}
}
