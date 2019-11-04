package modele;

import java.io.File;
import java.io.FileInputStream;
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
	ArrayList<Adherent> lstAdherents=new ArrayList<Adherent>();
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
	
	
	public void afficherAdherents(Adherent adherent) {
		
	}
	
	public void ajouterAdherent(Adherent adherent) {
		int intNumeroPrepose=1900;
		
		File fichierAdherents= new File("/Users/r.merzius/Desktop/fichierAdherents.ser");
		//File fichierPreposes= new File("C:/Users/rn.merzius/Downloads/test/fichierAdherents.ser");
		//File fichierPreposes= new File("C:/Users/GabrielMarrero/Downloads/test/fichierAdherents.ser");
		//File fichierPreposes= new File("C:/Users/cg.marrero/Downloads/test/fichierAdherents.ser");
		int intNumeroAdherent=0; 
		int intNumAjout=19000;
		if(fichierAdherents.exists())
		{
			try {

				// d�s�rialisation des pr�pos�s
				FileInputStream fichier = new FileInputStream(fichierAdherents);

				ObjectInputStream entree = new ObjectInputStream(fichier);

				lstAdherents = (ArrayList<Adherent>) entree.readObject();
				fichier.close();
				entree.close();
				intNumeroAdherent=Integer.parseInt(lstAdherents.get(lstAdherents.size()-1).getNoEmploye().substring(1));
				intNumeroAdherent++;
				lstAdherents.add(new Adherent("P"+intNumeroAdherent, strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));
				
				
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		else
		{
			lstPreposes.add(new Prepose("P"+Integer.toString(intNumAjout), strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));
		}
		// S�rialisation des pr�pos�s
		try {
			FileOutputStream fichier = new FileOutputStream(fichierPreposes);
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);
			sortie.writeObject(lstPreposes);
			sortie.close();
			fichier.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void supprimerAdherent(Adherent adherent) {
		
	}
	public String getNoEmploye()
	{
		return strNumEmploye;
	}
	public String getMotDePasse()
	{
		return strMotDePasse;
	}
	public String getPrenom()
	{
		return strPrenom;
	}
	
	
}
