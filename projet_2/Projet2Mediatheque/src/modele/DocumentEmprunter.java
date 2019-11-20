package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class DocumentEmprunter  implements Serializable{
	private String  noDoc;
	private String  titre;
	private String auteur;
	private LocalDate  dateParution;
	

	public DocumentEmprunter(String noDoc, String titre, String auteur, LocalDate dateParution) {
		super();
		this.noDoc = noDoc;
		this.titre = titre;
		this.auteur = auteur;
		this.dateParution = dateParution;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
