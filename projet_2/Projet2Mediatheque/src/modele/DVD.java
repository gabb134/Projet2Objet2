package modele;

import java.time.LocalDate;





public class DVD extends Document{
	
	private int  nbDisques;
	public int getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(int nbDisques) {
		this.nbDisques = nbDisques;
	}

	public String getStrRealisateur() {
		return strRealisateur;
	}

	public void setStrRealisateur(String strRealisateur) {
		this.strRealisateur = strRealisateur;
	}

	private String strRealisateur;
	public DVD(String noDoc, String titre, LocalDate dateParution, String disponible,String emprunteur, 
			   int nbDisques, String strRealisateur) {
		
		super(noDoc, titre, dateParution, disponible,emprunteur);
		this.nbDisques = nbDisques;
		this.strRealisateur = strRealisateur;
	}
	
	public String toString() {
		return " DVD :" + super.toString()+ "nbDisques: " +this.nbDisques+ " R�alisateur: "+ this.strRealisateur; 
	}
}
