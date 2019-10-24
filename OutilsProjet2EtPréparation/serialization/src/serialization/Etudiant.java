package serialization;

import java.io.Serializable;

public class Etudiant implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int numDA;
  private  String nom;
  private String prenom;
  private double  moyenne;

 
  public Etudiant(int numDA, String nom, String prenom, double moyenne){
	  this.numDA= numDA;
	  this.nom = nom;
	  this.prenom = prenom;
	  this.moyenne = moyenne;
  
  }
  
  public String toString() {
	  return numDA+ " "+ nom + " " + prenom + " " + moyenne; 
  }
}
