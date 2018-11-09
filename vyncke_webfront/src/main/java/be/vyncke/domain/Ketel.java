package be.vyncke.domain;

public class Ketel {
	private int id;
	private String type;
	private int energieOutput;
	private String status;

	public Ketel(String type, int energieOutput) {
		this.type = type;
		this.energieOutput = energieOutput;
		if (energieOutput>0 || energieOutput <= 5000){
			this.energieOutput = energieOutput;
		} else{
			throw new IllegalArgumentException("De energie output moet minder of gelijk aan 5000");
		}
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
	public void setEnergieOutput(int energieOutput)
	{
		if (energieOutput>= 0 && energieOutput <= 5000){
			this.energieOutput = energieOutput;
		} else{
			throw new IllegalArgumentException("De energie output moet minder of gelijk aan 5000");
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
