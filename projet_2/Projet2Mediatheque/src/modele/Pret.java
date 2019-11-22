package modele;

import java.io.Serializable;
import java.time.LocalDate;

public class Pret implements Serializable{

	
	private int noEmprunt;
	private LocalDate dateEmprunt;
	private LocalDate dateRetourPrevu;
	private LocalDate dateRetourEffectue;
	public int getNoEmprunt() {
		return noEmprunt;
	}




	public void setNoEmprunt(int noEmprunt) {
		this.noEmprunt = noEmprunt;
	}




	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}




	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}




	public LocalDate getDateRetourPrevu() {
		return dateRetourPrevu;
	}




	public void setDateRetourPrevu(LocalDate dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}




	public LocalDate getDateRetourEffectue() {
		return dateRetourEffectue;
	}




	public void setDateRetourEffectue(LocalDate dateRetourEffectue) {
		this.dateRetourEffectue = dateRetourEffectue;
	}




	public double getAmende() {
		return amende;
	}




	public void setAmende(double amende) {
		this.amende = amende;
	}




	private double amende;
	
	
	
	
	public Pret(int noEmprunt, LocalDate dateEmprunt, LocalDate dateRetourPrevu, LocalDate dateRetourEffectue,
			double amende) {
		super();
		this.noEmprunt = noEmprunt;
		this.dateEmprunt = dateEmprunt;
		this.dateRetourPrevu = dateRetourPrevu;
		this.dateRetourEffectue = dateRetourEffectue;
		this.amende = amende;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
