package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Prepose implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strNumEmploye;
	private String strMotDePasse;
	private String strAdresse;

	private String strNom;
	private String strPrenom;
	private String strTelephone;
	private ListeAdherents liste = ListeAdherents.getInstance();
	private Catalogue catalogue = Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");
	private static Prepose instance;

	public Prepose(String strNumEmploye, String strMotDePasse, String strAdresse, String strNom, String strPrenom,
			String strTelephone) {
		super();
		this.strNumEmploye = strNumEmploye;
		this.strMotDePasse = strMotDePasse;
		this.strAdresse = strAdresse;
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strTelephone = strTelephone;
	}

	public Prepose() {

	}
	public static Prepose getInstance() {
		if (instance == null) {
			//
			  instance = new Prepose();
		}
			
			  return instance; 
		
	}

	public void afficherAdherents(Adherent adherent) {
		for (int i = 0; i < liste.getLstAdherents().size(); i++) {
			if(liste.getLstAdherents().get(i).equals(adherent))
			System.out.println(liste.getLstAdherents().get(i));
		}
	}

	@SuppressWarnings("unchecked")
	public void ajouterAdherent(Adherent adherent) {

		// voir comment attribuer un Numero d'adh�rent

		// ListeAdherents liste = ListeAdherents.getInstance();

		int intNumAjout = 1900;
		int intNumAdherent = 0;

		// pour ne pas repeter le meme adh�srent

		boolean bootrouver = false;

		try {
			if (liste.getLstAdherents().get(0) != null) {//si la liste est remplie

				//for (int i = 0; i < liste.getLstAdherents().size() && !bootrouver; i++) {
			//		if (liste.getLstAdherents().get(i).getStrNumeroTelephone().equals(adherent.getStrNumeroTelephone())&&liste.getLstAdherents().get(i).getStrAdresse().equals(adherent.getStrAdresse()) ) {//si c'est le meme adherent
					//	bootrouver = true;
			// System.out.println(liste.getLstAdherents().get(i));
			//		}
			//	}
			////	if (bootrouver) {// si on ajoute un adherent avec la mem adresse et le meme numero de telephone
			///		System.out.println("meme adherent");
				//} else {
					intNumAdherent = Integer.parseInt(liste.getLstAdherents().get(liste.getLstAdherents().size() - 1).getStrNumeroAdherent().substring(1));// Pour
	
					intNumAdherent++;
					// System.out.println(intNumAdherent);
					// liste.getLstAdherents().add(new Adherent(strNumeroAdherent, strNom,
					// strPrenom, strAdresse, strNumeroTelephone, intNbPrets, intSolde))
					//adherent.setIntNbPrets(12);
					//adherent.setDblSolde(12);
					adherent.setStrNumeroAdherent("A"+String.valueOf(intNumAdherent));
					liste.getLstAdherents().add(adherent);
				//}

			}
		} catch (Exception e) {
			//adherent.setIntNbPrets(0);
			//adherent.setDblSolde(0);
			adherent.setStrNumeroAdherent("A"+String.valueOf(intNumAjout) +String.valueOf( intNumAdherent ));
			liste.getLstAdherents().add(adherent);
		}

	}

	public void supprimerAdherent(Adherent adherent) {
		try {
		if (liste.getLstAdherents().get(liste.getLstAdherents().size() - 1) != null) {
			liste.getLstAdherents().remove(adherent);
		}
		else {
			System.out.println("Echoue"); 
		}
		}catch(Exception e) {
		
		}
		

	}
	public void ajouterDocument(Document document) {
		try {
			if(catalogue.getLstDocuments().get(0)!=null) {
				catalogue.getLstDocuments().add(document);
			}
		}catch(Exception e) {
			catalogue.getLstDocuments().add(document);
		}
	}
	public void supprimerDocument(Document document) {
		try {
			if(catalogue.getLstDocuments().get(catalogue.getLstDocuments().size()-1)!=null) {
				catalogue.getLstDocuments().remove(document);
			}
		}catch(Exception e) {
			
		}
	}
	public void inscrirePret(Document document,Adherent adherent) {
		
		adherent.setIntNbPrets(adherent.getintNbPrets()+1);
		document.setDisponible("Non disponible");
		document.setEmprunteur(adherent.getStrPrenom()+" "+adherent.getStrNom());
		
	}

	public String getNoEmploye() {
		return strNumEmploye;
	}

	public String getMotDePasse() {
		return strMotDePasse;
	}

	public String getPrenom() {
		return strPrenom;
	}
	public void setNoEmploye(String strNoEmploye) {
		this.strNumEmploye=strNoEmploye;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Prepose prepose = new Prepose();

	//ListeAdherents liste = ListeAdherents.getInstance();
		Adherent a1 = new Adherent("2", "allossssttttt", "tets", "afge", "(333) 987-3344", 2, 2);
		Adherent a2 = new Adherent("3", "klk", "tets", "afge", "(334) 444-4444", 2, 2);
		Adherent a3 = new Adherent("4", "klk", "tets", "afge", "(334) 444-2345", 2, 2);

		// a1.setStrNumeroAdherent(1+a1.getStrNumeroAdherent());
		liste.serialisationAdherent();

		prepose.ajouterAdherent(a1);
		prepose.ajouterAdherent(a2);
		prepose.ajouterAdherent(a3);

		//prepose.supprimerAdherent(a1);
		prepose.afficherAdherents();*/
		// System.out.println(liste.getLstAdherents().get(0).getStrNumeroAdherent());

	}

}
