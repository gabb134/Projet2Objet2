package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

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
	private String strSolde="0,00 $";
	private int intnbDVD;
	private int intnbPer;
	private int intnbLiv;
	private Amende amende=new Amende();
	private LocalDate datePretDvd1;
	private Amende amendeDvd1=new Amende();
	private String strAmendeDvd1;
	private LocalDate dateRetourDvd1;
	private LocalDate datePretDvd2;
	private Amende amendeDvd2=new Amende();
	private String strAmendeDvd2;
	private LocalDate dateRetourDvd2;
	private LocalDate datePretPer;
	private Amende amendePer=new Amende();
	private String strAmendePer;
	private LocalDate dateRetourPer;
	private LocalDate datePretLiv1;
	private LocalDate dateRetourLiv1;
	private Amende amendeLiv1=new Amende();
	private String strAmendeLiv1;
	private LocalDate datePretLiv2;
	private Amende amendeLiv2=new Amende();
	private String strAmendeLiv2;
	private LocalDate dateRetourLiv2;
	private LocalDate datePretLiv3;
	private Amende amendeLiv3=new Amende();
	private String strAmendeLiv3;
	private LocalDate dateRetourLiv3;
	private int noPret;
	
	
	public int getNoPret() {
		return noPret;
	}
	public void setNoPret(int noPret) {
		this.noPret = noPret;
	}
	public String getStrAmendeDvd1() {
		return strAmendeDvd1;
	}
	public void setStrAmendeDvd1(String strAmendeDvd1) {
		this.strAmendeDvd1 = strAmendeDvd1;
	}
	public String getStrAmendeDvd2() {
		return strAmendeDvd2;
	}
	public void setStrAmendeDvd2(String strAmendeDvd2) {
		this.strAmendeDvd2 = strAmendeDvd2;
	}
	public String getStrAmendePer() {
		return strAmendePer;
	}
	public void setStrAmendePer(String strAmendePer) {
		this.strAmendePer = strAmendePer;
	}
	public String getStrAmendeLiv1() {
		return strAmendeLiv1;
	}
	public void setStrAmendeLiv1(String strAmendeLiv1) {
		this.strAmendeLiv1 = strAmendeLiv1;
	}
	public String getStrAmendeLiv2() {
		return strAmendeLiv2;
	}
	public void setStrAmendeLiv2(String strAmendeLiv2) {
		this.strAmendeLiv2 = strAmendeLiv2;
	}
	public String getStrAmendeLiv3() {
		return strAmendeLiv3;
	}
	public void setStrAmendeLiv3(String strAmendeLiv3) {
		this.strAmendeLiv3 = strAmendeLiv3;
	}
	public Amende getAmendeDvd1() {
		return amendeDvd1;
	}
	public void setAmendeDvd1(Amende amendeDvd1) {
		this.amendeDvd1 = amendeDvd1;
	}
	public Amende getAmendeDvd2() {
		return amendeDvd2;
	}
	public void setAmendeDvd2(Amende amendeDvd2) {
		this.amendeDvd2 = amendeDvd2;
	}
	public Amende getAmendePer() {
		return amendePer;
	}
	public void setAmendePer(Amende amendePer) {
		this.amendePer = amendePer;
	}
	public Amende getAmendeLiv1() {
		return amendeLiv1;
	}
	public void setAmendeLiv1(Amende amendeLiv1) {
		this.amendeLiv1 = amendeLiv1;
	}
	public Amende getAmendeLiv2() {
		return amendeLiv2;
	}
	public void setAmendeLiv2(Amende amendeLiv2) {
		this.amendeLiv2 = amendeLiv2;
	}
	public Amende getAmendeLiv3() {
		return amendeLiv3;
	}
	public void setAmendeLiv3(Amende amendeLiv3) {
		this.amendeLiv3 = amendeLiv3;
	}
	public LocalDate getDateRetourDvd1() {
		return dateRetourDvd1;
	}
	public String getStrSolde() {
		return strSolde;
	}

	public void setStrSolde(String strSolde) {
		this.strSolde = strSolde;
	}

	public void setDateRetourDvd1(LocalDate dateRetourDvd1) {
		this.dateRetourDvd1 = dateRetourDvd1;
	}

	public LocalDate getDateRetourDvd2() {
		return dateRetourDvd2;
	}

	public void setDateRetourDvd2(LocalDate dateRetourDvd2) {
		this.dateRetourDvd2 = dateRetourDvd2;
	}

	public LocalDate getDateRetourPer() {
		return dateRetourPer;
	}

	public void setDateRetourPer(LocalDate dateRetourPer) {
		this.dateRetourPer = dateRetourPer;
	}

	public LocalDate getDateRetourLiv1() {
		return dateRetourLiv1;
	}

	public void setDateRetourLiv1(LocalDate dateRetourLiv1) {
		this.dateRetourLiv1 = dateRetourLiv1;
	}

	public LocalDate getDateRetourLiv2() {
		return dateRetourLiv2;
	}

	public void setDateRetourLiv2(LocalDate dateRetourLiv2) {
		this.dateRetourLiv2 = dateRetourLiv2;
	}

	public LocalDate getDateRetourLiv3() {
		return dateRetourLiv3;
	}

	public void setDateRetourLiv3(LocalDate dateRetourLiv3) {
		this.dateRetourLiv3 = dateRetourLiv3;
	}

	public LocalDate getDatePretLiv() {
		return datePretLiv;
	}

	public void setDatePretLiv(LocalDate datePretLiv) {
		this.datePretLiv = datePretLiv;
	}

	public void setDatePretDvd(LocalDate datePretDvd) {
		this.datePretDvd = datePretDvd;
	}

	public Amende getAmende() {
		return amende;
	}



	private LocalDate datePretDvd;

	private LocalDate datePretLiv;
	
	
	private ArrayList<Document> lstDocAdherent = new ArrayList<Document>();
	private ArrayList<DVD> lstDvdAdherent = new ArrayList<DVD>();
	private ArrayList<Livre> lstLivreAdherent = new ArrayList<Livre>();
	private ArrayList<Periodique> lstPeriodiqueAdherent = new ArrayList<Periodique>();

	
	public ArrayList<DVD> getLstDvdAdherent() {
		return lstDvdAdherent;
	}

	public void setLstDvdAdherent(ArrayList<DVD> lstDvdAdherent) {
		this.lstDvdAdherent = lstDvdAdherent;
	}

	public ArrayList<Livre> getLstLivreAdherent() {
		return lstLivreAdherent;
	}

	public void setLstLivreAdherent(ArrayList<Livre> lstLivreAdherent) {
		this.lstLivreAdherent = lstLivreAdherent;
	}

	public ArrayList<Periodique> getLstPeriodiqueAdherent() {
		return lstPeriodiqueAdherent;
	}

	public void setLstPeriodiqueAdherent(ArrayList<Periodique> lstPeriodiqueAdherent) {
		this.lstPeriodiqueAdherent = lstPeriodiqueAdherent;
	}

	public ArrayList<Document> getLstDocAdherent() {
		return lstDocAdherent;
	}

	public void setLstDocAdherent(ArrayList<Document> lstDocAdherent) {
		this.lstDocAdherent = lstDocAdherent;
	}

	public LocalDate getDatePretDvd() {
		return datePretDvd;
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
	public void ajouterDocument(Document doc) {
		lstDocAdherent.add(doc);
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
		LocalDate datedujour=LocalDate.now();
		LocalDate datederetour=LocalDate.now().minusDays(14);
		System.out.println("date de pret: "+datedujour);
		System.out.println("date de retour: "+datederetour);
		System.out.println(ChronoUnit.DAYS.between(datedujour, datederetour.plusDays(30)));
		//System.out.println(datedufutur);

	}

}
