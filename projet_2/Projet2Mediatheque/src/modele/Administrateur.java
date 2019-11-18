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
	public void AjouterPrepose(Prepose prepose)
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
				prepose.setNoEmploye("P"+intNumeroEmploye);
				lstPreposes.add( prepose);





			}

		}
		catch (Exception e) {
			prepose.setNoEmploye("P"+Integer.toString(intNumAjout));
			lstPreposes.add(prepose);}

		ListePreposes.serialisationPrepose();
	}

	public void connexion() 
	{


	}
	public void supprimerPrepose(Prepose prepose)
	{
		try {
			if (lstPreposes.get(lstPreposes.size() - 1) != null) {
				lstPreposes.remove(prepose);
			}
			}catch(Exception e) {
			
			}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Administrateur admin=new Administrateur();
		Prepose prep=new Prepose("","merzius", "paul", "inconnue", "(111) 111-1111", "Password1");
		admin.AjouterPrepose(prep);
		//System.out.println(Administrateur.lstPreposes.get(5).getNoEmploye());

		//if(Administrateur.supprimerPrepose("P19002"))
		//	System.out.println("Supprimé avec succès");

	}

}
