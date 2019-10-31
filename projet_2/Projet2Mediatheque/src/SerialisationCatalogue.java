

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modele.Catalogue;


public class SerialisationCatalogue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//S�rialisation du catalogue
		
		
		Catalogue catalogueSerialisation= Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");
		String fichierSerial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
		try {
			FileOutputStream fichier = new FileOutputStream(fichierSerial);
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);
			
			sortie.writeObject(catalogueSerialisation);
			
			sortie.close();
			fichier.close();
			
			System.out.println("l'objet catalogue vient d'�tre seralizer");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
