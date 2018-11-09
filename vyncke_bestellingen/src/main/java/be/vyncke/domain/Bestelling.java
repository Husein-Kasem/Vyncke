package be.vyncke.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bestelling {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private Date datumAangemaakt;
		private Date datumDeadline;
		private int ketel;
		private int klant;
		private String status;
	
		
	public Bestelling(Date datumDeadline, int ketel, int klant, String status) {
		super();
		this.datumDeadline = datumDeadline;
		this.ketel = ketel;
		this.klant = klant;
		this.status = status;
		this.datumAangemaakt = new Date();
	}
	public Bestelling() {}
	public int getId() {return id;}
	public void setId(int id) {	this.id = id;}
	public Date getDatumAangemaakt() {	return datumAangemaakt;	}
	public void setDatumAangemaakt(Date datumAangemaakt) {	this.datumAangemaakt = datumAangemaakt;	}
	public Date getDatumDeadline() {return datumDeadline;}
	public void setDatumDeadline(Date datumDeadline) {	this.datumDeadline = datumDeadline;	}
	public int getKetel() {	return ketel;}
	public void setKetel(int ketel) {
		this.ketel = ketel;
	}
	public int getKlant() {
		return klant;
	}
	public void setKlant(int klant) {
		this.klant = klant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
