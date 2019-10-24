package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialiserEtudiant { 

	public static void main(String[] args) {
		Etudiant etu1 = new Etudiant(123,"Dupond","Jean",85.5); 
	    Etudiant etu2= new Etudiant(124,"Dupond1","Je1",89.5); 
	    Etudiant etu3= new Etudiant(125,"Dupond2","Je2",88.5); 
		try { 
		      
		FileOutputStream fichier = new FileOutputStream("etudiant.ser"); 
	      
		ObjectOutputStream os = new ObjectOutputStream(fichier); 
		 os.writeObject(etu1);
		 
		 os.writeObject(etu2);
		 
		 os.writeObject(etu3);
		
	     os.close();
		} 
		    
		catch (IOException e) { 
		     
		e.printStackTrace(); 
		    
		} 
	}


}
