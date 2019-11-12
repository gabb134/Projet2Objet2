package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class ListeAdherents implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Adherent> lstAdherents = new ArrayList<Adherent>(); 
	private static ListeAdherents instance;
	
	public ArrayList<Adherent> getLstAdherents() {
		return lstAdherents;
	}

	public static ListeAdherents getInstance() {
		if (instance == null) {
			
		}
			  instance = new ListeAdherents();
			  return instance; 
		
	}

	public void setLstAdherents(ArrayList<Adherent> lstAdherents) {
		this.lstAdherents = lstAdherents;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
