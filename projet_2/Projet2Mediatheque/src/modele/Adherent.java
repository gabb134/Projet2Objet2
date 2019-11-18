package modele;

import java.io.Serializable;

public class Adherent implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String strNom;
	private String strPrenom;
	private String strNumeroTelephone;
	private String strNumeroAdherent;
	private String strAdresse;

	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}

	private int intNbPrets;
	private double dblSolde;

	public Adherent(String strNumeroAdherent, String strNom, String strPrenom, String strAdresse,
			String strNumeroTelephone, int intNbPrets, double dblSolde) {
		this.strNumeroAdherent = strNumeroAdherent;
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strAdresse = strAdresse;
		this.strNumeroTelephone = strNumeroTelephone;
		this.intNbPrets = intNbPrets;
		this.dblSolde = dblSolde;
	}

	public int getIntNbPrets() {
		return intNbPrets;
	}

	public double getDblSolde() {
		return dblSolde;
	}

	public String getStrAdresse() {
		return strAdresse;
	}

	public void setIntNbPrets(int intNbPrets) {
		this.intNbPrets = intNbPrets;
	}

	public void setDblSolde(double dblSolde) {
		this.dblSolde = dblSolde;
	}

	public double getdblSolde() {
		return dblSolde;
	}

	@Override
	public String toString() {
		return "Adherent [strNom=" + strNom + ", strPrenom=" + strPrenom + ", strNumeroTelephone=" + strNumeroTelephone
				+ ", strNumeroAdherent=" + strNumeroAdherent + ", strAdresse=" + strAdresse + "]";
	}

	public String getStrNom() {
		return strNom;
	}

	public void setStrNom(String strNom) {
		this.strNom = strNom;
	}

	public String getStrPrenom() {
		return strPrenom;
	}

	public void setStrPrenom(String strPrenom) {
		this.strPrenom = strPrenom;
	}

	public String getStrNumeroTelephone() {
		return strNumeroTelephone;
	}

	public int getintNbPrets() {
		return intNbPrets;
	}

	public void setStrNumeroTelephone(String strNumeroTelephone) {
		this.strNumeroTelephone = strNumeroTelephone;
	}

	public String getStrNumeroAdherent() {
		return strNumeroAdherent;
	}

	public void setStrNumeroAdherent(String strNumeroAdherent) {
		this.strNumeroAdherent = strNumeroAdherent;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
