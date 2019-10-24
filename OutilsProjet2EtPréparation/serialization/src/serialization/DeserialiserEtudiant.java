package serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialiserEtudiant {



	public static void main(String[] args) throws IOException {
		
		 Etudiant etu= new Etudiant(0,"","",0);
		 
		 FileInputStream fichier = new FileInputStream("etudiant.ser"); 
		    
			ObjectInputStream is = new ObjectInputStream(fichier); 
			try {
				while((etu = (Etudiant) is.readObject()) != null){
					System.out.println(etu);
				 
				}
								
				}
				catch (EOFException e) {
					// TODO Auto-generated catch block
					
				}	catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
	
}
				
			
	
	