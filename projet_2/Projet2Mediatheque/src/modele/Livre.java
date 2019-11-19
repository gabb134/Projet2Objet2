package modele;


import java.io.Serializable;
import java.time.LocalDate;



public class Livre  extends Document {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 8803883087859292585L;
private String auteur;
	
	public Livre(String noDoc, String titre, LocalDate dateParution, String disponible,Adherent emprunteur ,String motsCles, 
				 String auteur) {
		
		super(noDoc, titre, dateParution, disponible,emprunteur);
		this.auteur =auteur;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [" +  super.toString()+ "auteur="  +auteur + "]";
	}



	
	
}
