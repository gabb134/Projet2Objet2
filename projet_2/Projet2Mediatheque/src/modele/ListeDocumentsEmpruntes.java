package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ListeDocumentsEmpruntes implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Document> lstDocumentsEmpruntes = new ArrayList<Document>();
	
	private ArrayList<Adherent> lstemprunter = new ArrayList<Adherent>();

	private static ListeDocumentsEmpruntes instance;
	
	private ListeDocumentsEmpruntes() {
		File fihcierDocEmprunts = new File("documentEmprunt.ser");
		
		if(fihcierDocEmprunts.exists())
		{
			try {

				// deserialisation des adherents
				FileInputStream fichier = new FileInputStream(fihcierDocEmprunts);

				ObjectInputStream entree = new ObjectInputStream(fichier);

				lstDocumentsEmpruntes = (ArrayList<Document>) entree.readObject(); 
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
		
			
		}else {
			System.out.println("fichier n'existe pas");
		}
	}
	public static ListeDocumentsEmpruntes getInstance() {
		if (instance == null) {
			//
			  instance = new ListeDocumentsEmpruntes();
		}
			
			  return instance; 
		
	}
	public void serialisationDocumentsEmpruntes() {
		
		
		try { 
		      
			FileOutputStream fichier = new FileOutputStream("documentEmprunt.ser"); 
		      
			ObjectOutputStream os = new ObjectOutputStream(fichier); 
			
			/*ArrayList<Adherent> lstAdherent = new ArrayList<Adherent>();
			lstAdherent.add(a1);
			lstAdherent.add(a2);*/
			
			 os.writeObject(ListeDocumentsEmpruntes.getInstance().getLstDocumentsEmpruntes());
			
			 
			
		
			
		     os.close();
			 System.out.println(ListeDocumentsEmpruntes.getInstance().getLstDocumentsEmpruntes());
			} 
			    
			catch (IOException e) { 
			     
			e.printStackTrace(); 
			    
			}
	
}
	
	public void emprunterPar(Adherent adherent, Document document) {
		
		adherent.getLstDocAdherent().add(document);
		System.out.println("ajout du document pour l'adhérent "+adherent.getStrNom());
	}

	public ArrayList<Adherent> getLstemprunter() {
		return lstemprunter;
	}
	public void setLstemprunter(ArrayList<Adherent> lstemprunter) {
		this.lstemprunter = lstemprunter;
	}
	public ArrayList<Document> getLstDocumentsEmpruntes() {
		return lstDocumentsEmpruntes;
	}

	public void setLstDocumentsEmpruntes(ArrayList<Document> lstDocumentsEmpruntes) {
		this.lstDocumentsEmpruntes = lstDocumentsEmpruntes;
	}
}
