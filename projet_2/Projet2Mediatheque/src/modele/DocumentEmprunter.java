package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class DocumentEmprunter  implements Serializable{
	private String  noDoc;
	private String  titre;
	private String auteur;
	private LocalDate  dateParution;
	

	public String getNoDoc() {
		return noDoc;
	}


	public void setNoDoc(String noDoc) {
		this.noDoc = noDoc;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public LocalDate getDateParution() {
		return dateParution;
	}


	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}


	public DocumentEmprunter(String noDoc, String titre, String auteur, LocalDate dateParution) {
		super();
		this.noDoc = noDoc;
		this.titre = titre;
		this.auteur = auteur;
		this.dateParution = dateParution;
	}


	@Override
	public String toString() {
		return "DocumentEmprunter [noDoc=" + noDoc + ", titre=" + titre + ", auteur=" + auteur + ", dateParution="
				+ dateParution + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
