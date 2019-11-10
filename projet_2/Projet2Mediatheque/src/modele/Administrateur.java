package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Administrateur {
	
	static ArrayList<Prepose> lstPreposes=new ArrayList<Prepose>();
@SuppressWarnings("unchecked")
public void AjouterPrepose(String strNom, String strPrenom, String strAdresse, String strTelephone, String strMotDePasse )
{
	//int intNumeroPrepose=1900;
	
	//File fichierPreposes= new File("/Users/r.merzius/Desktop/fichierPreposes.ser");
	//File fichierPreposes= new File("C:/Users/rn.merzius/Downloads/test/fichierPreposes.ser");
	//File fichierPreposes= new File("C:/Users/GabrielMarrero/Downloads/test/fichierPreposes.ser");
	File fichierPreposes= new File("C:/Users/cg.marrero/Downloads/test/fichierPreposes.ser");
	int intNumeroEmploye=0; 
	int intNumAjout=19000;
	if(fichierPreposes.exists())
	{
		try {

			// d�s�rialisation des pr�pos�s
			FileInputStream fichier = new FileInputStream(fichierPreposes);

			ObjectInputStream entree = new ObjectInputStream(fichier);

			lstPreposes = (ArrayList<Prepose>) entree.readObject();
			fichier.close();
			entree.close();
			//intNumeroEmploye=Integer.parseInt(lstPreposes.get(lstPreposes.size()-1).getNoEmploye().substring(1));
		//	intNumeroEmploye++;
			System.out.println(intNumeroEmploye);
			lstPreposes.add(new Prepose("P"+intNumeroEmploye, strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));
			
			
			

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

public void connexion() 
{
	
	
}
public static ArrayList<Prepose> getlstPreposes()
{
	return lstPreposes;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Administrateur admin=new Administrateur();
		admin.AjouterPrepose("merzius", "paul", "inconnue", "(111) 111-1111", "Password1");
		System.out.println(Administrateur.lstPreposes.get(1).getNoEmploye());
		


	}

}
