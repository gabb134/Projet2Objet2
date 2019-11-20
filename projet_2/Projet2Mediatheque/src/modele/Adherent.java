package modele;

import java.io.Serializable;
import java.time.LocalDate;

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
	private int intnbDVD;
	private int intnbPer;
	private int intnbLiv;
	private Amende amende=null;
	private LocalDate datePretDvd1;
	private LocalDate datePretDvd2;
	private LocalDate datePretPer;
	private LocalDate datePretLiv1;
	private LocalDate datePretLiv2;
	private LocalDate datePretLiv3;
	public Amende getAmende() {
		return amende;
	}

	public void setAmende(Amende amende) {
		this.amende = amende;
	}

	public LocalDate getDatePretDvd1() {
		return datePretDvd1;
	}

	public void setDatePretDvd1(LocalDate datePretDvd1) {
		this.datePretDvd1 = datePretDvd1;
	}
	public LocalDate getDatePretDvd2() {
		return datePretDvd2;
	}

	public void setDatePretDvd2(LocalDate datePretDvd2) {
		this.datePretDvd2 = datePretDvd2;
	}
	public LocalDate getDatePretPer() {
		return datePretPer;
	}

	public void setDatePretPer(LocalDate datePretPer) {
		this.datePretPer = datePretPer;
	}

	public LocalDate getDatePretLiv1() {
		return datePretLiv1;
	}

	public void setDatePretLiv1(LocalDate datePretLiv1) {
		this.datePretLiv1 = datePretLiv1;
	}
	public LocalDate getDatePretLiv2() {
		return datePretLiv2;
	}

	public void setDatePretLiv2(LocalDate datePretLiv2) {
		this.datePretLiv2 = datePretLiv2;
	}
	public LocalDate getDatePretLiv3() {
		return datePretLiv3;
	}

	public void setDatePretLiv3(LocalDate datePretLiv3) {
		this.datePretLiv3 = datePretLiv3;
	}
	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}

	private int intNbPrets;
	private double dblSolde;

	public Adherent(String strNumeroAdherent, String strNom, String strPrenom, String strAdresse,
			String strNumeroTelephone, int intNbPrets, double dblSolde, int intnbDVD, int intnbPer, int intnbLiv ) {
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

	public int getIntnbDVD() {
		return intnbDVD;
	}

	public void setIntnbDVD(int intnbDVD) {
		this.intnbDVD = intnbDVD;
	}

	public int getIntnbPer() {
		return intnbPer;
	}

	public void setIntnbPer(int intnbPer) {
		this.intnbPer = intnbPer;
	}

	public int getIntnbLiv() {
		return intnbLiv;
	}

	public void setIntnbLiv(int intnbLiv) {
		this.intnbLiv = intnbLiv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
