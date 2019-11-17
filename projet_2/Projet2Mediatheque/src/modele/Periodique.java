package modele;


import java.io.Serializable;
import java.time.LocalDate;




public class Periodique extends Document {
	
	
	private int noVolume;
	private  int noPeriodique;

	public Periodique(String noDoc, String titre, LocalDate dateParution, String disponible,String emprunteur, int noVolume, int noPeriodique) {
		super(noDoc, titre, dateParution, disponible,emprunteur);
	this.noVolume= noVolume;
	this.noPeriodique= noPeriodique;
	}

	public int getNoVolume() {
		return noVolume;
	}

	public void setNoVolume(int noVolume) {
		this.noVolume = noVolume;
	}

	public int getNoPeriodique() {
		return noPeriodique;
	}

	public void setNoPeriodique(int noPeriodique) {
		this.noPeriodique = noPeriodique;
	}

	@Override
	public String toString() {
		return "Periodique [" + super.toString()+ "noVolume=" + noVolume + ", noPeriodique=" + noPeriodique +  "]";
	}

	
}
