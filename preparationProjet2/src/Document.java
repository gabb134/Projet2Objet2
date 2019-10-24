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
	
	public Document(String noDoc, String titre, LocalDate dateParution, String disponible) {
		super();
		this.noDoc = noDoc;
		this.titre = titre;
		this.dateParution = dateParution;
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "noDoc=" + noDoc + ", titre=" + titre + ", dateParution=" + dateParution + ", disponible="
				+ disponible ;
	}
	
	
	
}