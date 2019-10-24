
import java.time.LocalDate;





public class DVD extends Document{
	
	private int  nbDisques;
	private String strRealisateur;
	public DVD(String noDoc, String titre, LocalDate dateParution, String disponible, 
			   int nbDisques, String strRealisateur) {
		
		super(noDoc, titre, dateParution, disponible);
		this.nbDisques = nbDisques;
		this.strRealisateur = strRealisateur;
	}
	
	public String toString() {
		return " DVD :" + super.toString()+ "nbDisques: " +this.nbDisques+ " Réalisateur: "+ this.strRealisateur; 
	}
}
