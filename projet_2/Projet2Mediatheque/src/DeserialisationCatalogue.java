import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserialisationCatalogue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  // désérialiser le catalogue
		
		
		Catalogue catalogueDeserializer = null;
	
		
		try {
			FileInputStream fichier =new FileInputStream("C:/Users/GabrielMarrero/Downloads/test/fichier.ser");
			
			ObjectInputStream entree = new ObjectInputStream(fichier);
			
		
				catalogueDeserializer = (Catalogue) entree.readObject();
			
			
			fichier.close();
			entree.close();
			
			System.out.println("l'objet catalogue vient d'êetre deserlializer");
			//System.out.println(catalogueDeserializer);
			catalogueDeserializer.afficherDvd();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
