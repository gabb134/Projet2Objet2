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
	 static ArrayList<Adherent> lstAdherents=new ArrayList<Adherent>();
	
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
	
	
	public void afficherAdherents(Adherent adherent) {
		
	}
	

	@SuppressWarnings("unchecked")
	public void ajouterAdherent(String strNom,String strPrenom, String strAdresse,String strNumeroTelephone, int intNbPrets,int intSolde)  {
		//int intNumeroPrepose=1900;
		
		File fichierAdherents= new File("/Users/r.merzius/Desktop/fichierAdherents.ser");
		//File fichierAdherents= new File("C:/Users/rn.merzius/Downloads/test/fichierAdherents.ser");
		//File fichierAdherents= new File("C:/Users/GabrielMarrero/Downloads/test/fichierAdherents.ser");
		//File fichierAdherents= new File("C:/Users/cg.marrero/Downloads/test/fichierAdherents.ser");
		int intNumeroAdherent=0; 
		int intNumAjout=19000;
		if(fichierAdherents.exists())
		{
			try {

				// d�s�rialisation des adherents
				FileInputStream fichier = new FileInputStream(fichierAdherents);

				ObjectInputStream entree = new ObjectInputStream(fichier);

				lstAdherents = (ArrayList<Adherent>) entree.readObject();
				fichier.close();
				entree.close();
 				intNumeroAdherent = Integer.parseInt(lstAdherents.get(lstAdherents.size()-1).getStrNumeroAdherent().substring(1));
				intNumeroAdherent++;
				
				System.out.println(intNumeroAdherent);
				lstAdherents.add(new Adherent("A"+Integer.toString(intNumeroAdherent),strNom,strPrenom, strAdresse ,strNumeroTelephone, intNbPrets,intSolde));
				
				
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		else
		{
			
			lstAdherents.add(new Adherent("A"+Integer.toString(intNumAjout),strNom,strPrenom, strAdresse ,strNumeroTelephone, intNbPrets,intSolde));
					
		}
		// Sérialisation des adhérents
		try {
 			FileOutputStream fichier = new FileOutputStream(fichierAdherents);
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);
			sortie.writeObject(lstAdherents);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prepose prepose = new Prepose();
		prepose.ajouterAdherent("merzius", "paul", "Aucune adresse" , "(111) 111-1111", 0,0);
		prepose.ajouterAdherent("marrero", "gab","Aucune adresse" ,"(222) 222-2222",0,0);
		//System.out.println(lstAdherents.get(1).getStrNumeroAdherent());
		//System.out.println(lstAdherents.get(0).getStrNumeroAdherent());
		
		for(Adherent a:lstAdherents) {
			System.out.println(a.getStrNumeroAdherent());
			System.out.println("prenom: "+a.getStrPrenom()+" nom: "+a.getStrNom());
		}
			


	}
}
