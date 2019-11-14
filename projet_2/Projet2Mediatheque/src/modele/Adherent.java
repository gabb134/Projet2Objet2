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
private int intNbPrets;
private int intSolde;

public Adherent (String strNumeroAdherent,String strNom,String strPrenom, String strAdresse,String strNumeroTelephone, int intNbPrets,int intSolde){
	this.strNumeroAdherent=strNumeroAdherent;
	this.strNom=strNom;
	this.strPrenom=strPrenom;
	this.strAdresse=strAdresse;
	this.strNumeroTelephone=strNumeroTelephone;
	this.intNbPrets=intNbPrets;
	this.intSolde=intSolde;
}



@Override
public String toString() {
	return "Adherent [strNom=" + strNom + ", strPrenom=" + strPrenom + ", strNumeroTelephone=" + strNumeroTelephone
			+ "]";
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
