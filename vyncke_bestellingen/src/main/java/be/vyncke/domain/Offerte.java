package be.vyncke.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offerte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double prijs;
	private Date uitersteDatum;
	private int bestellingId;
	
	public Offerte() {
		
	}
	
	public Offerte(double prijs, Date date2, int bestellingId) {
		this.prijs = prijs;
		this.uitersteDatum = date2;
		this.bestellingId = bestellingId;
	}

	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public Date getUitersteDatum() {
		return uitersteDatum;
	}
	public void setUitersteDatum(Date uitersteDatum) {
		this.uitersteDatum = uitersteDatum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBestellingId() {
		return bestellingId;
	}

	public void setBestellingId(int bestellingId) {
		this.bestellingId = bestellingId;
	}
	
	
	
}
