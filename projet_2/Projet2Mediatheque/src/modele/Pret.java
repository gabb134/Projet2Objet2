package modele;

import java.io.Serializable;
import java.time.LocalDate;

public class Pret implements Serializable{

	
	private int noEmprunt;
	private LocalDate dateEmprunt;
	private LocalDate dateRetourPrevu;
	private LocalDate dateRetourEffectue;
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
