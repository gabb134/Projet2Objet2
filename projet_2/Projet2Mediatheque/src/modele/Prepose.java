package modele;

import java.io.Serializable;

public class Prepose implements Serializable{

	private String strNumEmploye;
	private String strMotDePasse;
	private String strAdresse;
	private String strNom;
	private String strPrenom;
	private String strTelephone;
	public Prepose(String strNumEmploye, String strMotDePasse, String strAdresse, String strNom, String strPrenom,
			String strTelephone) {
		super();
		this.strNumEmploye = strNumEmploye;
		this.strMotDePasse = strMotDePasse;
		this.strAdresse = strAdresse;
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strTelephone = strTelephone;
	}
	
	
	public void afficherAdherents(Adherent adherent) {
		
	}
	
	public void ajouterAdherent(Adherent adherent) {
		
	}
	public void supprimerAdherent(Adherent adherent) {
		
	}
	public String getNoEmploye()
	{
		return strNumEmploye;
	}
	public String getPrenom()
	{
		return strPrenom;
	}
	
}
