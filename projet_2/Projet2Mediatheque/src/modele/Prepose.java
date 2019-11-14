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
		public Prepose(){
			
		}
	
	
	public void afficherAdherents(ListeAdherents liste) {
		
	}
	

	@SuppressWarnings("unchecked")
	public void ajouterAdherent(Adherent adherent)  {
		
		//voir comment attribuer un Numero d'adhérent 
		
		ListeAdherents liste = ListeAdherents.getInstance();
		
		int numAhderent = 1900;
		
		//pour ne pas repeter le meme adhésrent
		boolean bootrouver = false;
		for(int i = 0; i< liste.getLstAdherents().size()&& !bootrouver;i++) {
			if(!liste.getLstAdherents().get(i).getStrNumeroAdherent().equals(adherent.getStrNumeroAdherent())) {
				bootrouver=true;
				System.out.println(liste.getLstAdherents().get(i));
			}
			else 
				bootrouver = false;
		}
		
		if(bootrouver ==true) {
			
			
			adherent.setStrNumeroAdherent(Integer.toString(numAhderent));
			liste.getLstAdherents().add(adherent);
			numAhderent++;
			System.out.println("ajouté");
		}
		else {
			System.out.println("même adhérent");
		}
		

		
		
		
		/*//int intNumeroPrepose=1900;
		
		//File fichierAdherents= new File("/Users/r.merzius/Desktop/fichierAdherents.ser");
		//File fichierAdherents= new File("C:/Users/rn.merzius/Downloads/test/fichierAdherents.ser");
		File fichierAdherents= new File("C:/Users/GabrielMarrero/Downloads/test/fichierAdherents.ser");
		//File fichierAdherents= new File("C:/Users/cg.marrero/Downloads/test/fichierAdherents.ser");
		//int intNumeroAdherent=0; 
		//int intNumAjout=19000;
		if(fichierAdherents.exists())
		{
			try {

				// deserialisation des adherents
				FileInputStream fichier = new FileInputStream(fichierAdherents);

				ObjectInputStream entree = new ObjectInputStream(fichier);

				liste.setLstAdherents((ArrayList<Adherent>) entree.readObject()); ;
				fichier.close();
				entree.close();
 				//intNumeroAdherent = Integer.parseInt(liste.getLstAdherents().get(liste.getLstAdherents().size()-1).getStrNumeroAdherent().substring(1));
				//intNumeroAdherent++;
				
				//System.out.println(intNumeroAdherent);
				liste.getLstAdherents().add(adherent);
				
				
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		else
		{
			try {
	 			FileOutputStream fichier = new FileOutputStream(fichierAdherents);
				ObjectOutputStream sortie = new ObjectOutputStream(fichier);
				sortie.writeObject(liste.getLstAdherents());
				sortie.close();
				fichier.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			liste.getLstAdherents().add(adherent);
					
		}
		// serialization des adhÃ©rents*/
		
	}
	public void supprimerAdherent(Adherent adherent) {
	ListeAdherents liste = ListeAdherents.getInstance();
		
		
		liste.getLstAdherents().remove(adherent);
		
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prepose prepose = new Prepose();
	
		ListeAdherents liste = ListeAdherents.getInstance();
		Adherent a1 =new Adherent("12", "allossssttttt", "tets", "afge", "656546", 2, 2);
		Adherent a2 =new Adherent("3", "klk", "tets", "afge", "656546", 2, 2);
	
		//a1.setStrNumeroAdherent(1+a1.getStrNumeroAdherent());
		
		
		prepose.ajouterAdherent(a1);
		prepose.ajouterAdherent(a2);
		
		
		//liste.serialisationAdherent();
		
		//prepose.supprimerAdherent(adherent);
		
		//System.out.println(liste.getLstAdherents().get(0).getStrNumeroAdherent());
		
		
		
		
			


	}
	
}
