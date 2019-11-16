package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Prepose implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strNumEmploye;
	private String strMotDePasse;
	private String strAdresse;

	private String strNom;
	private String strPrenom;
	private String strTelephone;
	static ListeAdherents liste = ListeAdherents.getInstance();

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

	public Prepose() {

	}

	public void afficherAdherents(ListeAdherents liste) {

	}

	@SuppressWarnings("unchecked")
	public void ajouterAdherent(Adherent adherent) {

		// voir comment attribuer un Numero d'adhérent

		// ListeAdherents liste = ListeAdherents.getInstance();

		int intNumAjout = 1900;
		int intNumAdherent = 0;

		// pour ne pas repeter le meme adhésrent

		boolean bootrouver = false;

		try {
			if (liste.getLstAdherents().get(0) != null) {

				for (int i = 0; i < liste.getLstAdherents().size() && !bootrouver; i++) {
					if (liste.getLstAdherents().get(i).getStrNumeroTelephone().equals(adherent.getStrNumeroTelephone())&&liste.getLstAdherents().get(i).getStrAdresse().equals(adherent.getStrAdresse()) ) {
						bootrouver = true;
						// System.out.println(liste.getLstAdherents().get(i));
					}
				}
				if (bootrouver) {// si on ajoute un adherent avec la mem adresse et le meme numero de telephone
					System.out.println("meme adherent");
				} else {
					intNumAdherent = Integer.parseInt(
							liste.getLstAdherents().get(liste.getLstAdherents().size() - 1).getStrNumeroAdherent());// Pour
																													// avoir
																													// le
																													// dernier
																													// numero
					intNumAdherent++;
					// System.out.println(intNumAdherent);
					// liste.getLstAdherents().add(new Adherent(strNumeroAdherent, strNom,
					// strPrenom, strAdresse, strNumeroTelephone, intNbPrets, intSolde))
					adherent.setStrNumeroAdherent(String.valueOf(intNumAdherent));
					liste.getLstAdherents().add(adherent);
				}

			}
		} catch (Exception e) {
			adherent.setStrNumeroAdherent(intNumAjout + intNumAdherent + "");
			liste.getLstAdherents().add(adherent);
		}

	}

	public void supprimerAdherent(Adherent adherent) {

		liste.getLstAdherents().remove(adherent);

	}

	public String getNoEmploye() {
		return strNumEmploye;
	}

	public String getMotDePasse() {
		return strMotDePasse;
	}

	public String getPrenom() {
		return strPrenom;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prepose prepose = new Prepose();

		ListeAdherents liste = ListeAdherents.getInstance();
		Adherent a1 = new Adherent("2", "allossssttttt", "tets", "afge", "656546", 2, 2);
		Adherent a2 = new Adherent("3", "klk", "tets", "afge", "656546", 2, 2);
		Adherent a3 = new Adherent("4", "klk", "tets", "afge", "656546", 2, 2);

		// a1.setStrNumeroAdherent(1+a1.getStrNumeroAdherent());
		liste.serialisationAdherent();

		prepose.ajouterAdherent(a1);
		prepose.ajouterAdherent(a2);
		prepose.ajouterAdherent(a3);

		for (int i = 0; i < liste.getLstAdherents().size(); i++) {
			System.out.println(liste.getLstAdherents().get(i).getStrNumeroAdherent());
		}

		// prepose.supprimerAdherent(adherent);

		// System.out.println(liste.getLstAdherents().get(0).getStrNumeroAdherent());

	}

}
