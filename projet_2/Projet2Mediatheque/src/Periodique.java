

import java.io.Serializable;
import java.time.LocalDate;




public class Periodique extends Document {
	
	
	private int noVolume;
	private  int noPeriodique;

	public Periodique(String noDoc, String titre, LocalDate dateParution, String disponible, int noVolume, int noPeriodique) {
		super(noDoc, titre, dateParution, disponible);
	this.noVolume= noVolume;
	this.noPeriodique= noPeriodique;
	}

	@Override
	public String toString() {
		return "Periodique [" + super.toString()+ "noVolume=" + noVolume + ", noPeriodique=" + noPeriodique +  "]";
	}

	
}
