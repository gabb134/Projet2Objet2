package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Administrateur {

	static ArrayList<Prepose> lstPreposes=ListePreposes.getInstance().getLstPreposes();
	@SuppressWarnings("unchecked")
	public void AjouterPrepose(String strNom, String strPrenom, String strAdresse, String strTelephone, String strMotDePasse )
	{
		//int intNumeroPrepose=1900;

		//File fichierPreposes= new File("/Users/r.merzius/Desktop/fichierPreposes.ser");
		//File fichierPreposes= new File("preposes.ser");
		//File fichierPreposes= new File("C:/Users/GabrielMarrero/Downloads/test/fichierPreposes.ser");
		//File fichierPreposes= new File("C:/Users/cg.marrero/Downloads/test/fichierPreposes.ser");
		int intNumeroEmploye=0; 
		int intNumAjout=19000;
		try{
			if(lstPreposes.get(0)!=null)
			{




				intNumeroEmploye=Integer.parseInt(lstPreposes.get(lstPreposes.size()-1).getNoEmploye().substring(1));
				intNumeroEmploye++;
				System.out.println(intNumeroEmploye);
				lstPreposes.add(new Prepose("P"+intNumeroEmploye, strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));





			}

		}
		catch (Exception e) {
			lstPreposes.add(new Prepose("P"+Integer.toString(intNumAjout), strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));}

		ListePreposes.serialisationPrepose();
	}

	public void connexion() 
	{


	}
	public static Boolean supprimerPrepose(String strNumeroEmploye)
	{
		Boolean booTrouver=false;
		for(int i=0;i<lstPreposes.size();i++)
		{
			if(lstPreposes.get(i).getNoEmploye().equals(strNumeroEmploye))
			{
				lstPreposes.remove(i);
				booTrouver=true;
			}
		}
		ListePreposes.serialisationPrepose();
		return booTrouver;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Administrateur admin=new Administrateur();
		admin.AjouterPrepose("merzius", "paul", "inconnue", "(111) 111-1111", "Password1");
		//System.out.println(Administrateur.lstPreposes.get(5).getNoEmploye());

		//if(Administrateur.supprimerPrepose("P19002"))
		//	System.out.println("Supprimé avec succès");

	}

}
