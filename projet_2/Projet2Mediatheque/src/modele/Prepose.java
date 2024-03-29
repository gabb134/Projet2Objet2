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

	public String getStrNumEmploye() {
		return strNumEmploye;
	}

	public void setStrNumEmploye(String strNumEmploye) {
		this.strNumEmploye = strNumEmploye;
	}

	public String getStrMotDePasse() {
		return strMotDePasse;
	}

	public void setStrMotDePasse(String strMotDePasse) {
		this.strMotDePasse = strMotDePasse;
	}

	public String getStrAdresse() {
		return strAdresse;
	}

	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}

	public String getStrNom() {
		return strNom;
	}

	public void setStrNom(String strNom) {
		this.strNom = strNom;
	}

	public String getStrPrenom() {
		return strPrenom;
	}

	public void setStrPrenom(String strPrenom) {
		this.strPrenom = strPrenom;
	}

	public String getStrTelephone() {
		return strTelephone;
	}

	public void setStrTelephone(String strTelephone) {
		this.strTelephone = strTelephone;
	}

	public ListeAdherents getListe() {
		return liste;
	}

	public void setListe(ListeAdherents liste) {
		this.liste = liste;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setInstance(Prepose instance) {
		Prepose.instance = instance;
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
		}catch(Exception e) {
		
		}
		

	}
	public void ajouterDocument(Document document) {
	
			//	String strNumCatalogue = catalogue.getLstDocuments().get(catalogue.getLstDocuments().size()-1).getNoDoc();
				
							catalogue.getLstDocuments().add(document);
		
	}
	public void ajouterLivre(Livre livre) {
		catalogue.getLstLivres().add(livre);
	}
	public void ajouterDvd(DVD dvd) {
		catalogue.getLstDvd().add(dvd);
	}
	public void ajouterPeriodique(Periodique periodique) {
		catalogue.getLstPeriodiques().add(periodique);
	}
	public void supprimerDocument(Document document) {
		try {
			
				catalogue.getLstDocuments().remove(document);
				System.out.println("suppression document");
			
		}catch(Exception e) {
			
		}
	}
	public void supprimerLivre(Livre livre) {
	//	try {
	//		if(catalogue.getLstDocuments().get(catalogue.getLstLivres().size()-1)!=null) {
				catalogue.getLstDocuments().remove(livre);
				System.out.println("allo");
		//	}
		//}catch(Exception e) {
			
		///}
	}
	public void supprimerDvd(DVD dvd) {
		try {
			if(catalogue.getLstDocuments().get(catalogue.getLstDvd().size()-1)!=null) {
				catalogue.getLstDocuments().remove(dvd);
			}
		}catch(Exception e) {
			
		}
	}
	public void supprimerPeriodique(Periodique periodique) {
		try {
			if(catalogue.getLstDocuments().get(catalogue.getLstPeriodiques().size()-1)!=null) {
				catalogue.getLstDocuments().remove(periodique);
			}
		}catch(Exception e) {
			
		}
	}
	public void inscrirePret(Document document,Adherent adherent) {
		
		//adherent.setintNbPrets(adherent.getintNbPrets()+1);
		document.setDisponible("non");
		document.setEmprunteur(adherent);
		
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
