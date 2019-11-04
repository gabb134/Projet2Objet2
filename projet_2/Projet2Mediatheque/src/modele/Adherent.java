package modele;

public class Adherent {
private String strNom;
private String strPrenom;
private String strNumeroTelephone;

public Adherent (String strNom,String strPrenom,String strNumeroTelephone){
	this.strNom=strNom;
	this.strPrenom=strPrenom;
	this.strNumeroTelephone=strNumeroTelephone;
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




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
