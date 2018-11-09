package be.vyncke.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Huurcontract {
	private int id;
	private int klantId;
	private Date beginDatum;
	private Date eindDatum;
	
	public Huurcontract() {
		
	}
	
	public Huurcontract(int klantId, Date beginDatum, Date eindDatum) {
		this.klantId = klantId;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
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
	
}
