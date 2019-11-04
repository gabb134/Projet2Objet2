package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Prepose implements Serializable{

	private String strNumEmploye;
	private String strMotDePasse;
	private String strAdresse;
	private String strNom;
	private String strPrenom;
	private String strTelephone;
	
	private ArrayList<Adherent> arrAdherent = new ArrayList<Adherent>();
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
	
	//Gestion adhérents

	
	@SuppressWarnings("unchecked")
	public void ajouterAdherent(Adherent adherent) {
		File fichierAdherents= new File("C:/Users/GabrielMarrero/Downloads/test/fichierPreposes.ser");
		//File fichierPreposes= new File("C:/Users/cg.marrero/Downloads/test/fichierPreposes.ser");
		//File fichierPreposes= new File("C:/Users/rn.merzius/Downloads/test/fichierPreposes.ser");
		
		if(!fichierAdherents.exists()) {//Ajout de l'adherent
			arrAdherent.add(adherent);
			
			//Serialization
			try {
				FileOutputStream fichier = new FileOutputStream(fichierAdherents);
				ObjectOutputStream sortie = new ObjectOutputStream(fichier);
				sortie.writeObject(arrAdherent);
				sortie.close();
				fichier.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else { //Verification pour voir si l'adherent a ete enregistrer
			
			//Deserialization

			try {
				FileInputStream fichier = new FileInputStream(fichierAdherents);
				ObjectInputStream entree = new ObjectInputStream(fichier);

				arrAdherent = (ArrayList<Adherent>) entree.readObject();
				fichier.close();
				entree.close();
				
				for(Adherent a:arrAdherent)
					System.out.println(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
	
			
			
			
		}
		
	}
	public void supprimerAdherent(Adherent adherent) {
		
	}
	public void afficherAdherents(Adherent adherent) {
		
	}
	//Gestion catalogue
	public void ajouterDocument(Document document) {
		
	}
	public void supprimerDocument(Document document) {
		
	}
	//Gestion des prêts 
	public void inscrireUnPret() {
		
	}
	public void inscrireUnRetour() {
		
	}
	
	
	public String getNoEmploye()
	{
		return strNumEmploye;
	}
	public String getPrenom()
	{
		return strPrenom;
	}
	
	public static void main(String[] args) {
		Prepose p = new Prepose();
		p.ajouterAdherent(new Adherent("Marrero", "Gabriel", "(514) 972-1014"));
		
	}
	
}
