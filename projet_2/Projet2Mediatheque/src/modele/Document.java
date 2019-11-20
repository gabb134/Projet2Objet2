package modele;
import java.io.Serializable;
import java.time.LocalDate;

public class Document implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String  noDoc;
	private String  titre;
	private LocalDate  dateParution;
	private String disponible;
	private Adherent emprunteur;
	private int intNumDocEmprunte;
	
	public Document(String noDoc, String titre, LocalDate dateParution, String disponible,Adherent emprunteur) {
		super();
		this.noDoc = noDoc;
		this.titre = titre;
		this.dateParution = dateParution;
		this.disponible = disponible;
		this.emprunteur = emprunteur;
	}

	@Override
	public String toString() {
		return "noDoc=" + noDoc + ", titre=" + titre + ", dateParution=" + dateParution + ", disponible="
				+ disponible + emprunteur;
	}
	
	public int getIntNumDocEmprunte() {
		return intNumDocEmprunte;
	}

	public void setIntNumDocEmprunte(int intNumDocEmprunte) {
		this.intNumDocEmprunte = intNumDocEmprunte;
	}

	public String getNoDoc() {
		return noDoc;
	}

	public void setNoDoc(String noDoc) {
		this.noDoc = noDoc;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalDate getDateParution() {
		return dateParution;
	}

	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}
	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}