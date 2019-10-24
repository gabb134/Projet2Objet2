import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public final class Catalogue implements Serializable {

	// Complétez pour programmer la classe comme singleton
	// Le constructeur permet de remplir les listes suivantes à partir des fichiers
	// textes Livres.txt et periodiques.txt et DVD.txt

	private static final long serialVersionUID = 1L;
	private static Catalogue instance;
	private ArrayList<Document> lstDocuments = new ArrayList<>();
	private ArrayList<Livre> lstLivres = new ArrayList<>();
	private ArrayList<Periodique> lstPeriodiques = new ArrayList<>();
	private ArrayList<DVD> lstDvd = new ArrayList<>();

	public Catalogue(String fichierLivre, String fichierPeriodique, String fichierDvd) {

		// Pour le fichier livre
		BufferedReader brFichierLivre = null;

		String strLigne1;
		StringTokenizer st;
		String noDoc = "";
		String titre = "";
		LocalDate dateParution = null;
		String auteur = "";

		try {
			brFichierLivre = new BufferedReader(new FileReader(fichierLivre));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			while ((strLigne1 = brFichierLivre.readLine()) != null) {

				try {
				
					st = new StringTokenizer(strLigne1, ",");
				
					noDoc = st.nextToken().trim();
					
					//System.out.println("allo");
					titre = st.nextToken().trim();
				
					dateParution = LocalDate.parse(st.nextToken().trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					auteur = st.nextToken().trim();
					//disponible = st.nextToken().trim();
//					/System.out.println(disponible);
					
					//System.out.println(noDoc);

					Livre livre = new Livre(noDoc, titre, dateParution, "Oui", null, auteur);
					lstLivres.add(livre);
				
					
				} catch (NoSuchElementException e) {

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

		// Pour le fichier periodique
		BufferedReader brFichierPeriodique = null;

		try {
			brFichierPeriodique = new BufferedReader(new FileReader(fichierPeriodique));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String noDocP;
		String titreP;
		LocalDate dateParutionP;
		int noVolume;
		int noPeriodique;
		String strLigne2;
		StringTokenizer st2 = null;

		try {
			brFichierPeriodique = new BufferedReader(new FileReader(fichierPeriodique));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			while ((strLigne2 = brFichierPeriodique.readLine()) != null) {

				try {
					st2 = new StringTokenizer(strLigne2, ",");
					noDocP = st2.nextToken().trim();
					titreP = st2.nextToken().trim();
					dateParutionP = LocalDate.parse(st2.nextToken().trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					noVolume = Integer.parseInt(st2.nextToken().trim());
					noPeriodique = Integer.parseInt(st2.nextToken().trim());
					
					Periodique periodique = new Periodique(noDocP, titreP, dateParutionP, "oui", noVolume, noPeriodique);
					
					lstPeriodiques.add(periodique);
					
				}catch(NoSuchElementException e) {
					
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

		// Pour le fichier Dvd
		BufferedReader brFichierDvd = null;
		try {
			brFichierDvd = new BufferedReader(new FileReader(fichierDvd));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String strLigne3;
		StringTokenizer st3 = null;
		String noDocD;
		String titreD;
		LocalDate dateParutionD; 
		int nbDisques;
		String strRealisateur;

		try {
			brFichierDvd = new BufferedReader(new FileReader(fichierDvd));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			while ((strLigne3 = brFichierDvd.readLine()) != null) {
				st3 = new StringTokenizer(strLigne3, ",");
				noDocD = st3.nextToken().trim();
				titreD = st3.nextToken().trim();
				dateParutionD = LocalDate.parse(st3.nextToken().trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				nbDisques = Integer.parseInt(st3.nextToken().trim());
				strRealisateur = st3.nextToken().trim();
				DVD dvd = new DVD(noDocD, titreD, dateParutionD, "oui", nbDisques, strRealisateur);
				
				lstDvd.add(dvd);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public void afficherLivre() {
		for(Livre l:lstLivres)
			System.out.println(l);
	}
	public void afficherPeriodique() {
		for(Periodique p:lstPeriodiques)
			System.out.println(p);
	}
	public void afficherDvd() {
		for(DVD d:lstDvd)
			System.out.println(d);
	}

	public static void main(String[] args) {
		Catalogue c = new Catalogue("Livres.txt", "Periodiques.txt", "DVD.txt");
		//c.afficherLivre();
		//c.afficherPeriodique();
		c.afficherDvd();
	}

}
