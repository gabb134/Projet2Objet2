package modele;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ListeAdherents implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Adherent> lstAdherents = new ArrayList<Adherent>();
	private static ListeAdherents instance;
	
	
	


	@SuppressWarnings("unchecked")
	private ListeAdherents() {
		//deserialisation
		File fichierAdherents= new File("adherent.ser");
		
		if(fichierAdherents.exists())
		{
			try {

				// deserialisation des adherents
				FileInputStream fichier = new FileInputStream(fichierAdherents);

				ObjectInputStream entree = new ObjectInputStream(fichier);

				lstAdherents = 	(ArrayList<Adherent>) entree.readObject(); 
				fichier.close();
				entree.close();
 				//intNumeroAdherent = Integer.parseInt(liste.getLstAdherents().get(liste.getLstAdherents().size()-1).getStrNumeroAdherent().substring(1));
				//intNumeroAdherent++;
				
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
			//e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			
		}
		else {
			System.out.println("fichier n'existe pas");
		}
	}
	public ArrayList<Adherent> getLstAdherents() {
		return lstAdherents;
	}

	public static ListeAdherents getInstance() {
		if (instance == null) {
			//
			  instance = new ListeAdherents();
		}
			
			  return instance; 
		
	}
	
	public void serialisationAdherent() {
		
		
			try { 
			      
				FileOutputStream fichier = new FileOutputStream("adherent.ser"); 
			      
				ObjectOutputStream os = new ObjectOutputStream(fichier); 
				
				/*ArrayList<Adherent> lstAdherent = new ArrayList<Adherent>();
				lstAdherent.add(a1);
				lstAdherent.add(a2);*/
				
				 os.writeObject(ListeAdherents.getInstance().getLstAdherents());
				
				 
				
			
				
			     os.close();
				 System.out.println(ListeAdherents.getInstance().getLstAdherents());
				} 
				    
				catch (IOException e) { 
				     
				e.printStackTrace(); 
				    
				}
		
	}

	public void setLstAdherents(ArrayList<Adherent> lstAdherents) {
		this.lstAdherents = lstAdherents;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//prepose.ajouterAdherent("merzius", "paul", "Aucune adresse" , "(111) 111-1111", 0,0);
		//prepose.ajouterAdherent("marrero", "gab","Aucune adresse" ,"(222) 222-2222",0,0);
		
		/*Adherent a1 = new Adherent("marrero", "gab","Aucune adresse" ,"(222) 222-2222","allo",0,0);
		Adherent a2 = new Adherent("merzius", "paul", "Aucune adresse" , "(111) 111-1111","allo", 0,0);
		
		try { 
		      
			FileOutputStream fichier = new FileOutputStream("adherent.ser"); 
		      
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			ArrayList<Adherent> lstAdherent = new ArrayList<Adherent>();
			lstAdherent.add(a1);
			lstAdherent.add(a2);
			
			 os.writeObject(lstAdherent);
			
			 
			
		System.out.println("qllo");
			
		     os.close();
			} 
			    
			catch (IOException e) { 
			     
			e.printStackTrace(); 
			    
			} 
		
		System.out.println(ListeAdherents.getInstance().getLstAdherents());*/

	}

}
