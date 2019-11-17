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

public class ListePreposes implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Prepose> lstPreposes = new ArrayList<Prepose>();
	private static ListePreposes instance;
	
	
	


	@SuppressWarnings("unchecked")
	private ListePreposes() {
		//deserialisation
		File fichierPreposes= new File("preposes.ser");
		
		if(fichierPreposes.exists())
		{
			try {

				// deserialisation des adherents
				FileInputStream fichier = new FileInputStream(fichierPreposes);

				ObjectInputStream entree = new ObjectInputStream(fichier);

				lstPreposes = 	(ArrayList<Prepose>) entree.readObject(); 
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
	public ArrayList<Prepose> getLstPreposes() {
		return lstPreposes;
	}

	public static ListePreposes getInstance() {
		if (instance == null) {
			//
			  instance = new ListePreposes();
		}
			
			  return instance; 
		
	}
	
	public static void serialisationPrepose() {
		
		
			try { 
			      
				FileOutputStream fichier = new FileOutputStream("preposes.ser"); 
			      
				ObjectOutputStream os = new ObjectOutputStream(fichier); 
				
				/*ArrayList<Adherent> lstAdherent = new ArrayList<Adherent>();
				lstAdherent.add(a1);
				lstAdherent.add(a2);*/
				
				 os.writeObject(ListePreposes.getInstance().getLstPreposes());
				
				 
				
			
				
			     os.close();
				 System.out.println(ListePreposes.getInstance().getLstPreposes());
				} 
				    
				catch (IOException e) { 
				     
				e.printStackTrace(); 
				    
				}
		
	}

	public void setLstPreposes(ArrayList<Prepose> lstPreposes) {
		this.lstPreposes = lstPreposes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//prepose.ajouterAdherent("merzius", "paul", "Aucune adresse" , "(111) 111-1111", 0,0);
		//prepose.ajouterAdherent("marrero", "gab","Aucune adresse" ,"(222) 222-2222",0,0);
		
		Prepose p1 = new Prepose("P19000","Password1",  "inconnue","merzius","paul" ,"(111) 111-1111" );
		Prepose p2 = new Prepose("P19001","Password1","inconnue" , "marrero","gab" ,"(222) 222-2222" );
		
		try { 
		      
			FileOutputStream fichier = new FileOutputStream("preposes.ser"); 
		      
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			ArrayList<Prepose> lstPreposes = new ArrayList<Prepose>();
			lstPreposes.add(p1);
			lstPreposes.add(p2);
			
			 os.writeObject(lstPreposes);
			
			 
			
		System.out.println("qllo");
			
		     os.close();
			} 
			    
			catch (IOException e) { 
			     
			e.printStackTrace(); 
			    
			} 
		
		System.out.println(ListePreposes.getInstance().getLstPreposes());

	}

}
