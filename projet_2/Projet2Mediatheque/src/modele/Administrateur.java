package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Administrateur {
	ArrayList<Prepose> lstPreposes=new ArrayList<Prepose>();
@SuppressWarnings("unchecked")
public void AjouterPrepose(String strNom, String strPrenom, String strAdresse, String strTelephone, String strMotDePasse )
{
	int intNumeroPrepose=1900;
	
	
	File fichierPreposes= new File("C:/Users/rn.merzius/Downloads/test/fichierPreposes.ser");
	//File fichierPreposes= new File("C:/Users/GabrielMarrero/Downloads/test/fichierPreposes.ser");
	//File fichierPreposes= new File("C:/Users/cg.marrero/Downloads/test/fichierPreposes.ser");
	String strNumeroEmploye="P"+intNumeroPrepose;
	if(fichierPreposes.exists())
	{
		try {

			// désérialisation des préposés
			FileInputStream fichier = new FileInputStream(fichierPreposes);

			ObjectInputStream entree = new ObjectInputStream(fichier);

			lstPreposes = (ArrayList<Prepose>) entree.readObject();
			fichier.close();
			entree.close();
			// Fin désérialization des préposés
			for(int i=0;i<lstPreposes.size();i++)
			{
				if(i==10)
					intNumeroPrepose=190;
				strNumeroEmploye="P"+intNumeroPrepose+i;
				if(lstPreposes.get(i).getNoEmploye().compareTo(strNumeroEmploye)!=0)
				{
					lstPreposes.add(new Prepose(strNumeroEmploye, strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));
					i=lstPreposes.size();
				}
				else if(i+1==lstPreposes.size())
				{
					lstPreposes.add(new Prepose("P19001", strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));
				}
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	else
	{
		lstPreposes.add(new Prepose(strNumeroEmploye+0, strMotDePasse, strAdresse, strNom, strPrenom, strTelephone));
	}
	// Sérialisation des préposés
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Administrateur admin=new Administrateur();
		admin.AjouterPrepose("merzius", "paul", "inconnue", "(111) 111-1111", "Password1");
		System.out.println(admin.lstPreposes.get(4).getNoEmploye());
		System.out.println(admin.lstPreposes.get(4).getPrenom());


	}

}
