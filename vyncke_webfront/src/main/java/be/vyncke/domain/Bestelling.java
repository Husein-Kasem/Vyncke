package be.vyncke.domain;

import java.util.Calendar;
import java.util.Date;

public class Bestelling {
		private int id;
		private Date datumAangemaakt;
		private Date datumDeadline;
		private int ketel;
		private int klant;
		private String status;
		private Klant thisKlant;
		private Ketel thisKetel;
	
	public Bestelling() {}	
	
	public Bestelling(Date datumDeadline, int ketel, int klant, String status) {
		this.datumDeadline = datumDeadline;
		this.ketel = ketel;
		this.klant = klant;
		this.status = status;
		Calendar cal = Calendar.getInstance();
		this.datumAangemaakt = cal.getTime();
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDatumAangemaakt() {
		return datumAangemaakt;
	}
	
	public void setDatumAangemaakt(Date datumAangemaakt) {
		this.datumAangemaakt = datumAangemaakt;
	}
	
	public Date getDatumDeadline() {
		return datumDeadline;
	}
	
	public void setDatumDeadline(Date datumDeadline) {
		this.datumDeadline = datumDeadline;
	}
	
	public int getKetel() {
		return ketel;
	}
	
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

	public Klant getThisKlant() {
		return thisKlant;
	}

	public void setThisKlant(Klant thisKlant) {
		this.thisKlant = thisKlant;
	}

	public Ketel getThisKetel() {
		return thisKetel;
	}

	public void setThisKetel(Ketel thisKetel) {
		this.thisKetel = thisKetel;
	}	
}
