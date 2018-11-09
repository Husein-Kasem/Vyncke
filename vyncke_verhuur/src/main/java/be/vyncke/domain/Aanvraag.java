package be.vyncke.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aanvraag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int klantId;
	private Date beginDatum;
	private Date eindDatum;
	private Date aanvraagDatum;
	
	public Aanvraag() {
		
	}
	
	public Aanvraag(int klantId, Date beginDatum, Date eindDatum) {
		this.klantId = klantId;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
		Calendar cal = Calendar.getInstance();
		this.aanvraagDatum = cal.getTime();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKlantId() {
		return klantId;
	}

	public void setKlantId(int klantId) {
		this.klantId = klantId;
	}

	public Date getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
	}

	public Date getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}

	public Date getAanvraagDatum() {
		return aanvraagDatum;
	}

	public void setAanvraagDatum(Date aanvraagDatum) {
		this.aanvraagDatum = aanvraagDatum;
	}
	
	
}
