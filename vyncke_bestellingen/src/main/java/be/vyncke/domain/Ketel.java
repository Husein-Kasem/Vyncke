package be.vyncke.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ketel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private int energieOutput;

	public Ketel(String type, int energieOutput) {
		this.type = type;
		this.energieOutput = energieOutput;
	}
	
	public Ketel() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEnergieOutput() {
		return energieOutput;
	}
	public void setEnergieOutput(int energieOutput) {
		this.energieOutput = energieOutput;
	}
	
}